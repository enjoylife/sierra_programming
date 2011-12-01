/** for the array sort */
import java.util.Arrays;

/** Takes 2 args
*   Example: Conc c = new Conc(2,6); // This creates a game with 2 players 6 cards
*/

class Conc
{
   public Player [] players;
   public Card []cards;
   public int turn, cardsclicked, checkcard1,
   checkcard2, cardsremain;
   
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
    public int getCheckCard(int c){
        if (c==1)return this.checkcard1;
        else return this.checkcard2;
    }
         
       /** Linear search helper to set the status back to a regular card
        * Reason: cards indexs are random after shuffle
        */
   public int getCardIndex(int cardV){
       int index =-1;
       for (int i=0;i<this.cards.length ;i++ ){
        if(this.cards[i].getValue()==cardV)
            index = i;
        }
        return index;     
        } 
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
        if(getCardsRemain()>0)
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
      if(!(isValidMove(card))||!(this.turn==player)){
          return legal;
      }
      /** So it is legal proceed */
      else{
            
          /** -1 to signify picked or out of play 
          *   The first move */
          if (this.cardsclicked ==0){
          cards[card].setStat("status",-1);
          
          this.checkcard1= cards[card].getValue();
          legal= 0;
          this.cardsclicked=1;
        }
        /** Second turn so need to check */
        else if( this.cardsclicked == 1){
            
            this.checkcard2= cards[card].getValue();
            cards[card].setStat("status",-1);
           
            /** we have a good match follow up with score change*/
            if(this.checkcard2==this.checkcard1){
                
                this.checkcard2=0;
                this.checkcard1=0;
                /** add to this players score */
                int score =this.players[player].getScore();
                this.getPlayer(player).setScore(score+1);
                legal= 1;
                this.cardsclicked = 0;
                
            }
            else {
                /** We have a loser. Need to reset the cards status back to in play 
                int index=this.getCardIndex(checkcard2);
                int index1=this.getCardIndex(checkcard1);*/
                this.cards[checkcard1].setStat("status", 1);
                this.cards[checkcard2].setStat("status",1);
                /** And reset the check cards just for good mesure */
                this.checkcard2=0;
                this.checkcard1=0;
                 /** increase the turn counter */
                 if(this.turn>=NUMPLAYERS){
                      this.turn=1;
                    }
                      else{
                        this.turn++;
                      }
                this.cardsclicked = 0;
                legal=2;
                
            }
        }       
    }
    return legal;
   }
     
        
  
    /** Poor implementation of a shuffle */
    void shuffle(){
        
        for(int i =0; i<NUMCARDS*3; i++){
        int cindex = (int)(Math.random()*NUMCARDS);
        int cindex2 = (int)(Math.random()*NUMCARDS);
         int cardnum=cards[cindex].getValue();
         int cardnum2=cards[cindex2].getValue();
         cards[cindex].setValue(cardnum2);
         cards[cindex2].setValue(cardnum);
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
