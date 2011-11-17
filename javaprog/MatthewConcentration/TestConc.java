import tester.*;

public class TestConc
{
    void testgetCardsRemain( Tester t){
        Conc c = new Conc(2,6);
        t.checkExpect(c.getCardsRemain(),6);
    }
    
    void testWhoseTurn(Tester t){
        Conc c = new Conc(2,6);
        t.checkExpect(c.getWhoseTurn(),1);
    }
    void testGameOver(Tester t){
        Conc c = new Conc(2,6);
        t.checkExpect(c.isGameOver(),false);
    }
    void testWhoWon(Tester t){
        Conc c = new Conc(2,6);
        t.checkExpect(c.whoWon(),0);
    }
    void testCardIndex(Tester t){
        Conc c = new Conc(2,6);
        t.checkExpect(c.getCardIndex(2), 2);
        t.checkExpect(c.getCardIndex(5), -1);
        Conc d = new Conc(2,20);
        t.checkExpect(d.getCardIndex(10),18);
        t.checkExpect(d.getCardIndex(6),10);
    }
    void testPickCard(Tester t){
        Conc c = new Conc(2,6);
        int index= c.getCardIndex(3);
        c.pickCard(c.cards[index]);
        t.checkExpect(c.cards[index].getStatus(), -1);
    }
    
    

}