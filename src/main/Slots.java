package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JFrame;

public class Slots {

	public static class slotProgram{
		private JLabel slot1;
		private JLabel slot2;
		private JLabel slot3;
		private JLabel screenpts;
		private JLabel screenmain;
		private JButton bbet5;
		private JButton bbet10;
		private JButton again;
		private JTextField bbetuser;
		int points = 100;
		int slotnum1;
		int slotnum2;
		int slotnum3;
		JFrame datFrame = new JFrame();

		public slotProgram()
		{
			Actions listener = new Actions();
			bbet5 = new JButton("Bet 5");
			bbet10 = new JButton("Bet 10");
			again = new JButton(" Play Again ");
			bbet5.addActionListener(listener);
			bbet10.addActionListener(listener);
			again.addActionListener(listener);
			bbet5.setActionCommand("b5");
			bbet10.setActionCommand("b10");
			again.setActionCommand("again");
			
			slot1 = new JLabel(new ImageIcon(getClass().getResource("imgs/seven.jpg")));
			slot2 = new JLabel(new ImageIcon(getClass().getResource("imgs/seven.jpg")));
			slot3 = new JLabel(new ImageIcon(getClass().getResource("imgs/seven.jpg")));
			screenmain = new JLabel("<html> Choose a bet to start <br> Or enter your own to your left <br> Otherwise please enter 0 in the box <html>" , SwingConstants.CENTER);
			screenpts = new JLabel(" Points: " + points ,  SwingConstants.CENTER);
			
			bbetuser = new JTextField( 10 );
			
			Container pane = datFrame.getContentPane();
			pane.setLayout(new GridLayout ( 3,3));
			pane.setBackground(Color.gray);
			pane.add(slot1);
			pane.add(slot2);
			pane.add(slot3);
			pane.add(bbetuser);
			pane.add(screenmain);
			pane.add(screenpts);
			pane.add(bbet5);
			pane.add(bbet10);
			//pane.add(again);
			
			datFrame.setSize(500, 500);   
			datFrame.setTitle( " Slot Machine (JFrame- courtesy of JavaLabs LLC.)");
			datFrame.setVisible(true); 
			//datFrame.setDefaultCloseOperation(operation)
			
		}
		
		private class Actions implements ActionListener // interface
		{
			public void actionPerformed( ActionEvent a)
			{
				String event;
				int usernum;
				
				event = a.getActionCommand();
				
				usernum = Integer.parseInt( bbetuser.getText() );
				slotnum1 = (int) (Math.random () *3 +1);
				slotnum2 = (int) (Math.random () *3 +1);
				slotnum3 = (int) (Math.random () *3 +1);
				
				points -= usernum; 
				
				if (event.equals("b5"))
				{
					points -=5;
					screenpts.setText("Points: " + points);
					
					if (slotnum1 == 1)
						slot1.setIcon(new ImageIcon(getClass().getResource("imgs/seven.jpg")));
					
					if (slotnum1 == 2)
						slot1.setIcon(new ImageIcon(getClass().getResource("imgs/bell.jpg")));
					
					if (slotnum1 == 3)
						slot1.setIcon(new ImageIcon(getClass().getResource("imgs/cherry.jpg")));
					
					if (slotnum2 == 1)
						slot2.setIcon(new ImageIcon(getClass().getResource("imgs/seven.jpg")));
					
					if (slotnum2 == 2)
						slot2.setIcon(new ImageIcon(getClass().getResource("imgs/bell.jpg")));
					
					if (slotnum2 == 3)
						slot2.setIcon(new ImageIcon(getClass().getResource("imgs/cherry.jpg")));
					
					if (slotnum3 == 1)
						slot3.setIcon(new ImageIcon(getClass().getResource("imgs/seven.jpg")));
					
					if (slotnum3 == 2)
						slot3.setIcon(new ImageIcon(getClass().getResource("imgs/bell.jpg")));
					
					if (slotnum3 == 3)
						slot3.setIcon(new ImageIcon(getClass().getResource("imgs/cherry.jpg")));
					
				}
				
				if (slotnum1 == 1 && slotnum2 == 1 && slotnum3 == 1)
				{
					points *= 2;
					screenpts.setText("Points: " + points);
					screenmain.setText("You hit the Jackpot!!!!!!");
				}
				
				if (slotnum1 == 2 && slotnum2 == 2 && slotnum3 == 2)
				{
					points += 10;
					screenpts.setText("Points: " + points);
					screenmain.setText("You Won!!!");
				}
				
				if (slotnum1 == 1 && slotnum2 == 1 && slotnum3 == 1)
				{
					points += 5;
					screenpts.setText("Points: " + points);
					screenmain.setText("Good Job!");
				}
					
				if (event.equals("b10"))
				{
					points-=10;
					screenpts.setText("Points: " + points);
					
					if (slotnum1 == 1)
						slot1.setIcon(new ImageIcon(getClass().getResource("imgs/seven.jpg")));
					
					if (slotnum1 == 2)
						slot1.setIcon(new ImageIcon(getClass().getResource("imgs/bell.jpg")));
					
					if (slotnum1 == 3)
						slot1.setIcon(new ImageIcon(getClass().getResource("imgs/cherry.jpg")));
					
					if (slotnum2 == 1)
						slot2.setIcon(new ImageIcon(getClass().getResource("imgs/seven.jpg")));
					
					if (slotnum2 == 2)
						slot2.setIcon(new ImageIcon(getClass().getResource("imgs/bell.jpg")));
					
					if (slotnum2 == 3)
						slot2.setIcon(new ImageIcon(getClass().getResource("imgs/cherry.jpg")));
					
					if (slotnum3 == 1)
						slot3.setIcon(new ImageIcon(getClass().getResource("imgs/seven.jpg")));
					
					if (slotnum3 == 2)
						slot3.setIcon(new ImageIcon(getClass().getResource("imgs/bell.jpg")));
					
					if (slotnum3 == 3)
						slot3.setIcon(new ImageIcon(getClass().getResource("imgs/cherry.jpg")));
					
				}
				
				if (points < 20)
				{
					bbetuser.setVisible(false);
					screenmain.setText("You only have 20 points left");
				}
				
				if (points < 10)
				{
					bbet10.setVisible(false);
					screenmain.setText("You only have 10 points left");
				}
				
				if (points < 5)
				{
					bbet5.setVisible(false);
					screenmain.setText("You only have 5 points left");
				}
				
				if (points == 0)
				{
					Container pane = datFrame.getContentPane();
					pane.add(again);
					screenmain.setText("Were sorry you lost");
					bbet5.setVisible(false);
					bbet10.setVisible(false);
					bbetuser.setVisible(false);
				}
				
				if (event.equals("again"))
				{
					bbet5.setVisible(true);
					bbet10.setVisible(true);
					bbetuser.setVisible(true);
					again.setVisible(false);
					screenmain.setText("<html> Choose a bet to start <br> Or enter your own to your left <html>");
					points = 100;
					slot1.setIcon(new ImageIcon(getClass().getResource("imgs/seven.jpg")));
					slot2.setIcon(new ImageIcon(getClass().getResource("imgs/seven.jpg")));
					slot3.setIcon(new ImageIcon(getClass().getResource("imgs/seven.jpg")));
					screenpts.setText(" Points: " + points );
				}
			}
			
		}
	}

}
