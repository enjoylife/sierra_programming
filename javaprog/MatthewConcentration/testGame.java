import acm.graphics.*;
import acm.program.*;
import javax.swing.*;
import acm.gui.*;
import java.awt.event.*;

public class testGame extends Program
{

 Timer timer;
 ImageIcon back;
 JButton flipback;


 int testnum=0;
 
 public testGame(){
     this.start();
     timer.restart();
    }
 
 public void init(){
     
     
     
     
     
        
        ActionListener cardFlip= new cardFlip(this);
        timer = new Timer(3000, cardFlip);
        timer.setInitialDelay(3000);
        timer.setRepeats(false);
        timer.start();
        
        flipback= new JButton("Flip Over");
        flipback.setActionCommand("flip");
        flipback.addActionListener(cardFlip);
        flipback.setVisible(true);
       
         this.add(flipback);
    }
    public void flip(){
        timer = new Timer(3000, cardFlip);
        timer.setInitialDelay(3000);
        timer.setRepeats(false);
        timer.start();
        this.testnum++;
        System.out.println(""+testnum);
    }
 public class cardFlip implements ActionListener{
                 testGame game;
        cardFlip(testGame g){
            this.game=g;
        }
            
        
        public void actionPerformed(ActionEvent ac){
            
           String action;
           action= ac.getActionCommand();
           System.out.println("Started CARD LOGIC");
           System.out.println("action is: "+action);
            if (action=="flip"){
            System.out.println("THIS IS WORKING ");
            game.flip();
            }
            System.out.println("Finished with cardFlip\n");
           }
          
           
           
           
       };
    }