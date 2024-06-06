package Model;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * the class that will read in charecter kep pressed and set booleans depending on the situation which is used through the rest of the program
 * @author justi
 *
 */
public class KeyHandler implements KeyListener{

	
	protected Boolean upPressed=false;
	protected Boolean downPressed=false ;
	protected Boolean leftPressed=false  ;
	protected Boolean rightPressed=false;
	
	// gravity variables
	protected boolean jump = false;
	protected int airSpeed =0;
	protected int gravity = 1 ;
	protected int jumpSpeed = -17;
	protected int fallSpeedAfterCollision = 1;
	public boolean inAir = false;
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
			if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP ) {
			upPressed = true;
			
		}
		if(code ==KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
			downPressed = true;
			
		}
		if(code ==KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
			leftPressed = true;
		
		}
		if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
			rightPressed = true;
			
		}
		if (code ==KeyEvent.VK_SPACE ) {
			jump = true;
			inAir = true;
			
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code1 = e.getKeyCode();
		
	
		
		if(code1 == KeyEvent.VK_W || code1 == KeyEvent.VK_UP ) {
			upPressed = false;
		}
		if(code1 ==KeyEvent.VK_S || code1 == KeyEvent.VK_DOWN) {
			downPressed = false;
		}
		if(code1 ==KeyEvent.VK_A || code1 == KeyEvent.VK_LEFT) {
			leftPressed = false;
		}
		if(code1 == KeyEvent.VK_D || code1 == KeyEvent.VK_RIGHT) {
			rightPressed = false;
		}
		if (code1 ==KeyEvent.VK_SPACE) {
			jump = false;
			
			
		}
	}

}
