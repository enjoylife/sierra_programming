/*------------------------------------------- 
Program: Sporting Good Menu
Assignment for Week 2  
Tested and Compiled with gcc on linux
Author = Matthew Clemens
Date = 8/29/11
--------------------------------------------*/
#include <stdio.h>
#define NAME "Sierra Sporting Goods"

int main(void)
{
  int product_number, product_type, product_quantity;  
  double cost, price;
    
    printf("%s\n\n", NAME);

    printf("Enter the product number:");
    scanf("%d%*c", &product_number); 

    printf("Enter the product type:");
    scanf("%d%*c", &product_type);

    printf("Enter the quantity:");
    scanf("%d%*c", &product_quantity);

    printf("Enter cost:");
    scanf("%lf%*c", &cost);

    printf("Enter the price:");
    scanf("%lf%*c", &price);

    printf("The product number is %d\n", product_number);
    printf("The product type is %d\n", product_type);
    printf("The quanity is %d\n", product_quantity);
    printf("The cost is %.2lf\n", cost);
    printf("The price is %.2lf\n", price);

} 

