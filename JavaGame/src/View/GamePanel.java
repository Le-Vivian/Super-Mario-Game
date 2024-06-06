package View;

import java.awt.Dimension;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Model.CollisionChecker;
import Model.Enemy;
import Model.KeyHandler;
import Model.Player;
import Model.entity;
import controller.Controller;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

/**
 * main game controlelr , creates the loop and manages most inner working of the
 * game
 * 
 * @author justi main game controller
 */
public class GamePanel extends JPanel implements Runnable {
	Boolean multiplayer;
	int mapNum = 1;
	private UIElements ui;
	GameCompleteWindow gameComplete;
	GameOverWindow gameOver;
	public Boolean timeToExit = false;
	MainFrame mainframe;
	entity[] monsterArray = new entity[5];

	private int score = -1;
	// screen settings constants
	final int ORIGINALTILESIZE = 16;
	final int SCALE = 3;
	protected final int TILESIZE = ORIGINALTILESIZE * SCALE; // 48 X 48 pixels tile
	protected final int MAXSCREENCOLLUMN = 16;
	protected final int MAXSCREENROW = 12;
	protected final int SCREENWIDTH = TILESIZE * MAXSCREENCOLLUMN; // 760 pixels
	protected final int SCREENHEIGHT = TILESIZE * MAXSCREENROW; // 576 pixlels

	public final int maxWorldCol = 207;
	public final int maxWorldRow = 12;
	public final int worldWidth = TILESIZE * maxWorldCol;
	public final int worldHeight = TILESIZE * maxWorldRow;

	ImageIcon icon = new ImageIcon("bin/images/map/sky.png");
	Image image = icon.getImage();
	Image scaledImage = image.getScaledInstance(1000, 1000, java.awt.Image.SCALE_SMOOTH);

	// game player starting postition
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;
	int fps = 60;

	Thread gameThread;

	public int getPlayerX() {
		return playerX;
	}

	public void setPlayerX(int playerX) {
		this.playerX = playerX;
	}

	public int getPlayerY() {
		return playerY;
	}

	public void setPlayerY(int playerY) {
		this.playerY = playerY;
	}

	public int getFps() {
		return fps;
	}

	public void setFps(int fps) {
		this.fps = fps;
	}

	public int getORIGINALTILESIZE() {
		return ORIGINALTILESIZE;
	}

	public int getTILESIZE() {
		return TILESIZE;
	}

	public UIElements getUi() {
		return ui;
	}

	public int getMAXSCREENCOLLUMN() {
		return MAXSCREENCOLLUMN;
	}

	public int getMAXSCREENROW() {
		return MAXSCREENROW;
	}

	public int getSCREENWIDTH() {
		return SCREENWIDTH;
	}

	public int getSCREENHEIGHT() {
		return SCREENHEIGHT;
	}

	// public TileManager tileM = new TileManager(this, mapNum);
	public TileManager tileM;

	// TileManager tileM;
	KeyHandler keyHandler;
	public CollisionChecker checker;
	Player player1;

	// public Controller controller = new
	// Controller(keyHandler,this,checker,player1,mapNum);
	public Controller controller;
	// Player player = new Player(this, controller.keyH);
	public Player player;
	Enemy enemy;

	/**
	 * 
	 * coinstructor which sets the some setting for the jpannel
	 */
	public GamePanel(UIElements ui, int mapNum, Boolean multiplayer) {
		this.mainframe = mainframe;
		this.mapNum = mapNum;
		this.multiplayer = multiplayer;
		this.ui = ui;
		tileM = new TileManager(this, mapNum);
		controller = new Controller(keyHandler, this, checker, player1, mapNum);
		player = new Player(this, controller.keyH);
		enemy = new Enemy(this, controller.keyH);
		this.setPreferredSize(new Dimension(SCREENWIDTH, SCREENHEIGHT)); // sets the size of the Jpanel
		this.setDoubleBuffered(true);
		this.setFocusable(true);
		this.addKeyListener(controller.keyH);
		this.setFocusable(true);
		this.setBounds(0, 0, SCREENWIDTH, SCREENHEIGHT);

		// player.loadLevelData(tileM.mapTileNum); // tester for collisions
	}

	/**
	 * starts the thread to be used for the jpannel
	 */
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	/**
	 * this is the main game loop for the program , all of it is jsut fluff to get
	 * update which updates the current position and repaint which redraws the
	 * charecter and lastly will put the thred to sleep until the next 1/60th of a
	 * nano second occurs 60 fps
	 */
	@Override
	public void run() {

		double drawInterval = 1000000000 / fps; // devides the total time in 1 sec in nanotime by the frame rate
												// selected which is 60 fps
		double nextDrawTime = System.nanoTime() + drawInterval;

		while (gameThread != null) {

			ui.changeLives(player.getLives());

			if (player.checkIfGameISCompleted() == false && player.checkIfGameOver() == false) {

				// updates information for the game

				update();

				// re draws the game with the new information
				repaint();

				try { // used to make the thread "sleep" until the next draw time to keep the game at
						// 60fps
					double remainingTime = nextDrawTime - System.nanoTime();
					remainingTime = remainingTime / 1000000; // since thread .sleep is in milis need to convert to
																// nanotime

					if (remainingTime < 0) {
						remainingTime = 0;
					}

					Thread.sleep((long) remainingTime);

					nextDrawTime += drawInterval;
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			else if (player.checkIfGameISCompleted() == true) {

				if (gameComplete == null) {
					gameComplete = new GameCompleteWindow(ui, multiplayer);
					score = gameComplete.score;
					ui.clock.stop();
					timeToExit = true;

				}

				if (multiplayer == false) {

					return;
				} else {

				}

			} else if (player.checkIfGameOver() == true) {
				if (gameOver == null) {
					gameOver = new GameOverWindow(ui, multiplayer);
					score = gameOver.score;

					ui.clock.stop();
					timeToExit = true;

				}
				if (multiplayer == false) {

					return;
				} else {

				}
			}

		}

	}

	/**
	 * currently only calls update for the player charecter but eventually will have
	 * npcs as well
	 */
	public void update() {
		// System.out.println(player.kh.inAir + " enemy : " + enemy.kh.inAir);
		enemy.update();
		player.update();

		if (player.getHitbox().x == enemy.getHitBox().x && player.getHitbox().y == enemy.getHitBox().y) {
			player.setWorldX(50);
			player.setWorldY(420);
			player.setLives(player.getLives() - 1);
		}
		// enemy.update();

	}

	/**
	 * a function that redraws the charecter and tiles as a graphics object
	 */
	public void paintComponent(Graphics g) {

		controller.player = player;
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;

		g.drawImage(scaledImage, 0, 0, null);

		tileM.draw(g2);



		controller.player.draw(g2);

		g2.dispose();

	}

	public Boolean GetMultiplayer() {
		return multiplayer;
	}

	public int getScore() {
		return score;
	}

	public Boolean gettimeToExit() {
		return timeToExit;
	}
}
