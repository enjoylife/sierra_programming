/*------------------------------------------- 
Program: Sporting Good Menu validation with functions
Assignment for Week 5  
Tested  with gcc on linux
Author = Matthew Clemens
Date = 10/03/11
--------------------------------------------*/
#include <stdio.h>
#include <stdbool.h>
#include <stdarg.h>
#define NAME "Sierra Sporting Goods"

double profit(double, double);
double total(int, double);
void getint(int * check, int a , int b, char[]);
void getreal(double * check, double a, double b, char[]);

//bool validString(char mesg[], char *ans[]);
int menu(void);
int validInt(char  [], int , int);
char getValidChar(char []);
void add(void);
void show(int, int, int, double, double);
void showTotal(int, double, double, double);
void addEntry(void);
int main(void)
{
    
    int choice;
    bool more=true;

    do{
    choice = menu(); 
    switch(choice)
    {
        case 1: addEntry();
                break;
        case 2:
        case 3:
        case 4:
        case 5: more=false;
                printf("GoodBye\n");
                break;
        default: printf("GoodBye\n");
                 more =false;
                 break;
    }

   
    }while(more);

       

return 0;
} 

int menu(void){
   int choice = 0; 
       printf("%s\n",NAME);
        printf("1 = Add a record\n");
        printf("2 = Report\n");
        printf("3 = Delete a record\n");
        printf("4 = Change a record\n"); printf("5 = Quit\n");
       choice= validInt("Choose the number for a menu option",1, 5);
       return choice;
}
   /* 
    //Business logic functions 
    vprice = total(product_quantity , product_price);
    vcost = total(product_cost , product_quantity);
    vprofit = profit(vprice, vcost);

   //   Total for all entries 
    //Finally calculations for business logic 
    sum_price += vprice;
    sum_cost += vcost;
    sum_profit += vprofit;
    sum_quantity++;

    showTotal(sum_quantity, vprice, vcost, vprofit);
    */

void addEntry(void){
    int product_number, product_type, product_quantity;  
    double product_cost, product_price; 
    char pick;
    bool input;
   // char choice;
   
   do{
       /* User data entry*/
    getint(&product_number,1,9999, "product number");
    getint(&product_type,1,5, "product type");
    getint(&product_quantity,1,50, "product quantity");
    getreal(&product_cost,5.0,900.0,"product cost");
    getreal(&product_price,6.0,1000.0, "product price");

    show(product_number, product_type, product_quantity, product_cost, product_price);
    do{
   pick= toupper(getValidChar("Would you like to add another? (type Y/N)\n"));
   getchar();
    }while(!(pick=='Y'||pick=='N'));
       
   
   }while(toupper(pick)=='Y');
}

    




void show(int product_number, int product_type, int product_quantity, double product_cost, double product_price){

    printf("These are this entries calculations.\n");
      /* Single product display */
    printf("\nThe product number is ------ %04d\n", product_number);
    printf("The product type is ------ %d\n", product_type);
    printf("The quantity is ------ %d\n", product_quantity);
    printf("The cost is ------ $%.2lf\n", product_cost);
    printf("The price is ------ $%.2lf\n\n", product_price);
}

void showTotal(int total, double price, double cost, double profit){

    printf("Totals of all products\n");
    /* Single product business display */
   
    printf("Total count of different products -> %d\n", total);
    printf("Total product price ------ $%4.2lf\n", price);
    printf("Total product cost ------ $%4.2lf\n", cost);
    printf("Total product profit ------ $%4.2lf\n", profit);
}
double profit(double tp, double tc){
    double total;
    total = tp - tc;
    return total;
}

double total(int q , double p){
    double total;
    total = q * p;
    return total;
}



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

void getreal(double * check, double a, double b, char title[]){
    bool input = false;
    bool correct = false;
    printf("Please add the entry for %s,\nusing the range %.2lf to %.2lf\n", title, a, b);
    do{
    input = scanf("%lf%*c", check);
    if (input &&( *check > b|| *check < a)) {
        printf("Invalid entry.\nTry again!\n\n");
        printf("The input range is between %.2lf .... to %.2lf\n",a,b);
        *check=0;
    } 
    else if (!input) 
    {
        getchar();
        printf("Invalid entry.\nTry again!\n\n");
        printf("The input range is between %.2lf .... to %.2lf\n",a,b);
    }
    else{
        printf("Valid entry.\n\n");
        correct = true;
    }
    }while(!correct);

}
int validInt(char  mesg[], int low, int high){
    int choice;
    bool input=false;
    bool correct = false;
    printf("%s\n",mesg);
    do{
        input =scanf("%d%*c", &choice);
            if (!input||choice>high || choice <low) {
                printf("Thats not a choice!\nTry again!\n");
                getchar();
            }
    else{
        printf("%d, is a valid entry\n\n",choice);
        correct = true;
        }
    }while(!correct);
    return choice;
}
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
/*
bool  validString(char*strout,char mesg[], char *ans[]){
    bool input = false;        
    bool correct = false;      
    char answer[80];           
    printf("%s\n",mesg);       
    while(!correct){           
    fgets(answer,80,stdin);
        while(*ans){           
            if(answer==*ans){  
            return correct;
            }
        ans++;             

        }
        printf("Thats not the right choice!\nTry again!\n");
    } 
}   
*/


