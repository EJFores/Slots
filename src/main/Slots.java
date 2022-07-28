package main;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.WindowConstants;

public class Slots {

	public static class slotProgram{

		guiSlots gSLib = new guiSlots();
		oddsSlots oSLib = new oddsSlots();
		utilsSlots uSLib = new utilsSlots();
		int points = 100;

		public slotProgram()
		{
			Actions listener = new Actions();
			gSLib.bbet5.addActionListener(listener);
			gSLib.bbet10.addActionListener(listener);
			gSLib.again.addActionListener(listener);
			gSLib.bbet5.setActionCommand("b5");
			gSLib.bbet10.setActionCommand("b10");
			gSLib.again.setActionCommand("again");
			
			gSLib.slot1.setIcon(gSLib.sevenImg);
			gSLib.slot2.setIcon(gSLib.sevenImg);
			gSLib.slot3.setIcon(gSLib.sevenImg);
			gSLib.screenmain.setText("<html> Choose a bet to start <br> Or enter your own to your left <br> Otherwise please enter 0 in the box <html>");
			gSLib.screenpts.setText("Points: " + points);
						
			gSLib.pane.setLayout(new GridLayout ( 3,3));
			gSLib.pane.setBackground(Color.gray);
			gSLib.pane.add(gSLib.slot1);
			gSLib.pane.add(gSLib.slot2);
			gSLib.pane.add(gSLib.slot3);
			gSLib.pane.add(gSLib.bbetuser);
			gSLib.pane.add(gSLib.screenmain);
			gSLib.pane.add(gSLib.screenpts);
			gSLib.pane.add(gSLib.bbet5);
			gSLib.pane.add(gSLib.bbet10);
			
			gSLib.datFrame.setSize(500, 500);   
			gSLib.datFrame.setTitle("Slot Machine");
			gSLib.datFrame.setVisible(true); 
			gSLib.datFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			
		}
		
		private class Actions implements ActionListener // interface
		{
			public void actionPerformed( ActionEvent a)
			{
				String event;
				event = a.getActionCommand().toString();

				int sysBet = 0;
				switch(event)
				{
					case ("b5"):
						sysBet = 5;
						break;
					case ("b10"):
						sysBet = 10;
						break;
					case ("again"):
						gSLib.bbet5.setVisible(true);
						gSLib.bbet10.setVisible(true);
						gSLib.bbetuser.setVisible(true);
						gSLib.again.setVisible(false);
						gSLib.screenmain.setText("<html> Choose a bet to start <br> Or enter your own to your left <html>");
						points = 100;
						gSLib.slot1.setIcon(gSLib.sevenImg);
						gSLib.slot2.setIcon(gSLib.sevenImg);
						gSLib.slot3.setIcon(gSLib.sevenImg);
						gSLib.screenpts.setText(" Points: " + points );
						break;
				}
				int totalBet = oSLib.betCollectandReturn(uSLib.validateTextConvertInt(gSLib.bbetuser.getText()), sysBet);
				points += totalBet; 
				gSLib.screenpts.setText("Points: " + points);

				if (oSLib.luckySlotOdds(oSLib.slotOdds()))
				{
					points += 10;
					gSLib.screenpts.setText("Points: " + points);
					gSLib.screenmain.setText("You Won!!!");
				}else{
					for (int i=0; i<oSLib.slotOdds().size();i++)
					{
						switch(oSLib.slotOdds().get(i))
						{
							case(1):
								gSLib.slot1.setIcon(gSLib.sevenImg);
								break;
							case(2):
								gSLib.slot1.setIcon(gSLib.bellImg);
								break;
							case(3):
								gSLib.slot1.setIcon(gSLib.cherryImg);
								break;
						}
	
					}
				}
				
				if (points < 20)
				{
					gSLib.bbetuser.setVisible(false);
					gSLib.screenmain.setText("You only have 20 points left");
				}
				
				if (points < 10)
				{
					gSLib.bbet10.setVisible(false);
					gSLib.screenmain.setText("You only have 10 points left");
				}
				
				if (points < 5)
				{
					gSLib.bbet5.setVisible(false);
					gSLib.screenmain.setText("You only have 5 points left");
				}
				
				if (points == 0)
				{
					gSLib.pane.add(gSLib.again);
					gSLib.screenmain.setText("Were sorry you lost");
					gSLib.bbet5.setVisible(false);
					gSLib.bbet10.setVisible(false);
					gSLib.bbetuser.setVisible(false);
				}
			
			}
			
		}
	}

}
