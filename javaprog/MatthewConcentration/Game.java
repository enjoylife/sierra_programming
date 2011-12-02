import acm.graphics.*;
import acm.program.*;
import javax.swing.*;
import acm.gui.*;
import java.awt.event.*;

public class Game extends Program
{
    Conc c;
    
    TablePanel scoreboard;
    TablePanel cardboard;
    VPanel gameboard;
    JLabel p1score, p2score, playerturn ;  
   
    // perfect name
    JButton [] cardbutts;
    JButton flipback,reset;
    

    int NUMPLAYERS, NUMCARDS, cardindex1, cardindex2;
    ImageIcon back;
    ImageIcon [] pairs;
    //For Timer 
    CardFlip  cardflip;
    Timer timer;
    boolean waitover;
 
    public Game(int p, int c)
    {
        this.NUMPLAYERS = p;
        this.NUMCARDS = c;
        this.start();
    }
   
    public void init()
    {  
        if(NUMCARDS<10){
            
        cardboard= new TablePanel(NUMCARDS/2, NUMCARDS/2);
    }
    else{
        
        cardboard= new TablePanel(NUMCARDS/4, NUMCARDS/4);
    }
        c = new Conc(NUMPLAYERS,NUMCARDS);
        c.shuffle();
         pairs = new ImageIcon[NUMCARDS/2];
        cardbutts = new JButton[NUMCARDS];
        
        gameboard = new VPanel();
        this.add(gameboard);
        scoreboard = new TablePanel(2,3);
        scoreboard.setVisible(true);
        gameboard.add(scoreboard);
        
        cardboard.setVisible(true);
        gameboard.add(cardboard);
        
        p1score= new JLabel("0");
        p2score= new JLabel("0");
       
        cardindex1=-1; 
        cardindex2=-1;
        waitover =true;
        
        playerturn = new JLabel(""+c.getTurn());
        
        reset= new JButton("New Game");
        reset.setActionCommand("reset");
        

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

    }
    public void setCards(boolean b){
         for (int i=0, y=0; i <this.cardbutts.length; i++){
            this.cardbutts[i].setEnabled(b);
            
            }
    }
     
   public void startCardFlip(){
     System.out.println("Entered the flip method");
      timer = new Timer(1500,new CardFlip(this) );
      timer.setInitialDelay(1500);
      timer.setRepeats(false);
      timer.start();  
                    
      System.out.println("Finished with StartcardFlip");
                    
    } 

    public void actionPerformed(ActionEvent a)
     {
        String action;
        int match=-1;
        int cardv;
        int caction;
        
        action = a.getActionCommand();
        
         if (action=="reset"){
            
              this.c = new Conc(NUMPLAYERS, NUMCARDS);
              //Intilaze the amount of cards
           for(int i=0; i<this.cardbutts.length; i++){
               cardbutts[i].setIcon(back);
               cardbutts[i].setVisible(true);
               cardbutts[i].setEnabled(true);
             }
             
             this.setCards(true);
             p1score= new JLabel("0");
             p2score= new JLabel("0");
             cardindex1 =-1;
             cardindex2 =-1;
             System.out.println("This is a new test of Conc");
            
         }
         
 
         /** Check to make sure player is pushing cardbutts */
          caction = Integer.parseInt(a.getActionCommand());
          System.out.println("Caction is: "+caction);
          
          if(caction>=-1 && caction <=cardbutts.length && this.waitover){ 
            /** subtract second arg index(Players starts at 0) */
            match = c.move(caction,c.getTurn());
            System.out.println("Match is: "+match);
            System.out.println("Card action Enabled?: "+cardbutts[caction].isEnabled()+"action is :"+caction );
            switch(match){
                  /**keep first up for player */
                case 0:
                cardv=c.getCardValue(caction);  
                       cardbutts[caction].setIcon(pairs[cardv-1]);
                       cardindex1 = caction;
                       System.out.println("The cardindex1 is: "+cardindex1+ "    cardindex2 is: "+cardindex2);
                       break;
                       /** match */
                case 1:
                cardv=c.getCardValue(caction); 
                        cardindex2=caction;
                       cardbutts[caction].setIcon(pairs[cardv-1]);
                       cardbutts[cardindex1].setEnabled(false);
                       cardbutts[cardindex2].setEnabled(false);
                       cardindex2= -1;
                       cardindex1=-1;
                       System.out.println("The cardindex1 is "+cardindex1+ "    cardindex2 is"+cardindex2);
                       break; 
                
                /**cards dont match */
                case 2: cardv=c.getCardValue(caction);
                    cardbutts[caction].setIcon(pairs[cardv-1]); 
                
                        System.out.println("Entered cards dont match");
                        cardindex2= caction;
                        waitover= false;
                        this.startCardFlip();
                        
                        System.out.println("EndWrongMatch"); 
                        break;
                 default: break;
                 
           }
        }
                    
     System.out.println("------------ Main END ACTION--------------");
            
                    
       
      p1score.setText(""+this.c.getPlayerScore(1));
      p2score.setText(""+this.c.getPlayerScore(2));
      playerturn.setText(""+this.c.getTurn());
   
     
    }
    


}
/** This is used for the swiching back of the cards after a match
 * it's called in the timer constructor, passing the game with it
 */
 class CardFlip implements ActionListener{
     Game g;
     
     CardFlip(Game g){
         this.g=g;
        }

        public void actionPerformed(ActionEvent ac){
           String action;
           action= ac.getActionCommand();
           g.cardbutts[g.cardindex1].setIcon(g.back);
            g.cardbutts[g.cardindex2].setIcon(g.back); 
            g.waitover = true;
           System.out.println("Finished with action preform");
           }
   
   }

       
        
    
    