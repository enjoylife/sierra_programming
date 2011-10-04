/*------------------------------------------- 
Program: Sporting Good Menu validation
Assignment for Week 5  
Tested  with gcc on linux
Author = Matthew Clemens
Date = 10/03/11
--------------------------------------------*/
#include <stdio.h>
#define NAME "Sierra Sporting Goods"

double Profit(double, double);
double Price(int, double);
double Cost(double, int);
void ValidateInt(int * check, int a , int b, char[]);
void ValidateDouble(double * check, double a, double b, char[]);

int menu(void);
void add(void);
void show(int, int, int, double, double);

int main(void)
{
    
    int choice;
    do{
    choice = menu(); 
    add();
   printf("Totals of all products\n");
   showTotals();
   
    }while(scanf("%d%*c", &choice)==5)
   sum_quantity+=1;

   /* Summations of Products */
   printf("Total count of all products -> %d\n", sum_quantity);
   printf("Total of all prices ------ %4.2lf\n", sum_price);
   printf("Total of all costs ------ $%4.2lf\n", sum_cost);
   printf("Total profit ------ $ %4.2lf\n", sum_profit);
        

return 0;
} 

double Profit(double tp, double tc){
    double total;
    total = tp - tc;
    return total;
}

double Price(int q , double p){
    double total;
    total = q * p;
    return total;
}

double Cost(double c, int q){
    double total;
    total = c * q;
    return total;
}
void ValidateInt(int * check, int a, int b, char []title){
    printf("Enter the %s\n", title);
    while(scanf("%d%*c", check)==1){
       
        if (*check > b|| *check < a) 
        {
            printf("Invalid entry.\nTry again!\n\n");
        }
        else{
            printf("Valid entry.\n");
           break; 
        }
    }
}

void ValidateDouble(double * check, double a, double b, char []title){
    printf("Enter the %s\n", title);
    while(scanf("%lf%*c", check)==1){
       
        if (*check > b|| *check < a) 
        {
            printf("Invalid entry.\nTry again!\n\n");
        }
        else{
            printf("Valid entry.\n");
           break; 
        }
    }

}
int menu(void){
   int choice = 0; 
       printf("%s\n",NAME);
        printf("1 = Add a record\n");
        printf("2 = Report\n");
        printf("3 = Delete a record\n");
        printf("4 = Change a record\n");
        printf("5 = Quit\n");
        printf("Choose the number for a menu option\n");

        while(scanf("%d%*c", &choice)==1){
       
        if (choice>5 || choice <1) 
        {
            printf("Thats not a choice!\nTry again!\n");
        }
        
        else{
            printf("Valid Entry\n");
            return choice;
        }
    }
}
void add(void){

    int product_number, product_type, product_quantity;  
    double product_cost, product_price; 
    char choice;
    
   do{
       /* User data entry*/
    printf("%s\n\n", NAME);
    ValidateInt(&product_number,1,9999, "number");
    ValidateInt(&product_type,1,5, "type");
    ValidateInt(&product_quantity,1,50, "quantity");
    ValidateDouble(&product_cost,5.0,900.0,"cost");
    ValidateDouble(&product_price,6.0,1000.0, "price");
    void show(product_number, product_type, product_quantity, product_cost, product_price);
     
   
    printf("These are this entries calculations.\n");

    double price, cost, profit, total_price, total_cost;

    /*Business logic functions */
    price = Price(product_quantity , product_price);
    cost = Cost(product_cost , product_quantity);
    profit = Profit(price, cost);

    showTotal(price, cost, profit);

    printf("Would you like to continue? (type Y/N)\n");
    scanf(" %c%*c", &choice);
  
    while(toupper(choice)=='Y');
    }
}

void show(product_number, product_type, product_quantity, product_cost, product_price){

      /* Single product display */
    printf("\nThe product number is ------ %04d\n", product_number);
    printf("The product type is ------ %d\n", product_type);
    printf("The quantity is ------ %d\n", product_quantity);
    printf("The cost is ------ $%.2lf\n", product_cost);
    printf("The price is ------ $%.2lf\n\n", product_price);
}

void showTotal(price, cost, profit){

    /* Single product business display */
    printf("Total product price ------ $%4.2lf\n", price);
    printf("Total product cost ------ $%4.2lf\n", cost);
    printf("Total product profit ------ $%4.2lf\n", profit);
}

void totalCalc(price, cost, profit){
 /*sums */
    double sum_profit = 0;
    double sum_price = 0;
    double sum_cost = 0;
    int sum_quantity = 0;

/*  Total for all entries */
/*Finally calculations for business logic */
    sum_price += price;
    sum_cost += cost;
    sum_profit += profit;

}
