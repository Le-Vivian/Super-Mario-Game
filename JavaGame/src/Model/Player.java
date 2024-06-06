package Model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import java.awt.Graphics;
import java.awt.Graphics2D;

import View.GamePanel;

/**
 * @author justin and vivian player class will be used to control and manage the
 *         playable charecter
 *
 */
public class Player extends entity {

	GamePanel gp;
	public KeyHandler kh;

	public final int screenX;
	public final int screenY;
	private int playerLives = 3;

	// private int[][] levelData;
	CollisionChecker checker;

	/**
	 * contructor which sets nessasary values sets default position and sets the
	 * hitbox for the charecter
	 * 
	 * @param gp
	 * @param kh
	 */
	public Player(GamePanel gp, KeyHandler kh) {
		super(gp);
		this.gp = gp;
		this.kh = kh;

		screenX = 380;
		screenY = 430;

		playerHitbox = new Rectangle(worldX, worldY, gp.getTILESIZE(), gp.getTILESIZE());
		setDefaultValues();
		direction = "idle";
		getPlayerImage();
		checker = new CollisionChecker(gp);

	}

	/**
	 * initializes starting position and player speed
	 */
	public void setDefaultValues() {
		worldX = 200;
		//worldX = 1288;
		//worldY = 420;
		worldY = 300;
		speed = 4;
	}

	/**
	 * creates all images that will be used to render the charecter , each action
	 * has 3 different images that will be swapped one after the other to create the
	 * illusion of mounvment
	 */
	public void getPlayerImage() {

		try {

// 			idle = ImageIO.read(new File("C:/eclipse workspace/JavaGame/bin/sprites/player/mario_idle.gif"));
// 			walk1 = ImageIO.read(new File("C:/eclipse workspace/JavaGame/bin/sprites/player/mario_walk1.gif"));
// 			walk2 = ImageIO.read(new File("C:/eclipse workspace/JavaGame/bin/sprites/player/mario_walk2.gif"));
// 			walk3 = ImageIO.read(new File("C:/eclipse workspace/JavaGame/bin/sprites/player/mario_walk3.gif"));
// 			walk1Left = ImageIO.read(new File("C:/eclipse workspace/JavaGame/bin/sprites/player/mario_walk1Left.gif"));
// 			walk2Left = ImageIO.read(new File("C:/eclipse workspace/JavaGame/bin/sprites/player/mario_walk2Left.gif"));
// 			walk3Left = ImageIO.read(new File("C:/eclipse workspace/JavaGame/bin/sprites/player/mario_walk3Left.gif"));
// 			LeftIdle = ImageIO.read(new File("C:/eclipse workspace/JavaGame/bin/sprites/player/mario_idle_Left.gif"));
// 			jump1Right = ImageIO.read(new File("C:/eclipse workspace/JavaGame/bin/sprites/player/mario_jump1_right.gif"));
// 			jump2Right = ImageIO.read(new File("C:/eclipse workspace/JavaGame/bin/sprites/player/mario_jump2_right.gif"));
// //			
			idle = ImageIO.read(new File("bin/sprites/player/mario_idle.gif"));
			walk1 = ImageIO.read(new File("bin/sprites/player/mario_walk1.gif"));
			walk2 = ImageIO.read(new File("bin/sprites/player/mario_walk2.gif"));
			walk3 = ImageIO.read(new File("bin/sprites/player/mario_walk3.gif"));
			walk1Left = ImageIO.read(new File("bin/sprites/player/mario_walk1Left.gif"));
			walk2Left = ImageIO.read(new File("bin/sprites/player/mario_walk2Left.gif"));
			walk3Left = ImageIO.read(new File("bin/sprites/player/mario_walk3Left.gif"));
			LeftIdle = ImageIO.read(new File("bin/sprites/player/mario_idle_Left.gif"));
			jump1Right = ImageIO.read(new File("bin/sprites/player/mario_jump1_right.gif"));
			jump2Right = ImageIO.read(new File("bin/sprites/player/mario_jump2_right.gif"));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * used to redraw the hitbox when the charecter moves
	 */
	public void updateHitBox() {
		playerHitbox.x = worldX;
		playerHitbox.y = worldY;
	}

	/**
	 * getter for hitbox
	 * 
	 * @return the hitbox whiich is a rectangle
	 */
	public Rectangle getHitbox() {
		return playerHitbox;
	}

	/**
	 * this is the maion helper method of the class , it checks wether the user has
	 * pressed a key and will update the charecter position if the user is not
	 * hitting a wall
	 */
	public void update() {
		//System.out.println(worldX);

		
       
		
		if (this.inAirCollision) {
			onGround = false;
		}

		if (onGround == true) {
			kh.inAir = false;
			this.inAirCollision = false; // check this line
		}

		if (kh.rightPressed == false && kh.leftPressed == false && kh.inAir == false) { // maybe shoudl be kh.inAir
			direction = "idle";

			if (collisionIsTrue == false && onGround == false) {
				worldY += kh.airSpeed;
				kh.airSpeed += kh.gravity;

			} else if (collisionIsTrue == true && onGround == true) {
			}

		}

		if (kh.leftPressed == true && kh.inAir == false) {

			direction = "left";
			rightFacing = false;

			if (collisionIsTrue == false && onGround == false) {
				direction = "jump";

			} else if (collisionIsTrue == true && onGround == true) {
			}

		}
		if (kh.rightPressed == true && kh.inAir == false) {

			direction = "right";
			rightFacing = true;
			if (collisionIsTrue == false && onGround == false) {

				direction = "jump";

			} else if (collisionIsTrue == true && onGround == true) {
			}

		}

		if (kh.jump == true) {
			jump();
			direction = "jump";
			kh.inAir = true;

		}

		updateHitBox();
		collisionIsTrue = false;

		checker.checktile(this);

		switch (direction) {

		case "left":
			if (collisionIsTrue == false && worldX >= 5) {
				

				worldX -= speed;
			} else {

			}

			break;

		case "right":
			if (collisionIsTrue == false) {


				worldX += speed;
			} else {

			}
			break;

		case "jump":
			// this is a head collision
			if (this.inAirCollision == true) {
				kh.airSpeed = kh.gravity;

				worldY += kh.airSpeed;
				kh.airSpeed += kh.gravity;
				onGround = false;

				if (kh.rightPressed == true) {
					checker.checktile(this);

					worldX += speed;

				} else if (kh.leftPressed == true) {
					checker.checktile(this);

					worldX -= speed;

				}
				inAirCollision = false;
				checker.checktile(this);

				break;
			}
			
			if(worldY + kh.airSpeed >= 530 ) {
				worldX = 50;
				worldY = 420;
				playerLives--;

			}

			if (worldY + kh.airSpeed >= 430 && checker.getRow(this) == 10 && this.collisionIsTrue == true
					&& this.inAirCollision == false) {
				worldY = 430;
				checker.checktile(this);
				break;
			}

			if (worldY + kh.airSpeed >= 238 && checker.getRow(this) == 6 && this.collisionIsTrue == true
					&& this.inAirCollision == false) {
				worldY = 238;
				checker.checktile(this);
				break;
			}
			if (worldY + kh.airSpeed >= 335 && checker.getRow(this) == 8 && this.collisionIsTrue == true
					&& this.inAirCollision == false) {
				worldY = 335;
				checker.checktile(this);
				break;
			}

			if (worldY + kh.airSpeed >= 287 && checker.getRow(this) == 7 && this.collisionIsTrue == true
					&& this.inAirCollision == false) {
				worldY = 287;
				checker.checktile(this);
				break;
			}
			if (worldY + kh.airSpeed >= 94 && checker.getRow(this) == 3 && this.collisionIsTrue == true
					&& this.inAirCollision == false) {
				worldY = 94;
				checker.checktile(this);
				break;
			}
			if (worldY + kh.airSpeed >= 385 && checker.getRow(this) == 9 && this.collisionIsTrue == true
					&& this.inAirCollision == false) {
				worldY = 385;
				checker.checktile(this);
				break;
			}
			if (worldY + kh.airSpeed >= 195 && checker.getRow(this) == 5 && this.collisionIsTrue == true
					&& this.inAirCollision == false) {
				worldY = 195;
				checker.checktile(this);
				break;
			}
			if (worldY + kh.airSpeed >= 143 && checker.getRow(this) == 4 && this.collisionIsTrue == true
					&& this.inAirCollision == false) {
				worldY = 143;
				checker.checktile(this);
				break;
			}

			worldY += kh.airSpeed;
			kh.airSpeed += kh.gravity;
			onGround = false;

			if (kh.rightPressed == true) {
				worldX += speed;
			} else if (kh.leftPressed == true) {
				worldX -= speed;
			}

			checker.checktile(this);

			break;

		}

		spriteCounter++;
		if (spriteCounter > 10) {
			if (spriteNum == 1 && kh.inAir == false) {
				spriteNum = 2;
			} else if (spriteNum == 2 && kh.inAir == false) {
				spriteNum = 3;
			} else if (spriteNum == 3 && kh.inAir == false) {
				spriteNum = 1;
			}
			if (kh.inAir == true) {
				if (spriteNum == 1) {
					spriteNum = 2;
				} else if (spriteNum == 2) {
					spriteNum = 3;
				} else if (spriteNum == 3) {
					spriteNum = 1;
				}
			}
			spriteCounter = 0;
		}
	}

	private void jump() {
		if (kh.inAir == true) {
			return;
		}

		kh.airSpeed = kh.jumpSpeed;

	}

	/**
	 * second main helper method that will be called in update , this handles the
	 * mechanism of which sprite gets desplayed when
	 * 
	 * @param g2
	 */
	public void draw(Graphics2D g2) {
		BufferedImage image = null;

		switch (direction) {
		case "idle":
			if (rightFacing == true) {
				image = idle;

			} else {
				image = LeftIdle;

			}
			break;

		case "left":
			if (kh.leftPressed == false) {
				image = idle;

			}
			if (spriteNum == 1) {
				image = walk1Left;

			}
			if (spriteNum == 2) {
				image = walk2Left;

			}
			if (spriteNum == 3) {
				image = walk3Left;

			}
			break;

		case "right":
			if (kh.rightPressed == false) {
				image = idle;

			}
			if (spriteNum == 1) {
				image = walk1;

			}
			if (spriteNum == 2) {
				image = walk2;

			}
			if (spriteNum == 3) {
				image = walk3;

			}
			break;

		case "jump":
			if (spriteNum == 1) {
				image = jump1Right;
			}
			if (spriteNum == 2) {
				image = jump2Right;
			}
			if (spriteNum == 3) {
				image = jump2Right;
			}

		}
		g2.drawImage(image, screenX, screenY, gp.getTILESIZE(), gp.getTILESIZE(), null);
	}
	
	
	public int getLives() {
		return playerLives;
	}
	
	public Boolean checkIfGameISCompleted() {
		
		if(worldX >= 9500) {
			return true;
		}
		
		else {
			return false;
		}
		
		
	}
	
	public void setWorldX(int i) {
		worldX = i;
	}
	public void setWorldY(int i) {
		worldY = i;
	}
	
	public void setLives(int i) {
		playerLives = i;
	}
	
	public Boolean checkIfGameOver( ) {
		if(playerLives <0) {
			return true;
		}
		
		return false;
		
	}
	
	
	
	

}