package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class Slots {

	public static class slotProgram{

		GuiSlots gSLib = new GuiSlots();
		OddsSlots oSLib = new OddsSlots();
		UtilsSlots uSLib = new UtilsSlots();
		int points = 100;

		public slotProgram()
		{
			gSLib.generateGraphics();

			Actions listener = new Actions();
			gSLib.bbet5.addActionListener(listener);
			gSLib.bbet10.addActionListener(listener);
			gSLib.again.addActionListener(listener);
			gSLib.bbet5.setActionCommand("b5");
			gSLib.bbet10.setActionCommand("b10");
			gSLib.again.setActionCommand("again");

			gSLib.screenmain.setText("<html> Choose a bet to start <br> Or enter your own to your left <html>");
			gSLib.screenpts.setText("Points: " + points);
			
		}
		
		private class Actions implements ActionListener
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
				List<Integer> roll = oSLib.slotOdds();
				if (oSLib.luckySlotOdds(roll))
				{
					points += totalBet;
					gSLib.screenpts.setText("Points: " + points);
					gSLib.screenmain.setText("You Won!!!");
					gSLib.bbet5.setVisible(false);
					gSLib.bbet10.setVisible(false);
					gSLib.bbetuser.setVisible(false);
					gSLib.slot1.setIcon(gSLib.getIconForRoll(roll.get(0)));
					gSLib.slot2.setIcon(gSLib.getIconForRoll(roll.get(1)));
					gSLib.slot3.setIcon(gSLib.getIconForRoll(roll.get(2)));
					gSLib.again.setVisible(true);
				}
				else
				{
					points += (totalBet=-totalBet); 
					gSLib.screenpts.setText("Points: " + points);
					gSLib.slot1.setIcon(gSLib.getIconForRoll(roll.get(0)));
					gSLib.slot2.setIcon(gSLib.getIconForRoll(roll.get(1)));
					gSLib.slot3.setIcon(gSLib.getIconForRoll(roll.get(2)));
				}
				
				if (points < 20)
				{
					gSLib.bbetuser.setText("");
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
				
				if (points <= 0)
				{
					gSLib.pane.add(gSLib.again);
					gSLib.screenmain.setText("Were sorry you lost");
					gSLib.bbet5.setVisible(false);
					gSLib.bbet10.setVisible(false);
					gSLib.bbetuser.setVisible(false);
					gSLib.again.setVisible(true);
				}
			
			}
			
		}
	}
	public static void main(String[] args) 
	{
		@SuppressWarnings("unused")
		slotProgram program = new slotProgram();
	}

}
