/*------------------------------------------- 
Program: Sporting Good Menu
Assignment for Week 2  
Tested  with gcc on linux
Author = Matthew Clemens
Date = 8/29/11
--------------------------------------------*/
#include <stdio.h>
#define NAME "Sierra Sporting Goods"

double Profit(double, double);
double Price(int, double);
double Cost(double, int);


int main(void)
{
  int product_number, product_type, product_quantity;  
  double product_cost, product_price; 
  double price, cost, profit, total_price, total_cost, total_profit;
  char choice;

    double sum_price = 0;
    double sum_cost = 0;
    int sum_quantity = 0;



   do{

    printf("%s\n\n", NAME);

    printf("Enter the product number:");
    scanf("%d%*c", &product_number); 

    printf("Enter the product type:");
    scanf("%d%*c", &product_type);

    printf("Enter the quantity:");
    scanf("%d%*c", &product_quantity);

    printf("Enter cost:");
    scanf("%lf%*c", &product_cost);

    printf("Enter the price:");
    scanf("%lf%*c", &product_price);

    printf("\nThe product number is ------ %04d\n", product_number);
    printf("The product type is ------ %d\n", product_type);
    printf("The quanity is ------ %d\n", product_quantity);
    printf("The cost is ------ $%.2lf\n", product_cost);
    printf("The price is ------ $%.2lf\n", product_price);


    sum_price += product_price;
    sum_cost += product_cost;
    sum_quantity+=1;

    price = Price(product_quantity , product_price);
    cost = Cost(product_cost , product_quantity);
    profit = Profit(price, cost);


    printf("Total product price ------ $%4.2lf\n", price);
    printf("Total product cost ------ $%4.2lf\n", cost);
    printf("Total product profit ------ $%4.2lf\n", profit);
    
    printf("Would you like to continue? (type Y/N)\n");
    scanf(" %c%*c", &choice);
  }
    while(choice=='Y');
      /* 
        if (choice=='y' || choice =='Y') 
        {   printf("%20s %20s %20s %10s %10s\n", "Product number", 
                "Product type", "product quantity", "cost", "price");
            printf("%20d %20d %20d %10.2lf %10.2lf\n", product_number, 
                    product_type, product_quantity, cost, price);
            break;
        }*/
   total_price = Price(sum_quantity, sum_price);
   total_cost = Cost(sum_cost, sum_quantity);
   total_profit = Profit(total_price, total_cost);
   printf("Total count of all products -> %d\n", sum_quantity);
   printf("Total of all prices ------ %4.2lf\n", total_price);
   printf("Total of all costs ------ $%4.2lf\n", total_cost);
   printf("Total profit ------ $ %4.2lf\n", total_profit);
        

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


