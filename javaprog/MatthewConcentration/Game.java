import acm.graphics.*;
import acm.program.*;
import javax.swing.*;
import acm.gui.*;
import java.awt.event.*;

public class Game extends Program
{

    TablePanel scoreboard;
    TablePanel cardboard;
    VPanel gameboard;
    JLabel p1score, p2score;
    JButton reset;
    Conc c;
    // perfect name
    JButton [] cardButts;
    JButton flipback;
    
    ImageIcon back;
    ImageIcon [] pairs;
    
    public Game()
    {
        this.start();
    }
    
    public void init()
    {
        
        c = new Conc(2,6);
        gameboard = new VPanel();
        this.add(gameboard);
        cardButts = new JButton[6];
        pairs = new ImageIcon[3];
        
        
        scoreboard = new TablePanel(1,3);
        gameboard.add(scoreboard);
        
        cardboard= new TablePanel(2, 3);
        cardboard.setVisible(true);
        gameboard.add(cardboard);
        
        p1score= new JLabel("0");
        p2score= new JLabel("0");
        reset= new JButton("New Game");
        
        scoreboard.add(p1score);
        scoreboard.add(reset);
        scoreboard.add(p2score);
         
        //picture for back of cards
        back= new ImageIcon("back.png");
        // Pair pictures
        for (int i=0; i <this.pairs.length; i++){
            pairs[i] = new ImageIcon("icon"+i+".jpg");
        }
        
        //Intilaze the amount of cards
        for(int i=0; i<this.cardButts.length; i++){
            this.cardButts[i] = new JButton();
            this.cardButts[i].setActionCommand(""+i);
            this.cardButts[i].setIcon(back);
            this.cardboard.add(cardButts[i]);
            cardButts[i].setVisible(true);
        }
        
        
        flipback= new JButton("Flip Over");
        flipback.setActionCommand("flip");
        this.addActionListeners();
    }
        
    public void actionPerformed(ActionEvent a)
     {
          String action = a.getActionCommand();
          
          
            
      }
}

       
        
    
    