/*------------------------------------------- 
Program: Time value of moneyu
For study of finanical programs  
Tested and Compiled with gcc on linux
Author = Matthew Clemens
Date = 9/06/11
--------------------------------------------*/

#include <stdio.h>
#include <math.h>

int main(void)
{
     double principle;
     double interest_rate;
     double period;
     double years;
     double value;
    printf("Lets calculate the funamental princple called the Time Value of Money\n");
    printf("enter your intial investment\n");
    scanf("%lf", &principle);
    printf("enter the interest rate\n");
    scanf("%lf", &interest_rate);
    printf("Enter in the periods per year\n");
    scanf("%lf", &period);
    printf("Enter the number of years\n");
    scanf("%lf", &years);

    value =principle*pow((1+(interest_rate/period)), (period*years));
    printf("The Value is %.2lf\n",value);


    return 0;

}


