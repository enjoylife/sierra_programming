import tester.*;

class TestEvenOdd
{
    void testSetup(Tester t)
    {
        EvenOdd e= new EvenOdd();
        e.setup();
        t.checkExpect(e.player1 , 0);
        t.checkExpect(e.player2 , 0);
        t.checkExpect(e.pot , 15);
        t.checkExpect(e.player1 + e.player2 + e.pot , 15);

    }
    
    void testP1Move(Tester t)
    {
        EvenOdd e= new EvenOdd();
        e.setup();
        t.checkExpect(e.p1move(3), true);
        e.whose_turn=1;
        t.checkExpect(e.player1 , 3);
        e.whose_turn=1;
        t.checkExpect(e.player2 , 0);
        e.whose_turn=1;
        t.checkExpect(e.pot , 12);
        e.whose_turn=1;
        t.checkExpect(e.p1move(4) , false);
        e.whose_turn=1;
        t.checkExpect(e.p1move(1) , true);
        
        e.whose_turn=1;
        t.checkExpect(e.p1move(2) , true);
    }
    
    void testP2Move(Tester t)
    {
        EvenOdd e= new EvenOdd();
        e.setup();
        e.whose_turn=2;
        t.checkExpect(e.p2move(3), true);
        e.whose_turn=2;
        t.checkExpect(e.player1 , 0);
        e.whose_turn=2;
        t.checkExpect(e.player2 , 3);
        e.whose_turn=2;
        t.checkExpect(e.pot , 12);
        e.whose_turn=2;
        t.checkExpect(e.p2move(4) , false);
        e.whose_turn=2;
        t.checkExpect(e.p2move(1) , true);
        e.whose_turn=2;
        t.checkExpect(e.p2move(2) , true);
        e.whose_turn=2;
    }
    
    void testIsValidMove(Tester t)
    {
        EvenOdd e= new EvenOdd();
        e.setup();
        t.checkExpect(e.isValidMove(0) , false);
        t.checkExpect(e.isValidMove(5) , false);
        t.checkExpect(e.isValidMove(3) , true);
        t.checkExpect(e.isValidMove(4) , false);
        t.checkExpect(e.isValidMove(1) , true);
        t.checkExpect(e.isValidMove(2) , true);
        t.checkExpect(e.isValidMove(-1) , false);
        e.player1= 5;
        e.player2= 8;
        e.pot= 2;
        t.checkExpect(e.isValidMove(1), true);
        t.checkExpect(e.isValidMove(2), true);
        t.checkExpect(e.isValidMove(3), false);
        t.checkExpect(e.isValidMove(-1), false); 
    }
    
    void testStatus(Tester t)
    {
        EvenOdd e= new EvenOdd();
        e.setup();
        t.checkExpect(e.status(), "Player1: 0 Player2: 0 Pot: 15");
        t.checkExpect(e.p1move(3) , true);
        t.checkExpect(e.status() , "Player1: 3 Player2: 0 Pot: 12");
    }
    
    void testWhoWon(Tester t)
    {
        EvenOdd e = new EvenOdd();
        e.setup();
        e.player1=7;
        e.player2=8;
        e.pot=0;
        t.checkExpect(e.whoWon(),2);
        e.player1=8;
        e.player2=7;
        e.pot=0;
        t.checkExpect(e.whoWon(),1);
        e.player1=7;
        e.player2=8;
        e.pot=0;
        t.checkExpect(e.whoWon(),2);
        e.player1=5;
        e.player2=6;
        e.pot=4;
        t.checkExpect(e.whoWon(),0);
    }
        
}