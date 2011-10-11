 StartGame g;
void setup(){
  size(500,500);
  background(255);
  frameRate(30);
g = new StartGame();
  g.start();
  g.menu();
  loop();
 
}

void draw(){
   g.turnDisplay();
 g.update();
 
 g.gameOver();

}

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
class StartGame
{
  
 PFont font=loadFont("Ubuntu-Bold-48.vlw");   
EvenOdd game = new EvenOdd();
 String title, author;
 String howto[];
 int turn;
 
 
 void start(){
   
 this.title = this.game.title;
  this.author =this.game.author;
  this.howto =this.game.howto;
 this.game.evenOddSetup(); 
 
 this.turn =game.whose_turn;
 print(this.turn+"\n");
 }
 
 void menu(){
   int spacing=100;
   if(this.turn==0){
     fill(0,0,0);
     textAlign(CENTER);
     textFont(font,30);
     text(this.title,0,5,width,50);
     textFont(font, 20);
     text("by "+this.author, 0,40,width,100);
     textFont(font,15);
     
    for(int i=0; i< this.howto.length; i++){
      text(this.howto[i],0,spacing,width,height);
      spacing+=20;
    }
    print("end menu\n");
   }
    
    else{
      print("error");
    }
  }
  
  void player1Turn(){
    int pick;
    boolean correct;
    String msg;
    do{
      print("player do while");
      textFont(font,30);
      textAlign(LEFT);
      text("Enter your choice",width/2,height/2);
      pick = key;
        
      correct = this.game.p1move(pick);
    }while(!correct);
   msg=this.game.status();
   text(msg,width/2,height/2);
  if(this.game.whoWon()==0){
    this.player2Turn();
}else {
        this.gameOver();
    }
  }
  
  void player2Turn(){
     int pick;
    boolean correct;
    String msg;
    do{
      textFont(font,30);
      textAlign(LEFT);
      text("Enter your choice",width/2,height/2);
      pick = key;
        
      correct = this.game.p2move(pick);
    }while(!correct);
   msg=this.game.status();
   text(msg,width/2,height/2);
   if(this.game.whoWon()==0){
    this.player1Turn();
}else {
        this.gameOver();
    }
  }
  
  void turnDisplay(){
   if(this.turn==1){
    textAlign(LEFT);
   textFont(font,30);
  text("Player 1's turn",width/4,height-50);
  }
  else if(this.turn==2){
    textAlign(LEFT);
   textFont(font,30);
  text("Player 2's turn",width-(width/4),height-50);
  }
  else{
    textAlign(CENTER);
   textFont(font,30);
  text(" Game start witt Player 1's turn",width/2,height-50);
  print("start turn display esle");

   
  }
  
}
void gameOver(){
 textAlign(CENTER);
textFont(font,50);
if (this.game.whoWon()==1){
        text("Player1 won",width/2,height/2);
    }
    else if(this.game.whoWon()==2)
    {
            text("Player2 won",width/2,height/2);
    }
    else{
      this.update();
    }
    
}

void update(){
  textAlign(CENTER);
  textFont(font,30);
  text("The Pot is ->"+this.game.pot,width/2,height/2+30);
  text("The player 1 has ->"+this.game.player1,width/2,height/2+60);
  text("The player 2 has ->"+this.game.player2,width/2,height/2+90);
  this.turn =game.whose_turn;
  print("enterd update");
  if(this.game.whose_turn==0){
    this.player1Turn();
  }
  else if (this.game.whose_turn==1){
    this.player1Turn();
  }
  else
  this.player2Turn();
  
}
}
