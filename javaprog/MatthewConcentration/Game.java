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
    
    int players, cards;
    
    ImageIcon back;
    ImageIcon [] pairs;

  /**  
  private class  CardFlip implements ActionListener
    {
        

        public void actionPerformed(ActionEvent a){
           

        }
    };
    */
    
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
        reset.setActionCommand("reset");
        
        flipback= new JButton("Flip Over");
        flipback.setActionCommand("flip");
        
        scoreboard.add(p1score);
        scoreboard.add(reset);
        scoreboard.add(p2score);
        
        
         
        //picture for back of cards
        back= new ImageIcon("back.png");
        // Pair pictures
        for (int i=0, y=0; i <this.cardButts.length; i++){
            //get the value
            y=this.c.getCardValue(i);
            //match the value with a pair
            //Remember this.c.CardValue() returns a value between 1 and the half of the cards
            pairs[y-1] = new ImageIcon("128/flag"+(y-1)+".png");
        }
        
        //Intilaze the amount of cards
        for(int i=0; i<this.cardButts.length; i++){
            this.cardButts[i] = new JButton();
            this.cardButts[i].setActionCommand(""+i);
            this.cardButts[i].setIcon(back);
            this.cardboard.add(cardButts[i]);
            cardButts[i].setVisible(true);
            
        }
        
        this.addActionListeners();
        
      
       
        
    }
        
    public void actionPerformed(ActionEvent a)
     {
         String action;
        int match=-1;
        int cardv;
        int caction;
        action = a.getActionCommand(); 
        caction = Integer.parseInt(action);
          
        //Timer time= new Timer(1000, new CardFlip() );
       // time.setInitialDelay(10);
        //time.start();
         
        
          
          if (action=="flip"){
            }
            
          if (action=="reset"){
              //this.c = new Conc(2,6);
              //Intilaze the amount of cards
           for(int i=0; i<this.cardButts.length; i++){
               cardButts[i].setIcon(back);
             }
             p1score= new JLabel("0");
             p2score= new JLabel("0");
         }
         
          /** Check to make sure player is pushing cardButts */
          
          if(caction>=0 && caction <=cardButts.length){ 
            /** subtract second arg index(Players starts at 0) */
            match = c.move(caction,c.getTurn()-1);
            
            switch(match){
                  /**keep first up for player */
                case 0:cardv=c.getCardValue(caction);  
                       cardButts[caction].setIcon(pairs[cardv-1]);
                       break;
                case 1:cardv=c.getCardValue(caction);  
                       cardButts[caction].setIcon(pairs[cardv-1]);
                       break; 
                
                /**cards dont match */
                case 2: cardv=c.getCardValue(caction);
                        cardButts[caction].setIcon(pairs[cardv-1]);
                        
                        /**TODO ADD A DELAY BETWEEN FLIPS */
                        break;
                    }
                }
 
      p1score.setText(""+this.c.getPlayerScore(0));
        p2score.setText(""+this.c.getPlayerScore(1));
   
    }
    


}


       
        
    
    