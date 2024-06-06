package View;

import java.awt.image.BufferedImage;

/**
 * class to hold the instance variabels needed for the tiles, will be added to alter when mroe features are incorperated
 * @author 
 *
 */
public class Tile {
    protected BufferedImage image;
    protected boolean collision = false;
	
    
    public BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	public boolean getCollision() {
		return collision;
	}
	public void setCollision(boolean collision) {
		this.collision = collision;
	}
    
    
}
