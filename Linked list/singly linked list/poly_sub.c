#include <stdio.h>
#include <stdlib.h>
struct node {
     int coeff, power;
     struct node *next;
};
typedef struct node poly;
// 2 pointers to point to start of 2 polynomials
poly *start1, *start2, *temp, *start;
void create (int), add(), display();
void main () {
     // temp is a "pointer" pointing to the current element in the list  
     // hence temp will contain the data of the node in poly 
     // hence needs to be assigned memory too 
     start = (poly *)malloc(sizeof(poly));
     create(1);
     create(2);
     add();
     display();
}
void create(int x) {
     int i, n;
     printf("enter number of terms : ");
     scanf("%d", &n);
     // both start have to be assigned memory only when creating
     // assigning memory to start again would lose the address of the entire linked list
     if (x == 1) {
          start1 = (poly *)malloc(sizeof(poly));
          temp = start1;
     }
     if (x == 2) {
          start2 = (poly *)malloc(sizeof(poly));
          temp = start2;
     }
     for (i = 0; i < n; i++) {
          printf("enter the co efficient and the power : ",i);
          scanf("%d %d",&temp->coeff, &temp->power);
          if (i == n-1) temp ->next = NULL;
          else {
               temp -> next = (poly *)malloc(sizeof(poly));
               temp = temp -> next;
          }
     }
}
void add() {
     poly *temp1, *temp2;
     //temp1 = (poly *)malloc(sizeof(poly));
     //temp2 = (poly *)malloc(sizeof(poly));
     temp1 = start1;
     temp2 = start2;
     temp = start;
     // application of for loop here not applicable as we have logical relation between 2 conditions
     while (temp1 ->next != NULL && temp2 ->next != NULL) {
          //temp = (poly *)malloc(sizeof(poly));
          if (temp1 -> power == temp2 -> power) {
               //insert((temp1 -> coeff) + (temp2 -> coeff), temp1 -> power)
               temp -> coeff = (temp1 -> coeff) - (temp2 -> coeff);
               temp -> power = temp1 -> power; 
               temp1 = temp1 ->next;
               if (temp1 -> next == NULL && temp2 -> next != NULL) {
                    temp2 = temp2 ->next;
                    temp -> next = (poly*)malloc(sizeof(poly));
                    temp = temp -> next;
               }
               if (temp2 -> next == NULL && temp1 -> next != NULL) {
                    temp1 = temp1 ->next;
                    temp -> next = (poly*)malloc(sizeof(poly));
                    temp = temp -> next;
               }
               if (temp1 ->next == NULL && temp2 -> next == NULL) {
                    temp ->next = NULL;
                    break;
               }
               printf("1\n");
          }
          else if ((temp1 -> power > temp2 -> power) || (temp2 ->next == NULL)) {
               temp -> power = temp1 ->power;
               temp -> coeff = temp1 -> coeff;
               temp1 = temp1 ->next;
               if (temp1 -> next == NULL) {
                    temp -> next = (poly*)malloc(sizeof(poly));
                    temp = temp -> next;
               }
               else if (temp1 ->next == NULL && temp2 -> next == NULL) {
                    temp ->next = NULL;
                    break;
               }
               else {
                    temp -> next = (poly*)malloc(sizeof(poly));
                    temp = temp -> next;
               }
               printf("2\n");
          }
          else if ((temp1 -> power < temp2 -> power) || (temp1 ->next == NULL)) {
               temp -> power = temp2 ->power;
               temp -> coeff = temp2 -> coeff;
               temp2 = temp2 ->next;
               if (temp1 -> next == NULL) {
                    temp -> next = (poly*)malloc(sizeof(poly));
                    temp = temp -> next;
               }
               else if (temp1 ->next == NULL && temp2 -> next == NULL) {
                    temp ->next = NULL;
                    break;
               }
               else {
                    temp -> next = (poly*)malloc(sizeof(poly));
                    temp = temp -> next;
               }
               printf("3\n");
          }
     }      
     // loop is exited when not only one but both the loop reach the null condition as we have or 
     // seperately add the least term from the two polynomial to the result as the last one is the breaking condition
     if (temp1 -> power == temp2 -> power) {
          //insert((temp1 -> coeff) + (temp2 -> coeff), temp1 -> power)
          temp -> coeff = (temp1 -> coeff) - (temp2 -> coeff);
          temp -> power = temp1 -> power; 
          temp2 = temp2 ->next;
          temp1 = temp1 ->next;
          printf("1..\n");
     }
     else if ((temp1 -> power > temp2 -> power)) {
          temp -> power = temp2 ->power;
          temp -> coeff = temp2 -> coeff;
          temp1 = temp1 ->next;
          printf("2..\n");
     }
     else if ((temp1 -> power < temp2 -> power)) {
          temp -> power = temp1 ->power;
          temp -> coeff = temp1 -> coeff;
          temp2 = temp2 ->next;
          printf("3..\n");
     }
     temp ->next = NULL;
}
void display() {
     printf("the resultant polynomial after addition is :\n\n");
     for (temp = start; temp -> next != NULL; temp = temp ->next) {
          printf("%d %d\n",temp->coeff, temp->power);
     }
     printf("%d %d",temp->coeff, temp->power);
} 
