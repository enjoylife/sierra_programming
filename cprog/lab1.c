/*------------------------------------------- 
Program: Sporting Good Menu
Assignment for Week 1  
Tested and Compiled with gcc on linux
Author = Matthew Clemens
Date = 8/25/11
--------------------------------------------*/

#include <stdio.h>
#define NAME "Sierra Sporting Goods"

void menu(void);

int main(void)
{
    menu();
    return 0;

}

void menu(void)
{
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
            continue;
        }
            printf("%d was good choice. However were under construction.\n", choice);
            printf("Go Again if you would like. . .\n");
        }
        if(choice!= 1){
            printf("learn to enter a number!\n");
        }


}

