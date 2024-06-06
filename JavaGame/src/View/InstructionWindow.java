package View;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InstructionWindow implements ActionListener {
    JButton okButton = new JButton("OK");

    UIElements ui = new UIElements();
    JFrame newFrame = new JFrame();
    JTextArea ins = new JTextArea("Welcome to Mario, for movement use the up down left right arrows or the w a s d  Keys, space bar for jumping, the goal of the game is to reach the end of the level before time or lives run out");
    JComboBox options;

    public InstructionWindow(UIElements ui){
    	
    	this.ui = ui;
		newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newFrame.setResizable(false);
		newFrame.setSize(420,420);
		newFrame.setLayout(null);
        newFrame.setVisible(true);

        okButton.setBounds(150,300,100,50);
        okButton.setContentAreaFilled( false );
		okButton.addActionListener(this);
        okButton.setFocusable(false);

        ins.setBounds(10, 100, 400, 100);
        ins.setEditable(false);
        ins.setLineWrap(true);
        ins.setWrapStyleWord(true);


        String[] languages = {"English", "French", "Vietnamese"};
        options = new JComboBox(languages);
        options.setBounds(135, 20, 150, 30);
		options.addActionListener(this);
       


		newFrame.add(options);
		newFrame.add(ins);
        newFrame.add(okButton);
        newFrame.setVisible(true);
    }
 
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==okButton){
        	
        	if(options.getSelectedItem() == "English"){
				ui.button1.setText("Pause");
                ui.button2.setText("Start");
                ui.button3.setText("Exit");
                ui.button4.setText("How to play");
               // ins.setText("Welcome to Mario, for movement use the up down left right arrows or the w a s d  Keys, space bar for jumping, the goal of the game is to reach the end of the level before time or lives run out");
                
			}
			else if(options.getSelectedItem() == "French"){
                ui.button1.setText("Pause");
                ui.button2.setText("Depart");
                ui.button3.setText("Sortie");
                ui.button4.setText("Instruction");
                //ins.setText("bienvenue dans notre jeu mario, pour vous dÃ©placer, appuyez sur les fleches haut, bas, gauche, droite ou sur les touches w, a, s, d pour sauter, appuyez sur la barre d'espace. le but est d'atteindre la fin du niveau sans perdre toutes vos vies en un minimum de temps");
               
			}
			else if(options.getSelectedItem() == "Vietnamese"){
                ui.button1.setText("Dung");
                ui.button2.setText("Bat Dau");
                ui.button3.setText("Thoat");
                ui.button4.setText("Cach Choi");  
                
               // ins.setText( "ChÃ o má»«ng Ä‘áº¿n vá»›i trÃ² chÆ¡i Mario cá»§a chÃºng tÃ´i, Ä‘á»ƒ di chuyá»ƒn, hÃ£y nháº¥n cÃ¡c mÅ©i tÃªn lÃªn, xuá»‘ng, trÃ¡i, pháº£i hoáº·c cÃ¡c phÃ­m w, a, s, d, Ä‘á»ƒ nháº£y, nháº¥n phÃ­m cÃ¡ch. Má»¥c tiÃªu lÃ  Ä‘áº¡t Ä‘áº¿n cuá»‘i cáº¥p Ä‘á»™ mÃ  khÃ´ng máº¥t táº¥t cáº£ máº¡ng sá»‘ng cá»§a báº¡n trong khoáº£ng thá»�i gian tá»‘i thiá»ƒu");
			  
            }
            ui.button1.setContentAreaFilled( false );
		    ui.button1.setBorder( null );
		    ui.button2.setContentAreaFilled( false );
		    ui.button2.setBorder( null );
		    ui.button3.setContentAreaFilled( false );
		    ui.button3.setBorder( null );
		    ui.button4.setContentAreaFilled( false );
		    ui.button4.setBorder( null );

           // newFrame.setVisible(false);
            newFrame.dispose(); 
        }
		
		if(e.getSource()==options){
           
			if(options.getSelectedItem() == "English"){
				
                ins.setText("Welcome to Mario, for movement use the up down left right arrows or the w a s d  Keys, space bar for jumping, the goal of the game is to reach the end of the level before time or lives run out");
                
			}
			else if(options.getSelectedItem() == "French"){
             
                ins.setText("bienvenue dans notre jeu mario, pour vous deplacer, appuyez sur les fleches haut, bas, gauche, droite ou sur les touches w, a, s, d pour sauter, appuyez sur la barre d'espace. le but est d'atteindre la fin du niveau sans perdre toutes vos vies en un minimum de temps");
               
			}
			else if(options.getSelectedItem() == "Vietnamese"){
              
                ins.setText( "Chào mừng bạn đến với Mario, để di chuyển, hãy sử dụng các mũi tên lên xuống trái phải hoặc Phím w a s d, phím cách để nhảy, mục tiêu của trò chơi là đạt đến cuối cấp trước khi hết thời gian hoặc mạng sống");
			  
            }

       

		}
		
    }


    
}
