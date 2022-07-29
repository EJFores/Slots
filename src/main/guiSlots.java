package main;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Container;
import javax.swing.WindowConstants;
import javax.swing.plaf.DimensionUIResource;
import java.awt.Color;
import java.awt.GridLayout;

public class GuiSlots 
{
    JFrame datFrame = new JFrame();
    Container pane = datFrame.getContentPane();
    JLabel slot1 = new JLabel();
    JLabel slot2 = new JLabel();
    JLabel slot3 = new JLabel();
    JLabel screenpts = new JLabel();
    JLabel screenmain = new JLabel();
    JButton bbet5 = new JButton("Bet 5");
    JButton bbet10 = new JButton("Bet 10");
    JButton again = new JButton(" Play Again ");
    JTextField bbetuser = new JTextField(10);
    ImageIcon sevenImg = new ImageIcon(getClass().getResource("imgs/seven.jpg"));
    ImageIcon bellImg = new ImageIcon(getClass().getResource("imgs/bell.jpg"));
    ImageIcon cherryImg = new ImageIcon(getClass().getResource("imgs/cherry.jpg"));
    ImageIcon lemonImg = new ImageIcon(getClass().getResource("imgs/lemon.jpg"));
    ImageIcon moneybagImg = new ImageIcon(getClass().getResource("imgs/moneybag.png"));
    ImageIcon goldbarImg = new ImageIcon(getClass().getResource("imgs/goldbar.jpg"));
    DimensionUIResource minSize = new DimensionUIResource(500, 500);

    public void generateGraphics()
    {
        slot1.setIcon(sevenImg);
        slot2.setIcon(sevenImg);
        slot3.setIcon(sevenImg);
        again.setVisible(false);
                    
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
        pane.add(again);

        slot1.setHorizontalAlignment(JLabel.CENTER);
        slot2.setHorizontalAlignment(JLabel.CENTER);
        slot3.setHorizontalAlignment(JLabel.CENTER);
        
        datFrame.setMinimumSize(minSize);  
        datFrame.setTitle("Slot Machine");
        datFrame.setVisible(true); 
        datFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public ImageIcon getIconForRoll(int roll)
    {
        ImageIcon ii = null;
        switch(roll)
        {
            case(1):
                ii =  sevenImg;
                break;
            case(2):
                ii =  bellImg;
                break;
            case(3):
                ii =  cherryImg;
                break;
            case(4):
                ii =  lemonImg;
                break;
            case(5):
                ii =  moneybagImg;
                break;
            case(6):
                ii =  goldbarImg;
                break;
        }
        return ii;
    }
}
