package Model;

import View.GamePanel;
import controller.Controller;

/**
 * @author justi
 * class to check wether the user is hitting an imapassable object
 */
        public class CollisionChecker {
GamePanel gp;

/**
 * coonstructor
 * @param gp the gamepannel 
 */
public CollisionChecker(GamePanel gp) {
	this.gp = gp;
	
}
	
	public void checktile(entity entity) {
		
		 
		int entityRightWolrdX = entity.playerHitbox.x  + entity.playerHitbox.width;
		int entityLeftWorldX = entity.playerHitbox.x ;
		int entityTopWorldY = entity.playerHitbox.y ;
		int entityBottomWorldY =entity.playerHitbox.y +entity.playerHitbox.height ;
	
		
		int entityleftCol =  entityLeftWorldX/gp.getTILESIZE();
		int entityRightCol = entityRightWolrdX/gp.getTILESIZE();
		int entityTopRow   = entityTopWorldY/gp.getTILESIZE() ;
		int entityBotRow = entityBottomWorldY/gp.getTILESIZE() ;
		
	
		
		int tileNum1;
		int tileNum2;
		int tileNum3;
		int tileNum4;
		int tester;
		
		switch(entity.direction) {
		

		case "jump":
			entityBotRow = (entityBottomWorldY + entity.speed)/gp.getTILESIZE();
			entityTopRow = (entityTopWorldY - entity.speed)/gp.getTILESIZE();
			tileNum1 = gp.controller.tileM.getMapTileNum()[entityleftCol][entityBotRow];
			tileNum2 = gp.controller.tileM.getMapTileNum()[entityRightCol][entityBotRow];
			tileNum3 = gp.controller.tileM.getMapTileNum()[entityleftCol][entityTopRow];
			tileNum4 = gp.controller.tileM.getMapTileNum()[entityRightCol][entityTopRow];
			
			//System.out.println(entityBotRow );
			
			if(gp.controller.tileM.getTile()[tileNum1].getCollision() == true || gp.controller.tileM.getTile()[tileNum2].getCollision() == true || gp.controller.tileM.getTile()[tileNum3].getCollision() == true || gp.controller.tileM.getTile()[tileNum4].getCollision() == true) {
				if( gp.controller.tileM.getTile()[tileNum3].getCollision() == true || gp.controller.tileM.getTile()[tileNum4].getCollision() == true) {
					entity.inAirCollision = true;
				}
				
				entity.collisionIsTrue = true;
			
				entity.onGround = true;
				
			}
			
			
	    break;
		case "left":
			tester = (entityBottomWorldY + entity.speed-2)/gp.getTILESIZE();
			entityleftCol = (entityLeftWorldX - entity.speed)/gp.getTILESIZE();
			tileNum1 = gp.controller.tileM.getMapTileNum()[entityleftCol][entityTopRow];
			tileNum2 = gp.controller.tileM.getMapTileNum()[entityleftCol][entityBotRow];
			tileNum3 = gp.controller.tileM.getMapTileNum()[entityleftCol][tester];
			tileNum4 = gp.controller.tileM.getMapTileNum()[entityRightCol][tester];
			
			if(gp.controller.tileM.getTile()[tileNum1].getCollision() == true || gp.controller.tileM.getTile()[tileNum2].getCollision() == true) {
				entity.collisionIsTrue = true;
			}
			if(gp.controller.tileM.getTile()[tileNum3].getCollision() == false || gp.controller.tileM.getTile()[tileNum4].getCollision() == false) {
				entity.collisionIsTrue = false;
				entity.onGround = false;
			}
			
			break;
		case "right":
		     tester = (entityBottomWorldY + entity.speed -2)/gp.getTILESIZE();
			entityRightCol = (entityRightWolrdX + entity.speed)/gp.getTILESIZE();
			tileNum1 = gp.controller.tileM.getMapTileNum()[entityRightCol][entityTopRow];
			tileNum2 =gp.controller.tileM.getMapTileNum()[entityRightCol][entityBotRow];
			tileNum3 = gp.controller.tileM.getMapTileNum()[entityleftCol][tester];
			tileNum4 = gp.controller.tileM.getMapTileNum()[entityRightCol][tester];
			
			
			if(gp.controller.tileM.getTile()[tileNum1].getCollision() == true || gp.controller.tileM.getTile()[tileNum2].getCollision() == true) {
				entity.collisionIsTrue = true;
				entity.onGround = true;
			}
			
			// added this to test
			if(gp.controller.tileM.getTile()[tileNum3].getCollision() == false || gp.controller.tileM.getTile()[tileNum4].getCollision() == false) {
				entity.collisionIsTrue = false;
				entity.onGround = false;
			}
			
		
			
			
			break;
			
		case "idle"	:
			entityBotRow = (entityBottomWorldY + entity.speed)/gp.getTILESIZE();
			tileNum1 = gp.controller.tileM.getMapTileNum()[entityleftCol][entityBotRow];
			tileNum2 = gp.controller.tileM.getMapTileNum()[entityRightCol][entityBotRow];
			//System.out.println(entityBotRow );
			
			if(gp.controller.tileM.getTile()[tileNum1].getCollision() == true || gp.controller.tileM.getTile()[tileNum2].getCollision() == true) {
				entity.collisionIsTrue = true;
				entity.onGround = true;
			
			}
			break;
		
		}
		
	}
	
	public int getRow(entity entity) {
		int row =0;
		
		int entityRightWolrdX = entity.playerHitbox.x  + entity.playerHitbox.width;
		int entityLeftWorldX = entity.playerHitbox.x ;
		int entityTopWorldY = entity.playerHitbox.y ;
		int entityBottomWorldY =entity.playerHitbox.y +entity.playerHitbox.height ;
	
		
		int entityleftCol =  entityLeftWorldX/gp.getTILESIZE();
		int entityRightCol = entityRightWolrdX/gp.getTILESIZE();
		int entityTopRow   = entityTopWorldY/gp.getTILESIZE() ;
		int entityBotRow = entityBottomWorldY/gp.getTILESIZE() ;
		
		row = (entityBottomWorldY + entity.speed)/gp.getTILESIZE();
		
		//row = gp.controller.tileM.getMapTileNum()[entityleftCol][entityBotRow];
	
		return row;
		
		
	}
	

	

	
	
	
	

	
}
