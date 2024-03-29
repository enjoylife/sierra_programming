class CodeWalk {
    
    /**
     * average: num1 (double) num2 (double) num3 (double) -> double
     * Given three numbers return their average.
     * 
     * CodeWalk c = new CodeWalk();
     * c.average(1,1,1) -> 1
     * c.average(3,4,5) -> 4
     * c.average(15,5,10) -> 10
     */
    double average(double num1, double num2, double num3){
        return (num1 + num2 + num3)/3;
    }

    /**
     * closeTo20:  num1 (int) num2 (int) num3 (int) -> String
     * Given three numbers return "Cha-ching!" if at least one of them is less than 20,
     * And "Crud!" otherwise.
     *
     * CodeWalk c = new CodeWalk();
     * c.closeTo20(30,10,50) -> "Cha-ching!"
     * c.closeTo20(31,42,19)-> "Cha-ching!"
     * c.closeTo20(41,21,20) -> "Crud!"
     */
    String closeTo20(int num1, int num2, int num3){
        if(num1 <20 || num2 <20 || num3<20){
            return  "Cha-ching!";
        }
        else{ 
            return "Crud!";
        }

    }

    /**
     * TotalDays: weeks (int) days (int) -> int
     * Given the Total number of weeks and days, return the 
     * Sum of the days.
     * 
     * CodeWalk c = new CodeWalk();
     * c.totalDays(2,4) -> 18
     * c.totalDays(1,5) -> 12
     * c.totalDays(0,3) -> 3
     */
    int totalDays(int weeks, int days){
        if (weeks <0 || days <0 ){
            return 0;
        }
        else{
            return days + (weeks*7);
        }
    }
    /** 
     * changeBack: money (double) -> String
     * Given a dollar amount as a numerical value, 
     * return the amount back as a string of quarters,
     * dimes, nickels, and pennies, it takes.
     * 
     * CodeWalk c = new CodeWalk();
     * c.changeBack(1.0) -> "Your change for $1.00 is  4 quarters, 0 dimes, 0 nickels, and 0 pennies."
     * c.changeBack(2.17) -> "Your change for $2.17 is 8 quarters, 1 dimes, 1 nickels, and 2 pennies."
     * c.changeBack(.37) -> "Your change for $0.37 is 1 quarters, 1 dimes, 0 nickels, and 2 pennies."
     */

    String changeBack(double money){
        int quarters, dimes, nickels, pennies;
        if(money<=0){
            return "No change back for you!";
        }
        else   {
            /** casting for desired pretty output.*/
         double finmoney = money;
         money = money *100;
         quarters=(int) money /25;
         money =money%25; 
         dimes =(int) money/10;
         money =money%10; 
         nickels =(int) money/5;
         money =money%5; 
         pennies = (int)money/1;
         
         return "Your change for $" + finmoney + " is " + quarters +" quarters, " + dimes +" dimes, "+ nickels+" nickels, and "+pennies+" pennies.";
        }
    }

    /**
     * triShape: side1 (int) side2 (int) side3(int) -> String
     * Given the lengths of the sides of a triangle, return the strings , 
     * "equilateral", "isoscoles", "scalene",or "not a triangle" depending upon the mathematical 
     * definitions of side length for each.
     * 
     * CodeWalk c = new CodeWalk();
     * c.TriShape(2,2,2) -> "equilateral"
     * c.TriShape(3,4,5) -> "scalene"
     * c.TriShape(1,2,7) -> "not a triangle"
     * c.TriShape(6,6,9) -> "isoscoles"
     * c.TriShape(0,0,0) -> "not a triangle"
     */
    String triShape(int side1, int side2, int side3){
        boolean test1, test2, test3, test4, test5, test6;
        
        /** All tests must be true for sides to mathematically be a triangle */
        test1=(side1+side2)>side3;
        test2=(side1+side3)>side2;
        test3=(side2+side3)>side1;
        test4=side1>0;
        test5=side2>0;
        test6=side3>0;

        if(!(test1 && test2 && test3 && test4 && test5 && test6)){
        return "not a triangle";
        }
        else{ 
            if(side1==side2 && side1==side3){
                return "equilateral";
            }
            else if(side1!=side2 && side2!=side3 && side1!=side3){
                return "scalene";
            }
            else{
                return "isoscoles";
            }
        } 
    }
}
