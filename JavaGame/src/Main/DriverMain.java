package Main;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.io.IOException;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import Model.ClientModel;
import View.ClientFrame;
import View.GamePanel;
import View.MainFrame;
import View.UIElements;
import controller.ClientController;

/**
 * main class
 * 
 * @author justi
 *
 */
public class DriverMain {

	/**
	 * creates all objects needed to run the program
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		ClientFrame frame = new ClientFrame();
		ClientModel client = new ClientModel(frame);
		ClientController controller = new ClientController(frame, client);

		controller.controll();

		int mapNum = frame.getMapNum();
		Boolean multiplayer = frame.getMultiplayer();
		String userName = frame.getUsername();

		MainFrame mainframe = new MainFrame(mapNum, multiplayer);

		while (true) {
			if (multiplayer == true) {

				while (frame.getScore() == -1) {

					if (frame.getTimeToDisconect() == true) {
						mainframe.turnoffScreen(true);
						controller.client.timeToDisconect();
						controller.frame.frame.dispose();
						System.exit(0);
						break;
					}
				
					
					System.out.println(" ");
					if (mainframe.getFrame().getScore() != -1) {

						frame.setScore(mainframe.getFrame().getScore());
						break;
					}

				}

				client.sendMessage("#3 " + frame.getUsername() + " " + frame.getScore());

				frame.getTimeToDisconect();

				while (frame.getTimeToDisconect() == false) {
					if (frame.getTimeToDisconect() == true) {
						mainframe.turnoffScreen(true);
						controller.client.timeToDisconect();
						controller.frame.frame.dispose();
						System.exit(0);
						break;
					}
				}

			} else {
				break;
			}
		}

	}

}
