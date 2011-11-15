/** 
 * Program :Exam # 2  Realtor Report
 * Author - Matthew Clemens
 * Date 11/14/11
 */

#include <stdio.h>
#include <stdbool.h>
#include <stdarg.h>

void report(double * , char **);
void average(double * , double *, double *);

// Helper functions from past labs for ensuring correct input from user
void getint(int * check, int a , int b, char[]);
void getreal(double * check, double a, bool, char[]);
char getValidChar(char []);

int main(void)
{
    // Variables are indexed normally no... 0 place holder nonsense
    double sales_cost[5];
    char *names[5]={"Larry Lister", "Sue Sales", "Eva Escrow", "Morley Money", "Pete Profit"};
    double average_sales;
    double total_sales;

    //display logic Variables
    int name_pick;
    double sales_amount;
    char pick;
    int i;
    
    do{
        //Display the realtors names
    printf("Enter the corrasponding number for these realtors names\n");
        for (i = 0; i <5; i++) {
            printf("%d. %s\n",i+1, names[i]);
        }
    //Loop for user input to get name of employee to enter
    getint(&name_pick, 1,5,"Realtor Name");

    //lower users pick to correct array index
    name_pick=name_pick-1;
    
    //Loop for the sales amount
    getreal(&sales_amount, 0, 1," 1 Employee's sale");


    // update 
    *(sales_cost+name_pick)+= sales_amount;

    //check for adding more adding another
     do{
       pick= toupper(getValidChar("Would you like to add another? (type Y/N)\n"));
       getchar();
        }while(!(pick=='Y'||pick=='N'));

    // Exit condition for final display
   }while(toupper(pick)=='Y');

    //Calc the average and reports
    report(sales_cost,names);
    average(sales_cost, &total_sales, &average_sales);


    //Display final averages and totals
    printf("\n\nAverage = %10.2lf\n", average_sales);
    printf("Total = %10.2lf\n", total_sales);

}


//Prints out a pretty report for all of the sales employes 
void report(double * sales, char **depart)
{
    int i;
    //Formating the Header 
    printf("\nRealtor%10sTotal Sales\n", "");
    for (i = 0; i < 30; i++) {
        printf("-");
    }
    printf("-\n");

    //Formating the display columns
    for (i = 0; i < 5; i++) {
        printf("%-20s %10.2lf\n",*(depart+i),*(sales+i));
    }
}

// Calc the average and totals of all the employee' sales
void average(double * sales, double *total, double *average)
{
    int i;
    *total=0;
    for (i = 0; i < 5; i++) {
        *total+=*(sales+i);
    }
    *average = *total/5;
}

/* ----------------------------------------------------*/
/* -------------OLD HELPER FUNCTIONS ------------------*/
/* ----------------------------------------------------*/


/* Given a variable to check, a minumum amount, a true or false to check equals,
 * and a title to display,loop for user input untill the input
 * validates agasint the check */
void getreal(double * check, double a, bool or_eql, char title[]){
    bool input = false;
    bool correct = false;
    printf("Please add the entry for %s,\nusing at least %.2lf\n", title, a);

    do{
    input = scanf("%lf%*c", check);
    if (or_eql && input &&(*check < a)) {
        printf("Invalid entry.\nTry again!\n");
        printf("The input range is at least  %.2lf\n",a);
        *check=0;
    }
    else if (!or_eql && input &&(*check <= a)) {
        printf("Invalid entry.\nTry again!\n");
        printf("The input range has to be more than  %.2lf\n",a);
        *check=0;
    } 
    else if (!input) 
    {
        getchar();
        printf("Invalid entry.\nTry again!\n");
        printf("The input is a number like, %.2lf\n",a);
    }
    else{
        printf("Valid entry.\n\n");
        correct = true;
    }
    }while(!correct);

}



 /* Given a variable to check, a minumum amount,
 * and a title to display,loop for user input untill the input
 * validates agasint the check */
void getint(int * check, int a, int b, char title[]){
    bool input, correct = false;
    printf("Please add the entry for %s,\nusing the range %d to %d\n", title, a, b);
    do{
    input= scanf("%d%*c", check);
       if (input==1 &&(  *check > b || *check <a)) 
       {
            printf("Invalid entry.\nTry again!\n");
            printf("The input range is between %d .... to %d\n", a, b);
            *check=0;
      } 
       else if (input==0){
           getchar();
           printf("Wrong type of entry!\n");
            printf("The input range is between %d .... to %d\n", a, b);
            *check=0;
       }
        else{
            printf("Valid entry.\n\n");
            correct = true;
        }
    }while(!correct);
}

/* Give it a Display message and it returns a valid character */
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
