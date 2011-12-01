/** for the array sort */
import java.util.Arrays;

/** Takes 2 args
*   Example: Conc c = new Conc(2,6); // This creates a game with 2 players 6 cards
*/

class Conc
{
   public Player [] players;
   public Card []cards;
   public int turn, cardsClicked, checkCard1,
   checkCard2, cardsRemain, NUMCARDS, NUMPLAYERS;
   
   
   
   /**
    *  Game Logic:
    *  1) card.status = [1-3]   //if in play, negative if face up, zero if not in play
    *  
    */ 
  
   
    
    public Conc(int players, int cards)
    {
        this.NUMPLAYERS= players;
        this.NUMCARDS = cards;
        this.players = new Player[this.NUMPLAYERS];
        this.cards = new Card[this.NUMCARDS];
        
        for (int i=0;i<this.players.length ;i++ )
        {
            /**GOTCHAS: dont want a zero player id, id*/
            this.players[i] = new Player((i+1), "Player: "+(i+1));
        }

        
        this.initalizeCards();
        this.turn= 1;
        this.cardsRemain= NUMCARDS;
        this.cardsClicked= 0;
    }
    
      /** Helper for Setting the cards.Values to have a matching id (aka their is pairs)
         GOTCHA: Cards have a starting 1 index
         */
    void initalizeCards()
    {
        for (int i=0;i<this.cards.length ;i++ ){
            this.cards[i] = new Card();
            this.cards[i].setValue((i/2)+1);
        }
    }
    
    /** Helper for debuging of array */
    void cards(){
        
        for(int i=0;i<this.cards.length ;i++ ){
            System.out.println(this.cards[i].getValue());
            System.out.println(this.cards[i].getStatus());
        }
    }
    /** Return a players score 
       GOTCHAS: Uses 0 indexing (aka player1 is acutally [o] )*/
    public int getPlayerScore(int p){
        
        return this.players[p].getScore();
    }
   
    
    /** Helper to see the card value inGame */
    public int getCardValue(int v){
        return this.cards[v].getValue();
    }
    public int getCheckCard(int c){
        if (c==1)return this.checkCard1;
        else return this.checkCard2;
    }
         
       /** Linear search helper to set the status back to a regular card
        * Reason: cards indexs are random after shuffle
        */
   public int getCardIndex(int cardV){
       int index =-1;
       for (int i=0;i<this.cards.length ;i++ ){
        if(this.cards[i].getValue()==cardV && this.cards[i].getStatus()==-1)
            index = i;
        }
        return index;     
        } 
        
    /**Sum all cards that have a negative status (AKA their out of play) */ 
    public int getCardsRemain()
    {
        int total=0;
        
         for (int i=0;i<this.cards.length ;i++ ){
             if(this.cards[i].getStatus()<0){
                 total++;
                 
             }
             
             
             
         }
         
         return this.cardsRemain=NUMCARDS-total;
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
        
        if (!isGameOver()){
            return 0;
        }
        else {
            Arrays.sort(this.players);
             return this.players[0].getId();
            
        }
                    
    }
    
    /**
     * isValidMove : int -> boolean
     * Given the card , return whether
     * it is valid to turn that card over. True if it is, false otherwise
     */
    boolean isValidMove(int cardIndex){
        boolean test =false;
        if(isGameOver()&& cardsClicked>2 ){
            return false;
        }
        else {
            
           switch (cards[cardIndex].getStatus()){
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
      if(!(isValidMove(card)&&(this.turn==player+1))){
          return legal;
      }
      /** So it is legal proceed */
      else{
            
          /** -1 to signify picked or out of play 
          *   The first move */
          if (this.cardsClicked ==0){
          cards[card].setStatus(-1);
          this.cardsClicked++;
          this.checkCard1= cards[card].getValue();
          legal= 0;
        }
        /** Second turn so need to check */
        else if( this.cardsClicked == 1){
            
            this.checkCard2= cards[card].getValue();
            cards[card].setStatus(-1);
           
            /** we have a good match follow up with score change*/
            if(this.checkCard2==this.checkCard1){
                
                this.checkCard2=0;
                this.checkCard1=0;
                /** add to this players score */
                int score =this.players[player].getScore();
                this.players[player].setScore(score+1);
                legal= 1;
                this.cardsClicked = 0;
                
            }
            else {
                /** We have a loser. Need to reset the cards status back to in play */
                int index=this.getCardIndex(checkCard2);
                int index1=this.getCardIndex(checkCard1);
                this.cards[index].setStatus(1);
                this.cards[index1].setStatus(1);
                /** And reset the check cards just for good mesure */
                this.checkCard2=0;
                this.checkCard1=0;
                 /** increase the turn counter */
            this.turn= this.turn>=NUMPLAYERS ? 1 : this.turn+1;
                this.cardsClicked = 0;
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
       "Cards Clicked:"+ this.cardsClicked +"  Whose turn: " + this.turn + ". And he has clicked "+
       this.cardsClicked +" cards,"+ " Cards left:" + this.getCardsRemain() +"\n";
       
       
    }
   
                  
   
    
    
    
}
