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
    JLabel p1score, p2score, playerTurn;
    JButton reset;
    Conc c;
    // perfect name
    JButton [] cardButts;
    JButton flipback;
    Timer timer;
    int players, cards;
    int card1=0, card2=0;
    ImageIcon back;
    ImageIcon [] pairs;

  
  ActionListener cardFlip = new ActionListener()
    {    
        
        public void actionPerformed(ActionEvent a){
          
           
          if(card1!=0 && card2!=0){
              System.out.println("ENTERED ACtion");
         cardButts[card1].setIcon(back);
         cardButts[card2].setIcon(back);
         
          
         
         
         
        }
        }
    };
    
    
    public Game()
    {
        
        this.start();
    }
    
    public void init()
    {
       
         
        timer = new Timer(3000, cardFlip);
         timer.setRepeats(false);
         
         
        c = new Conc(2,6);
        gameboard = new VPanel();
        this.add(gameboard);
        cardButts = new JButton[6];
        pairs = new ImageIcon[3];
        
        
        
        scoreboard = new TablePanel(2,3);
        gameboard.add(scoreboard);
        
        cardboard= new TablePanel(2, 3);
        cardboard.setVisible(true);
        gameboard.add(cardboard);
        
        p1score= new JLabel("0");
        p2score= new JLabel("0");
        
        playerTurn = new JLabel(""+c.getTurn());
        reset= new JButton("New Game");
        reset.setActionCommand("reset");
        
        flipback= new JButton("Flip Over");
        flipback.setActionCommand("flip");
        
        scoreboard.add(p1score);
        scoreboard.add(reset);
        scoreboard.add(p2score);
        scoreboard.add(playerTurn);
        
        
         
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
        for(int i=0; i<this.cardButts.length; i++){
             cardButts[i].addActionListener(cardFlip);
            
        }
      
       
        
    }
        
    public void actionPerformed(ActionEvent a)
     {
         String action;
        
        int match=-1;
        int cardv;
        
        int caction;
        action = a.getActionCommand(); 
       
        
                        
      
       
          
          if (action=="flip"){
            }
            
          if (action=="reset"){
              this.c = new Conc(2,6);
              //Intilaze the amount of cards
           for(int i=0; i<this.cardButts.length; i++){
               cardButts[i].setIcon(back);
               cardButts[i].setVisible(true);
               cardButts[i].setEnabled(true);
             }
             p1score= new JLabel("0");
             p2score= new JLabel("0");
             card1 =0;
             card2 =0;
             System.out.println("This is a test");
         }
         
          /** Check to make sure player is pushing cardButts */
          caction = Integer.parseInt(a.getActionCommand());
          System.out.println("Caction is"+caction);
          
          if(caction>=-1 && caction <=cardButts.length){ 
            /** subtract second arg index(Players starts at 0) */
            match = c.move(caction,c.getTurn()-1);
             System.out.println("Match is"+match);
            
            switch(match){
                  /**keep first up for player */
                case 0:cardv=c.getCardValue(caction);  
                       cardButts[caction].setIcon(pairs[cardv-1]);
                      
                       System.out.println("Card"+cardButts[caction].isEnabled() );
                       card1 = caction;
                       
                       break;
                       /** match */
                case 1:cardv=c.getCardValue(caction);  
                       card2= caction;
                       cardButts[caction].setIcon(pairs[cardv-1]);
                        cardButts[card1].setEnabled(false);
                        cardButts[card2].setEnabled(false);
                       
                       break; 
                
                /**cards dont match */
                case 2: cardv=c.getCardValue(caction);
                        card2= caction;
                        cardButts[caction].setIcon(pairs[cardv-1]);
                        cardButts[card1].removeActionListener(this);
                        cardButts[card2].removeActionListener(this);
                        timer.start();
                        
                        cardButts[card2].doClick();
                        cardButts[card1].addActionListener(this);
                        cardButts[card2].addActionListener(this);
                        
                        
                        
                        
                        
                        
                        
                       
                        
                        /**TODO ADD A DELAY BETWEEN FLIPS */
                        
                        
                        break;
                 default: break;
                    }
                }
 
      p1score.setText(""+this.c.getPlayerScore(0));
        p2score.setText(""+this.c.getPlayerScore(1));
        playerTurn.setText(""+this.c.getTurn());
   
    }
    


}


       
        
    
    