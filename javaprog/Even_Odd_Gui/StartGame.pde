
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
 print(this.game.whose_turn+"\n"); //Debug 
 }
 
 void menu(){
   int spacing=100;
   
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
     
    print("end menu\n"); //Debug 
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


