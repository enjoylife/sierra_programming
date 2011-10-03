import tester.*;

class TestCodeWalk{
    
    void  TestAverage(Tester t){
        CodeWalk c = new CodeWalk();
        t.checkExpect(c.Average(1,1,1), 1;
        t.checkExpect(c.Average(3,4,5),4);
        t.checkExpect(c.Average(15,5,10),10);
    }
    void TestCloseTo20(Tester t){
        CodeWalk c = new CodeWalk();
        t.checkExpect(c.CloseTo20(30,10,50),"Cha-ching!");
        t.checkExpect(c.CloseTo20(31,42,19), "Cha-ching!");
        t.checkExpect(c.CloseTo20(41,21,20), "Crud!");
    }

    void TestTotalDays(Tester t){
        CodeWalk c = new CodeWalk();
        t.checkExpect(c.TotalDay(2,4),18);
        t.checkExpect(c.TotalDay(1,5),12);
        t.checkExpect(c.TotalDay(0,3),3);
    }

    void TestChangeBack(Tester t){
        codeWalk c = new CodeWalk();
        t.checkExpect(c.ChangeBack(1.0), "Your change for $1.00 is  4 quarters, 0 dimes, 0 nickels, and 0 pennies.");
        t.checkExpect(c.ChangeBack(2.17),  "Your change for $1.00 is  8 quarters, 1 dimes, 1 nickels, and 2 pennies.");
        t.checkExpect(c.ChangeBack(.37), "Your change for $1.00 is  4 quarters, 0 dimes, 0 nickels, and 0 pennies.");
    }

    void TestTriShape(Tester t){
        CodeWalk c = new CodeWalk();
        t.checkExpect(c.TriShape(2,2,2), "equilateral");
        t.checkExpect(c.TriShape(3,4,5),"scalene");
        t.checkExpect(c.TriShape(1,2,7),"not a triangle");
        t.checkExpect(c.TriShape(6,6,9),"isoscoles");
        t.checkExpect(c.TriShape(0,0,0),"not a triangle");
    }


}

