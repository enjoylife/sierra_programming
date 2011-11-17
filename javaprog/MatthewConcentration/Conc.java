import java.util.Arrays;

class Conc
{
   public Player [] players;
   private int turn;
   private int cardsRemain;    // 0-6
   private int cardsClicked;  // 0, 1, or 2
   public Card []cards;   // card.id 1-3 if in play, negative if face up, zero if not in play
   private int NUMCARDS;
   private int NUMPLAYERS;
   
    
    public Conc(int players, int cards)
    {
        this.NUMPLAYERS= players;
        this.NUMCARDS = cards;
        this.players = new Player[this.NUMPLAYERS];
        for (int i=0;i<this.players.length ;i++ )
        {
            this.players[i] = new Player((i+1));
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
            this.cards[i].setValue(((i+1)/2)+1);
        }
        
    }
    
  
   
    /** helper to get the index after shuffle */
   public int getCardIndex(int cardV){
       int index =-1;
       for (int i=0;i<this.cards.length ;i++ ){
        if(this.cards[i].getValue()==cardV)
            index = i;
        }
        return index;     
        } 
    /**Sum all cards status var and sub that from NUMCARDS */ 
    public int getCardsRemain()
    {
        int total=0;
         for (int i=0;i<this.cards.length ;i++ ){
             if(this.cards[i].getStatus()<0){
                 total+=this.cards[i].getStatus();
             }
         }
         return NUMCARDS-total;
    }
     /** Return the player id of whos turn is up */
    int getWhoseTurn(){
        for(int i=0; i<this.players.length; i++){
            if(players[i].getId()==this.turn){
                return players[i].getId();
            }
        }
        return -1;
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
     * isValidMove : Card -> boolean
     * Given the card , return whether
     * it is valid to turn that card over.
     */
    boolean isValidMove(Card card){
        boolean test =false;
        if(isGameOver()){
            return false;
        }
        else {
           switch (card.getStatus()){
            case 1: test = true; break;
            case -1: test = false; break;
           }
           return test;
        }
    }
    /** pickCard : int -> None
     * Given a card value, change that cards status to picked 
     */
    void pickCard(Card card){
        int index=getCardIndex(card.getValue());
        cards[index].setStatus(-1);
     }    
    /** Complete a players turn */
     void turn(int cardv, int playerid){
         int index = getCardIndex(cardv);
         if (isValidMove(cards[index])&&this.turn==playerid){
             this.pickCard(cards[index]);
            
             
             
        
            }
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
    
   
   
        
            
   
    
    
    
}
