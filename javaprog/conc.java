import java.util.Arrays;

class Conc
{
   private Player [] players;
   private int turn;
   private int cardsRemain;    // 0-6
   private int cardsClicked;  // 0, 1, or 2
   private Card []cards;   // card.id 1-3 if in play, negative if face up, zero if not in play
   private int first, second;
   private int NUMCARDS=6;
   private int NUMPLAYERS=2;
   
    
    public Conc()
    {
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
    public int getScore(Player p)
    {
        return p.getScore();
    }
    
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


    /**
     * isGameOver : none -> boolean
     * Return whether the game is over or not.
     * Conc c = new Conc();
     * c.cardsRemain=1
     * c.isGameOver()-> false
     * c.cardsRemain=0
     * c.isGameOver() -> false
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
        Player winner = new Player(0);
        if (!isGameOver()){
            return 0;
        }
        else {
            Arrays.sort(this.players);
            winner = this.players[0];
            return winner.getId();
        }
                    
    }
    
    /**
     * isValidMove : int -> boolean
     * Given the card number, return whether
     * it is valid to turn that card over.
     */
    boolean isValidMove(int cardstatus){
        boolean test =false;
        if(isGameOver()){
            return false;
        }
        else {
           switch (cardstatus){
            case 1: test = true; break;
            case -1: test = false; break;
           }
           return test;
        }
    }

    void initalizeCards()
    {
        for (int i=0;i<this.cards.length ;i++ ){
            this.cards[i] = new Card((i/2+1));
        }
    }

    void shuffle(){

        for(int i =0; i<NUMCARDS*3; i++){
        int cindex = (int)(Math.random()*NUMCARDS);
        int cindex2 = (int)(Math.random()*NUMCARDS);
         int cardnum=cards[cindex].getId();
         int cardnum2=cards[cindex2].getId();
         cards[cindex].setId(cardnum2);
         cards[cindex2].setId(cardnum);
        }


    }

    int getWhoseTurn(){
        return this.turn;
    }
}

