package main;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Container;

public class guiSlots 
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
