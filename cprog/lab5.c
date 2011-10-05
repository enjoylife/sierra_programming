/*------------------------------------------- 
Program: Sporting Good Menu validation
Assignment for Week 5  
Tested  with gcc on linux
Author = Matthew Clemens
Date = 10/03/11
--------------------------------------------*/
#include <stdio.h>
#include <stdbool.h>
#define NAME "Sierra Sporting Goods"

double profit(double, double);
double price(int, double);
double cost(double, int);
void printValidInt(int * check, int a , int b, char[]);
void printValidDouble(double * check, double a, double b, char[]);

int menu(void);
int validInt(char  [], int , int);
char validChar(char [], char);
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
        printf("4 = Change a record\n");
        printf("5 = Quit\n");
        validInt("Choose the number for a menu option",1, 5);
}

void add(void){

    int product_number, product_type, product_quantity;  
    double product_cost, product_price; 
    char choice;
    double vprice, vcost, vprofit, total_price, total_cost;
    /*sums */
    double sum_profit = 0;
    double sum_price = 0;
    double sum_cost = 0;
    int sum_quantity = 0;

    printf("%s\n\n", NAME);
   do{
       /* User data entry*/
    printValidInt(&product_number,1,9999, "product number");
    printValidInt(&product_type,1,5, "product type");
    printValidInt(&product_quantity,1,50, "product quantity");
    printValidDouble(&product_cost,5.0,900.0,"product cost");
    printValidDouble(&product_price,6.0,1000.0, "product price");

    show(product_number, product_type, product_quantity, product_cost, product_price);
    /* 
    //Business logic functions 
    vprice = price(product_quantity , product_price);
    vcost = cost(product_cost , product_quantity);
    vprofit = profit(vprice, vcost);

   //   Total for all entries 
    //Finally calculations for business logic 
    sum_price += vprice;
    sum_cost += vcost;
    sum_profit += vprofit;
    sum_quantity++;

    showTotal(sum_quantity, vprice, vcost, vprofit);
    */

    printf("Would you like to add another? (type Y/N)\n");
    scanf(" %c%*c", &choice);
  
   }while(toupper(choice)=='Y');
    
}
void addEntry(void){
    int product_number, product_type, product_quantity;  
    double product_cost, product_price; 
    char choice;
 
   do{
       /* User data entry*/
    printValidInt(&product_number,1,9999, "product number");
    printValidInt(&product_type,1,5, "product type");
    printValidInt(&product_quantity,1,50, "product quantity");
    printValidDouble(&product_cost,5.0,900.0,"product cost");
    printValidDouble(&product_price,6.0,1000.0, "product price");

    show(product_number, product_type, product_quantity, product_cost, product_price);

    choice=validChar("Would you like to add another? (type Y/N)\n", 'Y');
   }while(toupper(choice)=='Y');
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

double price(int q , double p){
    double total;
    total = q * p;
    return total;
}

double cost(double c, int q){
    double total;
    total = c * q;
    return total;
}

void printValidInt(int * check, int a, int b, char title[]){
    bool input = false;
    bool correct = false;
    printf("Enter the %s\n", title);
    do{
    input= scanf("%d%*c", check);
       
        if (!input|| *check > b|| *check < a) 
        {
            printf("Invalid entry.\nTry again!\n\n");
            getchar();
        }
        else{
            printf("Valid entry.\n\n");
            correct = true;
        }
    }while(!correct);
}

void printValidDouble(double * check, double a, double b, char title[]){
    bool input = false;
    bool correct = false;
    printf("Enter the %s\n", title);
    do{
    input = scanf("%lf%*c", check);
       
        if (!input|| *check > b|| *check < a) 
        {
            printf("Invalid entry.\nTry again!\n\n");
            getchar();
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
        printf("Valid Entry\n\n");
        correct = true;
        }
    }while(!correct);
    return choice;
}
char validChar(char  mesg[], char choice){
    char pick;
    bool input = false;
    bool correct = false;
    printf("%s\n",mesg);
    do{
        input =scanf("%c%*c", &pick);
            if (!input||toupper(pick)!=choice) {
        printf("Thats not the right choice!\nTry again!\n");
        getchar();
        }
    else{
        printf("Valid Entry\n\n");
        correct = true;
        }
    }while(!correct);
    return pick;
}
