class Conc
{
   private int [] scores;
   private int turn;
   private int cardsRemain;    // 0-6
   private int cardsClicked;  // 0, 1, or 2
   private int []cards;   // 1-3 if in play, negative if face up, zero if not in play
   private int first, second;
   private int NUMCARDS=6;
   private int NUMPLAYERS=2;
    
    public Conc()
    {
        //Add 1 to score to keep sanity when array indexing
        this.scores = new int[this.NUMPLAYERS+1];
        this.cards = new int[this.NUMCARDS];
        this.turn= 1;
        this.cardsRemain= 6;
        this.cardsClicked= 0;
        this.first= 0;
        this.second= 0;
    }
    public int getScore(int player)
    {
        return this.scores[player];
    }
    
    public int getCardsRemain()
    {
        return this.cardsRemain;
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
       return(getCardsRemain() ? false  : true);
    }
    /**
     * whoWon : none -> int
     * Return the player number of the winner or
     * zero if the game is not over yet.
     * Conc c = new Conc();
     * c.getP2Score()->0;
     * c.getP1Score()->3;
     * c.whoWon(); -> 1
     * Con c2 = new Conc();
     * c2.getP2Score()->2;
     * c2.getP1Score()->1;
     * c2.whoWon() -> 2
     */
    int whoWon(){
        if (!isGameOver()){
            return 0;
        }
        else {
            highScores= scores.sort;
            if (highScores[0]>highScores[1]){
                return 
                    
    }
    
    /**
     * isValidMove : int -> boolean
     * Given the card number (1-6), return whether
     * it is valid to turn that card over.
     * Conc c = new Conc();
     *
     * c.isValidMove(2) -> true
     */
    boolean isValidMove(cardchoice){
        if(isGameOver()||(!(whoWon()==0))){
            return false;
        }
        else {

            return true;
        }
    }
    }
