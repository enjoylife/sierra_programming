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
void myName(void);

int main(void)
{
    myName();
    menu();
    return 0;

}

void menu(void)
{
   int choice = 0; 
   char repeat;
    do {
        printf("%s\n",NAME);
        printf("1 = Add a record\n");
        printf("2 = Report\n");
        printf("3 = Delete a record\n");
        printf("4 = Change a record\n");
        printf("5 = Quit\n");
        printf("Choose the number for a menu option\n");
        scanf("%d%*c", &choice);

        if (choice==1||choice==2||choice==3||choice==4||choice==5) {
        printf("%d was good choice. However were under construction.\n"
                "Pick again, y or n?\n", choice);
        scanf("%c%*c", &repeat);
        }
        else{
           printf("thats not a choice!\n"); 
           break;
        }
    } while (repeat!='n');
}
void myName(void)
{
    printf("My name is Matthew Clemens");
}
