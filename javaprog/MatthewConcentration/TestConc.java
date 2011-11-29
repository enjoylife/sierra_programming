import tester.*;

public class TestConc
{
    void testgetCardsRemain( Tester t){
        Conc c = new Conc(2,6);
        t.checkExpect(c.getCardsRemain(),6);
    }
    
    void testGameOver(Tester t){
        Conc c = new Conc(2,6);
        t.checkExpect(c.isGameOver(),false);
    }
    void testWhoWon(Tester t){
        Conc c = new Conc(2,6);
        t.checkExpect(c.whoWon(),0);
    }
    void testPlayersScore(Tester t){
        Conc c = new Conc(2,6);
        t.checkExpect(c.getPlayerScore(0), 0);
        t.checkExpect(c.getPlayerScore(1), 0);
    }
    void testCardIndex(Tester t){
        Conc c = new Conc(2,6);
        t.checkExpect(c.getCardIndex(2), 3);
        t.checkExpect(c.getCardIndex(5), -1);
        Conc d = new Conc(2,20);
        t.checkExpect(d.getCardIndex(10),19);
        t.checkExpect(d.getCardIndex(6),11);
    }
    
    void testGame(Tester t){
        Conc c = new Conc(2,6);
        t.checkExpect(c.move(0,1),0);
        t.checkExpect(c.move(0,1),-1);
        t.checkExpect(c.move(1,1),1);
        t.checkExpect(c.getPlayerScore(0),1);
        t.checkExpect(c.getPlayerScore(1),0);
        t.checkExpect(c.move(0,2),-1);
        t.checkExpect(c.move(3,2),0);
    }
    
    void testisValidMove(Tester t){
        Conc c = new Conc(2,6);
        t.checkExpect(c.isValidMove(0), true);
        int check = c.move(0,1);
        int check2=c.move(1,1);
        t.checkExpect(c.isValidMove(0),false);
    }
    
    
    

}