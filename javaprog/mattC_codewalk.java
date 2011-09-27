class CodeWalk {
    /**
     * Average: num1 (double) num2 (double) num3 (double) -> (Double)
     * Given three numbers return their average.
     * CodeWalk c = new CodeWalk();
     * c.Average(1,1,1) -> 1
     * c.Average(3,4,5) -> 4
     * c.Average(15,5,10) -> 10
     */
    double Average(double num1, double num2, double num3){
        return (num1 + num2 + num3)/3
    }

    /**
     * closeTo20:  num1 (int) num2 (int) num3 (int) -> (String)
     * Given three numbers return "Cha-ching!" if at least one of them is less than 20,
     * And "Crud!" otherwise.
     * CodeWalk c = new CodeWalk();
     * c.closeTo20(30,10,50) -> "Cha-ching!"
     * c.closeTo20(31,42,19)-> "Cha-ching!"
     * c.closeTo20(41,21,20) -> "Crud!"
     */
    String CloseTo20(int num1, int num2, int num3){
        if(num1 <20 || num2 <20 || num3<20){
            return  "Cha-ching!"
        }
        else{ return "Crud!"
        }

    }

    /**
     * TotalDays: weeks (int) days (int) -> (int)
     * Given the Total number of weeks and days, return the 
     * Sum of the days.
     * CodeWalk c = new CodeWalk();
     * c.TotalDays(2,4) -> 18
     * c.TotalDays(1,5) -> 12
     * c.TotalDays(0,3) -> 3
     */
    int TotalDays(int weeks, int days){
        if (weeks <0 || days <0 ){
            return 0
        }
        else{
            return days + (weeks*7)
        }
    }
    /** 
     * ChangeBack: money (double) -> (String)
     * Given a dollar amount as a numerical value, 
     * return the amount back as a string of quarters,
     * dimes, nickels, and pennies, it takes.
     * CodeWalk c = new CodeWalk();
     * c.ChangeBack(1.0) -> " Your change for $1.00 is  4 quarters."
     * c.ChangeBack(2.17) -> " Your change for $2.17 is 8 quarters, 1 dime, 1 nickel, and 2 pennies."
     * c.ChangeBack(.37) -> "Your change for $0.37 is 3 dimes, 1 nickel, and 2 pennies."
     */

    String ChangeBack(double money){
        if(money<=0){
            return "No change back for you!"
        }
        else {

        }
    
    }
}
