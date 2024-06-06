package Model;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import View.GamePanel;

public class Enemy extends entity {
	
	GamePanel gp;



    public int enemyX = 0;
    int  enemyY = 0;
    
	Image enemy;
    public KeyHandler  kh;
	
	CollisionChecker checker;
	Rectangle enemyHitBox;

	
	
	public Enemy(GamePanel gp,KeyHandler kh) {
		super(gp);
		this.kh = kh;
		this.gp = gp;
	    speed = 1;
		direction = "left";
		setDefaultValues();
		enemyHitBox = new Rectangle(enemyX ,enemyY, gp.getTILESIZE(), gp.getTILESIZE());
		
		
		
		getPlayerImage();
		checker = new CollisionChecker(gp);

	}
	
	public void updateHitBox() {
		enemyHitBox.x = enemyX;
		
		
		enemyHitBox.y = enemyY;
	}
	
	
	
	public void setDefaultValues() {
		enemyX = 1500;
		enemyY = 438;
		
	}
	
	public void getPlayerImage() {

		try {


			goomba =  ImageIO.read(new File("src/images/player/goomba.png")); 
			enemy = goomba.getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		 
	

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	
	public void update() {

		updateHitBox();
		

	this.enemyX -= speed;
			
			

			
		
	
   
	
		
	}
	
	public Rectangle getHitBox() {
		return enemyHitBox;
	}
	
	public void draw(Graphics2D g2) {
		 
		 
//		 int screenX = worldX- gp.player.worldX + gp.player.screenX;
//		 int screenY = worldY - gp.player.worldY + gp.player.screenY;
//		 
//		 if(worldX + gp.getTILESIZE() > gp.player.worldX - gp.player.screenX &&
//		    worldX - gp.getTILESIZE() < gp.player.worldX + gp.player.screenX &&
//		    worldY + gp.getTILESIZE() > gp.player.worldY - gp.player.screenY &&
//		    worldY - gp.getTILESIZE() < gp.player.worldY + gp.player.screenY ) {
//			 
//			 g2.drawImage(goomba, enemyX, enemyY, gp.getTILESIZE(), gp.getTILESIZE(), null);
//			 
//		 }
		 
		g2.drawImage(goomba, enemyX, enemyY, gp.getTILESIZE(), gp.getTILESIZE(), null);
		
		
		
	}

}
