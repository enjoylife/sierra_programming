import tester.*;

public class TestCodeWalk{
    
    void  testAverage(Tester t){
        CodeWalk c = new CodeWalk();
        t.checkInexact(c.average(1,1,1), 1.0,.01);
        t.checkInexact(c.average(3,4,5),4.0,.01);
        t.checkInexact(c.average(15,5,10),10.0,.01);
    }
    void testCloseTo20(Tester t){
        CodeWalk c = new CodeWalk();
        t.checkExpect(c.closeTo20(30,10,50),"Cha-ching!");
        t.checkExpect(c.closeTo20(31,42,19), "Cha-ching!");
        t.checkExpect(c.closeTo20(41,21,20), "Crud!");
    }

    void testTotalDays(Tester t){
        CodeWalk c = new CodeWalk();
        t.checkExpect(c.totalDays(2,4),18);
        t.checkExpect(c.totalDays(1,5),12);
        t.checkExpect(c.totalDays(0,3),3);
    }

    void testChangeBack(Tester t){
        CodeWalk c = new CodeWalk();
        t.checkExpect(c.changeBack(1.0), "Your change for $1.0 is 4 quarters, 0 dimes, 0 nickels, and 0 pennies.");
        t.checkExpect(c.changeBack(2.17),  "Your change for $2.17 is 8 quarters, 1 dimes, 1 nickels, and 2 pennies.");
        t.checkExpect(c.changeBack(.37), "Your change for $0.37 is 1 quarters, 1 dimes, 0 nickels, and 2 pennies.");
    }

    void testTriShape(Tester t){
        CodeWalk c = new CodeWalk();
        t.checkExpect(c.triShape(2,2,2), "equilateral");
        t.checkExpect(c.triShape(3,4,5),"scalene");
        t.checkExpect(c.triShape(1,2,7),"not a triangle");
        t.checkExpect(c.triShape(6,6,9),"isoscoles");
        t.checkExpect(c.triShape(0,0,0),"not a triangle");
    }


}

