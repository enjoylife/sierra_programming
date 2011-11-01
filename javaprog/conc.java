class Conc
{
   private int p1score, p2score;
   private int turn;
   private int cardsRemain;    // 0-6
   private int cardsClicked;  // 0, 1, or 2
   private int c1, c2, c3, c4, c5, c6;   // 1-3 if in play, negative if face up, zero if not in play
   private int first, second;
    
    public Conc()
    {
        this.p1score= 0;
        this.p2score= 0;
        this.turn= 1;
        this.cardsRemain= 6;
        this.cardsClicked= 0;
        this.c1= 1;
        this.c2= 1;
        this.c3= 2;
        this.c4= 3;
        this.c5= 2;
        this.c6= 3;
        this.first= 0;
        this.second= 0;
    }
    public int getP1Score()
    {
        return this.p1score;
    }
    
    public int getP2Score()
    {
        return this.p2score;
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
        if (!isGameOver()||(getP1Score()==getP2Score())){
            return 0;
        }
        else if(getP1Score()>getP2Score()){
            return 1;
        }
        else{
            return 2;
        }
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
