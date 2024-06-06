package Model;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import View.GamePanel;

import java.awt.Rectangle;

/**
 * @author Justin
 * instance variables to be used for all entitys
 *
 */

public class entity {
	protected int worldX;
	protected int worldY;
	protected int speed;
	GamePanel gp;
	
	protected int enemyWorldX;
	protected int enemyWorldY;
	
	protected BufferedImage goomba;
	protected BufferedImage idle;
	protected BufferedImage walk1;
	protected BufferedImage walk2;
	protected BufferedImage walk3;
	protected BufferedImage walk1Left;
	protected BufferedImage walk2Left;
	protected BufferedImage walk3Left;
	protected BufferedImage LeftIdle;
	protected BufferedImage jump1Right;
	protected BufferedImage jump2Right;
	protected String direction;
	protected int spriteCounter =0;
	protected int spriteNum =1;
	protected boolean rightFacing;
	protected Rectangle playerHitbox;
	protected Rectangle enemyHitBox;
	protected boolean collisionIsTrue;
	protected boolean inAirCollision;
	protected boolean onGround;
	
	public entity(GamePanel gp) {
		this.gp = gp;
	}
	
	
		 
	 
	
	public int getWorldX() {
		return worldX;
	}
	public void setWorldX(int x) {
		this.worldX = x;
	}
	public int getWorldY() {
		return worldY;
	}
	public void setWorldY(int y) {
		this.worldY = y;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public BufferedImage getIdle() {
		return idle;
	}
	public void setIdle(BufferedImage idle) {
		this.idle = idle;
	}
	public BufferedImage getWalk1() {
		return walk1;
	}
	public void setWalk1(BufferedImage walk1) {
		this.walk1 = walk1;
	}
	public BufferedImage getWalk2() {
		return walk2;
	}
	public void setWalk2(BufferedImage walk2) {
		this.walk2 = walk2;
	}
	public BufferedImage getWalk3() {
		return walk3;
	}
	public void setWalk3(BufferedImage walk3) {
		this.walk3 = walk3;
	}
	public BufferedImage getWalk1Left() {
		return walk1Left;
	}
	public void setWalk1Left(BufferedImage walk1Left) {
		this.walk1Left = walk1Left;
	}
	public BufferedImage getWalk2Left() {
		return walk2Left;
	}
	public void setWalk2Left(BufferedImage walk2Left) {
		this.walk2Left = walk2Left;
	}
	public BufferedImage getWalk3Left() {
		return walk3Left;
	}
	public void setWalk3Left(BufferedImage walk3Left) {
		this.walk3Left = walk3Left;
	}
	public BufferedImage getLeftIdle() {
		return LeftIdle;
	}
	public void setLeftIdle(BufferedImage leftIdle) {
		LeftIdle = leftIdle;
	}
	public BufferedImage getJump1Right() {
		return jump1Right;
	}
	public void setJump1Right(BufferedImage jump1Right) {
		this.jump1Right = jump1Right;
	}
	public BufferedImage getJump2Right() {
		return jump2Right;
	}
	public void setJump2Right(BufferedImage jump2Right) {
		this.jump2Right = jump2Right;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public int getSpriteCounter() {
		return spriteCounter;
	}
	public void setSpriteCounter(int spriteCounter) {
		this.spriteCounter = spriteCounter;
	}
	public int getSpriteNum() {
		return spriteNum;
	}
	public void setSpriteNum(int spriteNum) {
		this.spriteNum = spriteNum;
	}
	public boolean isRightFacing() {
		return rightFacing;
	}
	public void setRightFacing(boolean rightFacing) {
		this.rightFacing = rightFacing;
	}
	public Rectangle getPlayerHitbox() {
		return playerHitbox;
	}
	public void setPlayerHitbox(Rectangle playerHitbox) {
		this.playerHitbox = playerHitbox;
	}
	public boolean GetCollisionIsTrue() {
		return collisionIsTrue;
	}
	public void setCollisionIsTrue(boolean collisionIsTrue) {
		this.collisionIsTrue = collisionIsTrue;
	}
	public boolean isOnGround() {
		return onGround;
	}
	public void setOnGround(boolean onGround) {
		this.onGround = onGround;
	}
	

	

}

