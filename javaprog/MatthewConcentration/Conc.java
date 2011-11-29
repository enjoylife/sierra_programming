/** for the array sort */
import java.util.Arrays;

/** Takes 2 args */
class Conc
{
   private Player [] players;
   public Card []cards;
   private int turn, cardsClicked, checkCard1, checkCard2, cardsRemain, NUMCARDS, NUMPLAYERS;
   
   
   
   // card.id 1-3 if in play, negative if face up, zero if not in play
  
   
    
    public Conc(int players, int cards)
    {
        this.NUMPLAYERS= players;
        this.NUMCARDS = cards;
        this.players = new Player[this.NUMPLAYERS];
        
        for (int i=0;i<this.players.length ;i++ )
        {
            /** dont want a zero player id, id*/
            this.players[i] = new Player((i+1), "Player: "+(i+1));
           
        }

        this.cards = new Card[this.NUMCARDS];
        this.initalizeCards();
        this.turn= 1;
        this.cardsRemain= NUMCARDS;
        this.cardsClicked= 0;
    }
    
      /** Set the cards arrary obj's.Values to have a matching id  */
    void initalizeCards()
    {
        for (int i=0;i<this.cards.length ;i++ ){
            this.cards[i] = new Card(i);
            this.cards[i].setValue((i/2)+1);
        }
        
    }
    /** Helper for debuging of array */
    void cards(){
        for(int i=0;i<this.cards.length ;i++ ){
            System.out.println(this.cards[i].getValue());
        }
    }
    /** Return a players score */
    int getPlayerScore(int p){
        return this.players[p].getScore();
    }
         
       /** Linear search helper to get the index after shuffle */
   public int getCardIndex(int cardV){
       int index =-1;
       for (int i=0;i<this.cards.length ;i++ ){
        if(this.cards[i].getValue()==cardV)
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
                 total+=this.cards[i].getStatus();
                 
             }
             this.cardsRemain=NUMCARDS-total;
         }
         return this.cardsRemain;
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
        if(isGameOver()&& cardsClicked>1){
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
   */
  public int move( int card, int player){
      /** Check first if this is even legal */
      if(isValidMove(card)&&(this.turn==player)){
          /** -1 to signify picked or out of play */
          if (this.cardsClicked ==0){
          cards[card].setStatus(-1);
          this.cardsClicked++;
          this.checkCard1= cards[card].getValue();
          return 0;
        }
        /** Second turn so need to check */
        else if( this.cardsClicked == 1){
            this.cardsClicked = 0;
            this.checkCard2= cards[card].getValue();
            this.turn++;
            /** we have a good match follow up with score change*/
            if(this.checkCard2==this.checkCard1){
                this.checkCard2=0;
                this.checkCard1=0;
                /** add to this players score */
                int score =this.players[player-1].getScore();
                this.players[player-1].setScore(score+1);
                return 1;
                
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
                
                return 2;
                
            }
        }       
    }
    return -1;
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
       "This Game has "+ this.NUMPLAYERS+" players, "+ this.NUMCARDS +" cards, \n"+
       "Cards Clicked:"+ this.cardsClicked +"  Whose turn: " + this.turn + ". And he has clicked "+
       this.cardsClicked +" cards,"+ " Cards left:" + this.cardsRemain +"\n";
       
       
    }
   
                  
   
    
    
    
}
