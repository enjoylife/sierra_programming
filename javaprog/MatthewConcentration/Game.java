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
    JLabel p1score, p2score, playerturn;
    JButton reset;
    Conc c;
    // perfect name
    JButton [] cardbutts;
    JButton flipback;
    Timer timer;
    int players, cards;
    int card1=-1, card2=-1;
    ImageIcon back;
    ImageIcon [] pairs;

  
  ActionListener cardFlip = new ActionListener()
    {    
        
        public void actionPerformed(ActionEvent a){
           String action= a.getActionCommand();
           System.out.println("Started CARDLOGIC");
            if (action=="flip"){
                 if(card1!=-1 && card2!=-1){
                       System.out.println("ENTERED CardFlip ACtion");
                       cardbutts[card1].setIcon(back);
                       cardbutts[card2].setIcon(back); 
                }
            System.out.println("Finished with cardFlip");
           }
           }
       };
    
    
    public Game()
    {
        
        this.start();
    }
    private void startCardFlip(){
        
        this.flipback.doClick();
    }
    public void init()
    {
       
         
        timer = new Timer(2000, cardFlip);
        timer.setRepeats(false);
        this.timer.start();
         
        
        System.out.println("Timer has just started");
         
        c = new Conc(2,6);
        gameboard = new VPanel();
        this.add(gameboard);
        cardbutts = new JButton[6];
        pairs = new ImageIcon[3];
        
        
        
        scoreboard = new TablePanel(2,3);
        gameboard.add(scoreboard);
        
        cardboard= new TablePanel(2, 3);
        cardboard.setVisible(true);
        gameboard.add(cardboard);
        
        p1score= new JLabel("0");
        p2score= new JLabel("0");
        
        playerturn = new JLabel(""+c.getTurn());
        reset= new JButton("New Game");
        reset.setActionCommand("reset");
        reset.addActionListener(this);
        
        
        flipback= new JButton("Flip Over");
        flipback.setActionCommand("flip");
        flipback.addActionListener(cardFlip);
        scoreboard.add(p1score);
        scoreboard.add(reset);
        scoreboard.add(p2score);
        scoreboard.add(playerturn);
        
        
         
        //picture for back of cards
        back= new ImageIcon("back.png");
        // Pair pictures
        for (int i=0, y=0; i <this.cardbutts.length; i++){
            //get the value
            y=this.c.getCardValue(i);
            //match the value with a pair
            //Remember this.c.CardValue() returns a value between 1 and the half of the cards
            pairs[y-1] = new ImageIcon("128/flag"+(y-1)+".png");
        }
        
        //Intilaze the amount of cards
        for(int i=0; i<this.cardbutts.length; i++){
            this.cardbutts[i] = new JButton();
            this.cardbutts[i].setActionCommand(""+i);
            this.cardbutts[i].setIcon(back);
            this.cardboard.add(cardbutts[i]);
            cardbutts[i].setVisible(true);
            cardbutts[i].addActionListener(this);
            
            
        }
        
        this.addActionListeners();
       
        /** for(int i=0; i<this.cardbutts.length; i++){
             cardbutts[i].addActionListener(cardFlip);
            
        }*/
      
       
        
    }
        
    public void actionPerformed(ActionEvent a)
     {
        String action;
        int match=-1;
        int cardv;
        int caction;
        
        
        action = a.getActionCommand();
         
            
          if (action=="reset"){
              this.c = new Conc(2,6);
              //Intilaze the amount of cards
           for(int i=0; i<this.cardbutts.length; i++){
               cardbutts[i].setIcon(back);
               cardbutts[i].setVisible(true);
               cardbutts[i].setEnabled(true);
             }
             p1score= new JLabel("0");
             p2score= new JLabel("0");
             card1 =-1;
             card2 =-1;
             System.out.println("This is a new test of Conc");
             System.out.println("The card1 is "+card1+ "    Card2 is"+card2);
         }
         
          /** Check to make sure player is pushing cardbutts */
          caction = Integer.parseInt(a.getActionCommand());
          System.out.println("Caction is: "+caction);
          
          if(caction>=-1 && caction <=cardbutts.length){ 
            /** subtract second arg index(Players starts at 0) */
            match = c.move(caction,c.getTurn());
             System.out.println("Match is: "+match);
            System.out.println("Card action Enabled?: "+cardbutts[caction].isEnabled() );
            switch(match){
                  /**keep first up for player */
                case 0:cardv=c.getCardValue(caction);  
                       cardbutts[caction].setIcon(pairs[cardv-1]);
                      
                       
                       card1 = caction;
                       
                       System.out.println("The card1 is "+card1+ "    Card2 is"+card2);
                       break;
                       /** match */
                case 1:cardv=c.getCardValue(caction);  
                      
                       cardbutts[caction].setIcon(pairs[cardv-1]);
                        cardbutts[card1].setEnabled(false);
                        cardbutts[cardv].setEnabled(false);
                       card2= -1;
                       card1=-1;
                       System.out.println("The card1 is "+card1+ "    Card2 is"+card2);
                       break; 
                
                /**cards dont match */
                case 2: cardv=c.getCardValue(caction);
                System.out.println("Entered cards dont match");
                        card2= caction;
                        cardbutts[caction].setIcon(pairs[cardv-1]);
                        //cardbutts[card1].removeActionListener(this);
                        //cardbutts[card2].removeActionListener(this);
                        
                        this.startCardFlip();
                        
                        System.out.println("StartCARDFLIP");
                        
                        //System.out.println("Second card has been prog clicked");
                       
                        /**TODO ADD A DELAY BETWEEN FLIPS */
                        System.out.println("The card1 is "+card1+ "    Card2 is"+card2);
                        break;
                 default: break;
                    }
                }
 
      p1score.setText(""+this.c.getPlayerScore(0));
        p2score.setText(""+this.c.getPlayerScore(1));
        playerturn.setText(""+this.c.getTurn());
   
    }
    


}


       
        
    
    