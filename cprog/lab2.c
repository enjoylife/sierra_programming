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
  char choice;
    
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

    printf("\nThe product number is ------ %d\n", product_number);
    printf("The product type is ------ %d\n", product_type);
    printf("The quanity is ------ %d\n", product_quantity);
    printf("The cost is ------ $%.2lf\n", cost);
    printf("The price is ------ $%.2lf\n", price);

    printf("Would you like to see and alternate view? (type y/n)\n");

    while(scanf(" %c%*c", &choice)==1){
       
        if (choice=='y' || choice =='Y') 
        {   printf("%20s %20s %20s %10s %10s\n", "Product number", 
                "Product type", "product quantity", "cost", "price");
            printf("%20d %20d %20d %10.2lf %10.2lf\n", product_number, 
                    product_type, product_quantity, cost, price);
            break;
        }
    
        if(choice=='n'){
            printf("Ok then, BYE!\n");
            break;
        } 
    }
        

return 0;
} 

