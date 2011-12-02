/** for the array sort */
import java.util.Arrays;

/** Takes 2 args
*   Example: Conc c = new Conc(2,6); // This creates a game with 2 players 6 cards
*/

class Conc
{
   public Player [] players;
   public Card []cards;
   public int turn, cardsclicked, checkcardvalue1,
               checkcardvalue2, cardsremain;
   private int pickindex1, pickindex2;
   private int NUMCARDS, NUMPLAYERS;
   
   
   /**
    *  Game Logic:
    *  1) card.status = [1-3]   //if in play, negative if face up, zero if not in play
    *  
    */ 
    public Conc(int players, int cards)
    {
        this.NUMPLAYERS= players;
        this.NUMCARDS = cards;
        this.cardsremain= NUMCARDS;
        
        this.players = new Player[this.NUMPLAYERS];
        this.cards = new Card[this.NUMCARDS];
        
        this.turn= 1;
        this.cardsclicked= 0;
        
        for (int i=0;i<this.players.length ;i++ )
        {
            /**GOTCHAS: dont want a zero player id, id*/
            this.players[i] = new Player("Random Name", (i+1));
        }
        /** GOTCHA: Cards have a matching pair of id's */
        for (int i=0;i<this.cards.length ;i++ ){
            this.cards[i] = new Card("Card name:None",(i/2)+1);
        }        

    }
    
    
    /** Helper for debuging of array */
    void cards(){
        
        for(int i=0;i<this.cards.length ;i++ ){
            System.out.println(this.cards[i].getValue());
            System.out.println(""+this.cards[i].printStatus());
        }
    }
    
    /** Return a players score 
       GOTCHAS: Uses 0 indexing (aka player1 is acutally [o] )*/
    public int getPlayerScore(int p){
        return this.getPlayer(p).getScore();
        
    }
   
    
    /** Helper to see the card value inGame */
    public int getCardValue(int v){
        return this.cards[v].getValue();
    }
       
    
       /** Linear search helper to get a player object
        * Reason: easy to only give an id
        */
   
   public Player getPlayer(int id){
       int index=0;
       for(int i=0; i<this.players.length; i++){
           if(this.players[i].getId()==id){
             index=i;
            }
        }
       return this.players[index];
    }
        
    /**Sum all cards that have a negative status (AKA their out of play) */ 
    public int getCardsRemain()
    {
        int total=0;
         for (int i=0;i<this.cards.length ;i++ ){
             if(this.cards[i].getStat("status")<0){
                 total++;  
             }
         }
         return this.cardsremain=NUMCARDS-total;
    }

    /**
     * isGameOver : none -> boolean
     * Return whether the game is over or not.
     */
    boolean isGameOver()
    {
        if(this.cardsremain>0)
            return false;
        else return true;
    }
    
    public int getTurn()
    {
        return this.turn;
    }
    
    /**
     * whoWon : none -> int
     * Return the player number of the winner or
     * zero if the game is not over yet.
     */
    int whoWon(){
        int winner=-1;
        if (!isGameOver()){
            return winner =0;
        }
        else {
            for(int i=0; i<players.length; i++){
                if (players[i].getScore()>winner){
                    winner=players[i].getId();
                }
            }        
       }
       return winner;
    }
       
    
    /**
     * isValidMove : int -> boolean
     * Given the card , return whether
     * it is valid to turn that card over. True if it is, false otherwise
     */
    boolean isValidMove(int cardIndex){
        boolean test =false;
        if(isGameOver()){
            return false;
        }
        else {
            
           switch (cards[cardIndex].getStat("status")){
            case 1: test = true; break;
            case -1: test = false; break;
           }
           return test;
        }
    }
    
  /** Move ->int card , int player -> int
   * Given an index to both a player and a card, turn the card status 
   * to out of play and increase the cards clicked and return 0 if player needs to go again, 1 if cards
   *  match, or 2 if they dont match or -1 if something goes wrong
   *  GOTCHAS: players and cards start at 0 index.
   */
  public int move( int card, int player){
      int legal=-1;
      /** Check first if this is  illegal */
  if(isValidMove(card)&&(this.turn==player)){
      
      /** So it is legal proceed */
          /** The first move */
     if (this.cardsclicked ==0){
          cards[card].setStat("status",-1);
          //store value for the 2nd turn equallity check
          this.checkcardvalue1= cards[card].getValue();
          //store index for the 2nd turn
          this.pickindex1=card;
          //Increase the count
          this.cardsclicked++;
          legal= 0;
        }
        /** Second turn so need to check */
        else if( this.cardsclicked == 1){
            this.checkcardvalue2= cards[card].getValue();
            this.pickindex2 = card;
            cards[card].setStat("status",-1);
            
            /** we have a good match follow up with score change*/
            if(this.checkcardvalue2==this.checkcardvalue1){
                this.checkcardvalue2=-1;
                this.checkcardvalue1=-2;
                /** add to this players score */
                int score =this.players[player-1].getScore();
                this.getPlayer(player).setScore(score+1);
                legal= 1;
                //resset all back 
                this.cardsclicked = 0;
                this.pickindex1=-1;
                this.pickindex2=-1;
                
            }
            /** No match */
            else {
                this.cards[pickindex1].setStat("status", 1);
                this.cards[pickindex2].setStat("status",1);
                
                 /** increase the turn counter logic for if last player's turn */
                 if(this.turn>=NUMPLAYERS){
                      this.turn=1;
                 }
                 else{
                      this.turn++;
                 }
                //Reset all back
                this.cardsclicked = 0;
                this.pickindex1=-1;
                this.pickindex2=-1;
                /** And reset the check cards just for good mesure */
                this.checkcardvalue2=0;
                this.checkcardvalue1=0;
                legal=2;
            }
        }       
    }
   else{legal=-1;
      }
    return legal;
   }
 
  
    /** Poor implementation of a shuffle */
    void shuffle(){
        Card tempc;
       
        for(int i =0; i<NUMCARDS*3; i++){
        int cindex = (int)(Math.random()*NUMCARDS);
        int cindex2 = (int)(Math.random()*NUMCARDS);
         //int cardnum=cards[cindex].getValue();
         //int cardnum2=cards[cindex2].getValue();
         tempc = cards[cindex];
         cards[cindex]=cards[cindex2];
         cards[cindex2]=tempc;
         
         /** or just use a smart approach. . .  Collections.shuffle(Arrays.asList(cards)); */
        }
    }
    /** Helper to provide debuging display */
   String status(){
       return
       "This Game has "+ this.NUMPLAYERS+" players, "+ this.NUMCARDS +" cards, "+
       "Cards Clicked:"+ this.cardsclicked +"  Whose turn: " + this.turn + ". And he has clicked "+
       this.cardsclicked +" cards,"+ " Cards left:" + this.getCardsRemain() +"\n";
       
       
    }
   
                  
   
    
    
    
}
