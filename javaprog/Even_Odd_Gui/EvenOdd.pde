class EvenOdd
{
    int player1;
    int pot;
    int player2;
    
    int whose_turn=0;
    
  String title = "Even Odd Game";
 String author ="Matthew Clemens";
 String howto[] = loadStrings("howto.txt");
     /**  none
     * 
     * EvenOdd e= new EvenOdd();
     * e.player1 -> 0
     * e.player2 -> 0
     * e.pot -> 15
     * e.player1 + e.player2 + e.pot -> 15
     */
    void evenOddSetup()
    {
        this.player1= 0;
        this.player2= 0;
        this.pot= 15;
        this.whose_turn=0;
    }
    
    /**
     * p1move : move (int) -> boolean
     * Given the move that player1 chooses, return
     * whether is was a valid move, and substract that amount from pot
     * and add that amount to player1.
     * 
     * EvenOdd e= new EvenOdd();
     * e.evenOddSetup();
     * e.p1move(3) -> true
     * e.player1 -> 3
     * e.player2 -> 0
     * e.pot -> 12
     * e.p1move(4) -> false
     * e.p1move(1) -> true
     * e.p1move(2) -> true
     */
    boolean p1move(int move)
    {
        if (this.isValidMove(move) && this.whose_turn==1)
        {
            this.pot= this.pot - move;
            this.player1= this.player1 + move;
            this.whose_turn =2;
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * p2move : move (int) -> boolean
     * Given the move that player2 chooses, return
     * whether is was a valid move, and substract that amount from pot
     * and add that amount to player2.
     * 
     * EvenOdd e= new EvenOdd();
     * e.evenOddSetup();
     * e.p2move(3) -> true
     * e.player1 -> 0
     * e.player2 -> 3
     * e.pot -> 12
     * e.p2move(4) -> false
     * e.p2move(1) -> true
     * e.p2move(2) -> true
     */
    boolean p2move(int move)
    {
        if (this.isValidMove(move)&& this.whose_turn==2)
        {
            this.pot= this.pot - move;
            this.player2= this.player2 + move;
            this.whose_turn=1;
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * isValidMove : move (int) -> boolean
     * Given a move, return whether it is valid or not.
     * 
     * EvenOdd e= new EvenOdd();
     * e.evenOddSetup();
     * e.isValidMove(0) -> false
     * e.isValidMove(5) -> false
     * e.isValidMove(3) -> true
     * e.isValidMove(4) -> false
     * e.isValidMove(1) -> true
     * e.isValidMove(2) -> true
     * e.isValidMove(-1) -> false
     */
    boolean isValidMove(int move)
    {
        if ((move == 1 || move == 2 || move == 3) && pot - move >= 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * status : none -> String
     * Return a string showing the current state of the game
     * in the format "Player1: __ Player2: __ Pot: __"
     * 
     * EvenOdd e= new EvenOdd();
     * e.evenOddSetup();
     * e.status() -> "Player1: 0 Player2: 0 Pot: 15"
     * e.p1Move(3) -> true
     * e.status() -> "Player1: 3 Player2: 0 Pot: 12"
     */
    String status()
    {
        return "Player1: " + this.player1 + " Player2: " + this.player2 +
               " Pot: " + this.pot;
        
    }
    
    /**
     * whoWon: none -> int
     * Return a int based upon if the pot is at zero and 
     * which player has an even number in their counter.
     * 
     * EvenOdd e = new EvenOdd();
     * e.evenOddSetup();
     * e.player1=7;
     * e.player2=8;
     * e.pot= 0;
     * e.whoWon(); -> 2
     */
    int whoWon()
    {
        if (this.pot==0 && this.player1%2==0){
            return 1;
        }
        else if (this.pot==0 && this.player2%2==0){
            return 2;
        }
        else{
            return 0;
        }
    }
}
