/*------------------------------------------- 
Program:Raffle program  tracker
Exam for C programming
Tested  with gcc on linux
Author = Matthew Clemens
Date = 10/11/11
--------------------------------------------*/
#include <stdio.h>
#include <stdbool.h>
#include <stdarg.h>


void getreal(double * check, double a, char[]);
void show(double, double, double);
double total(double, double);
char getValidChar(char []);

int main(void)
{
  double ticket_cost, ticket_amount, ticket_total;
  char pick;
    do{
        getreal(&ticket_cost,5.0,"amount per raffle ticket");
        getreal(&ticket_amount,1.0, "number of raffle tickets purchased");

        ticket_total=total(ticket_cost, ticket_amount);
        show(ticket_cost, ticket_amount, ticket_total);
        do{
           pick= toupper(getValidChar("Would you like to add another? (type Y/N)\n"));
           getchar();
        }while(!(pick=='Y'||pick=='N'));
   
   }while(toupper(pick)=='Y');
    return 0;
}

/* Given an amount and price, return the total cost */
double total(double ticket_amount, double ticket_price)
{
    double total;
    total= ticket_amount*ticket_price;
    total = (total >500.0) ? 500.0: total;
    return total;

}
/*show a display for each argument */
void show(double t_C, double t_A, double t_T)
{
    printf("Total raffle tickets purchased ------ $%4.2lf\n", t_A);
    printf("Cost per raffle ticket ------ $%4.2lf\n", t_C);
    printf("Total raffle tickets cost ------ $%4.2lf\n", t_T);
}

/* Given a variable to check, a minumum amount and a title to display,
 * loop for user input untill the input validates agasint the check */
void getreal(double * check, double a, char title[]){
    bool input = false;
    bool correct = false;
    printf("Please add the entry for %s,\nusing at least %.2lf\n", title, a);
    do{
    input = scanf("%lf%*c", check);
    if (input &&(*check < a)) {
        printf("Invalid entry.\nTry again!\n");
        printf("The input range is at least %.2lf\n",a);
        *check=0;
    } 
    else if (!input) 
    {
        getchar();
        printf("Invalid entry.\nTry again!\n");
        printf("The input range is at least %.2lf\n",a);
    }
    else{
        printf("Valid entry.\n\n");
        correct = true;
    }
    }while(!correct);

}
/* Given a message to display the valid entry needed, loop untill user input is a char,
 * then return that character */
char getValidChar(char  mesg[]){
    char pick;
    bool input = false;
    bool correct = false;
    printf("%s\n",mesg);
    do{
        pick =getchar();
        if (!(isalpha(pick))) {
            printf("Thats not a character!\nTry a letter from a-Z!\n");
            getchar();
        }
        else{
            correct = true;
        }
    }while(!correct);
    return pick;
}

