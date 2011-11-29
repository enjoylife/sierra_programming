/*------------------------------------------- 
Program: Sporting Good Menu validation with functions and arrays
Assignment for Week 10  
Tested  with gcc on linux
Author = Matthew Clemens
Date = 10/03/11
--------------------------------------------*/
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <stdarg.h>
#define NAME "Sierra Sporting Goods"

double profit(double, double);
double total(int, double);
void getint(int * check, int a , int b, char[]);
void getreal(double * check, double a, double b, char[]);
void show_costs(double *,char **depart, int);
void init_costs(double *, int);
//bool validString(char mesg[], char *ans[]);
int menu(void);
int validInt(char  [], int , int);
char getValidChar(char []);
void add(void);
void show(int, int, int, double, double,char []);
void showTotal(int, double, double, double);
void addEntry(void);
void getstring(char[]);
void strcase(char[]);
char *departments[5]={"Camping", "Tennis", "Golf", "Snow sports", "Water sports"};
void report(void);


typedef struct{
    int product_number, product_type, product_quantity;
    char description[100];
    double product_cost, product_price;
}storeRecord;


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
    case 2:report();
           break;
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


void addEntry(void){
    //Arrays dont leave this function
    double cost_array[5];
    char description[30];
    //NEW VARIABLES FOR LAB 10 
    storeRecord record;
    FILE *rec;
    
    //first two intials are for the name, last two for eith upper or lower limit
    // ex pn_ul " product number upper limit
    int pn_ll, pn_ul, pt_ll, pt_ul, pq_ll, pq_ul;
    double pc_ll, pc_ul, pp_ll, pp_ul;
    FILE *f_limits;

    char pick;
    bool input;

    //NEW PART FOR LAB 9
    f_limits = fopen("limits.txt","r");
    if (f_limits==NULL){ printf("File Does Not Exist"); exit(1);}
    fscanf(f_limits,"%d %d %d %d %d %d %lf %lf %lf %lf",
            &pn_ll, &pn_ul,//product number
            &pt_ll, &pt_ul,//product type
            &pq_ll, &pq_ul,//product quantity
            &pc_ll, &pc_ul,//product cost
            &pp_ll, &pp_ul);//product price

/*********************************/
/*  NEW FOR LAB 10 */
/*********************************/
    rec = fopen("sportstorerec.db", "ab");
    if (rec==NULL) {fputs ("File error",stderr); exit (1);}

    init_costs(cost_array, 5);
   do{
       /* User data entry*/
    getint(&record.product_number,pn_ll,pn_ul, "product number");
    getint(&record.product_type,pt_ll,pt_ul, "product type");
    getstring(record.description);
    strcase(record.description);
    getint(&record.product_quantity,pq_ll,pq_ul, "product quantity");
    getreal(&record.product_cost,pc_ll,pc_ul,"product cost");
    getreal(&record.product_price,pp_ll,pp_ul, "product price");
    
    // Add this entries cost to the cost array for end of run print out
    *(cost_array+(record.product_type-1))+=record.product_cost;

    // Displays this entry only
    show(record.product_number, record.product_type, record.product_quantity,
            record.product_cost, record.product_price, record.description);

    // Displays the run of entries 
    show_costs(cost_array,departments, 5);

    //NEW FOR LAB 10
    //writes this record to the file
    fwrite (&record, 1 , sizeof(record), rec);

    do{
   pick= toupper(getValidChar("Would you like to add another? (type Y/N)\n"));
   getchar();
    }while(!(pick=='Y'||pick=='N'));
       
    //Cant forget this !
    fclose(rec);
   
   }while(toupper(pick)=='Y');



}

/*********************************/
/*********************************/
/*  NEW FOR LAB 10 */
/*********************************/
/*********************************/
void report()
{
    double single_total_price, single_total_cost, single_profit, total_profit;
    storeRecord record;
    FILE *rec;
    total_profit = 0;

    rec = fopen("sportstorerec.db", "rb");
    if (rec==NULL) {fputs ("File error",stderr); exit (1);}

    printf("%s%7s%15s%5s%7s%9s%10s\n", "prod#", "Type", "Description", "Qty", "Cost", 
            "Price", "Profit");
    printf("----------------------------------------------------------\n");
    while(fread(&record, sizeof(record), 1, rec)==1){

        //Calculate all the business logic for the printout
        single_total_price =total(record.product_quantity, record.product_price);
        single_total_cost =total(record.product_quantity, record.product_cost);
        single_profit = profit(single_total_price, single_total_cost);
        //Running total
        total_profit+= single_profit;


    printf("%d %7d %15s %5d %7.2lf %9.2lf %10.2lf\n",record.product_number, 
                            record.product_type, record.description, record.product_quantity,
                            record.product_cost, record.product_price, single_profit);
    }
    printf("----------------------------------------------------------\n");
    printf("Total expected profit     %5.2lf\n\n", total_profit);
    fclose(rec);
}

void init_costs(double *array, int size){
    int i;
    for (i = 0; i < size; ++i) {
        *(array+i) = 0;
    }
}
void show_costs(double *array,char **descrip, int size){
   int space=40; 
   int i;
    printf("Type %s%s%s %s\n","         ","Depart.","         ","Costs");
    for (i = 0; i < space+4; i++) {
        printf("-");
    }
    printf("\n");
    for (i = 0; i < size; i++) {
        double cost = *(array+i);
        printf("%d%15s %5.s %15.2lf\n", i+1,descrip[i],"$ ", cost);
    }
}

void getstring(char *description){
    printf("Enter the product description------: ");
        gets(description);
} void strcase(char *description){
    int i = 0;
    *(description+i)=toupper(*(description+i));
    i=i+1;
    while(i<30){
         if(isspace(*(description+i))){
            *(description+(i+1))=toupper(*(description+(i+1)));
            i=i+2;

        }
        else{
            *(description+i)=tolower(*(description+i));
            i++;
        }
    }
}



void show(int product_number, int product_type, int product_quantity, double product_cost, double product_price, char description[]){

    printf("These are this entries calculations.\n");
      /* Single product display */
    printf("\nThe product number is -- %04d\n", product_number);
    printf("The product type is ------ %d\n", product_type);
    printf("The description is -------%s\n", description);
    printf("The quantity is --------- %d\n", product_quantity);
    printf("The cost is ------------$%.2lf\n", product_cost);
    printf("The price is ---------- $%.2lf\n\n", product_price);
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


