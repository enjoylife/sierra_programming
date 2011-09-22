class CodeWalk {
    /**
     * Average: num1 (double) num2 (double) num3 (double) -> (double)
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
        else{
            return "Crud!"
        }

    }
 

}
