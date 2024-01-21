#include <stdio.h>
#include <stdlib.h>
//  input an n digit number
// store every single digit in a separate node thereby forming a linked list.
struct node {
	int data;
	struct node *next, *prev;
};
struct node *start, *temp;
void display() {
     //dll *temp;
    if (start == NULL) printf("data underflow\n\n");
    else {
    	printf("The elements in the linked list are : \n");
    	for (temp = start ; temp -> next != NULL; temp = temp -> next) {
        	printf("%d\n", temp -> data);
    	}
  		printf("%d\n\n", temp -> data);
	}
}
void insert(int d, int num) {
	struct node *newnode;
	newnode = (struct node *)malloc(sizeof(struct node));
	//data entering in newnode doesnt require condition
	//while loop in main ensures no unnecessary 0s are added in list
	//condition is requiered to ensure the last element has next address as null
	newnode -> data = d;
	if(temp == start) {
		printf("1");
		start = newnode;
		newnode -> next = NULL;
		newnode -> prev = NULL;
		temp = newnode;
		temp = temp -> next;
	}
	else {
		printf("2");
		newnode -> next = NULL;
		newnode -> prev = temp;
		temp -> next = newnode;
		temp = temp -> next;
	}
//	else if (num == 0) {
//		printf("3");
//		temp -> next = newnode;
//		newnode -> next = NULL;
//		newnode -> prev = temp;
//		temp = temp -> next;
//	}
	//display();
	//return temp->data;
} 
void main() {
	int num;
	printf("enter a number to seperate into digits : ");
	scanf("%d", &num);
	temp = start = (struct node *)malloc(sizeof(struct node));
	while (num != 0) {
		//printf("%d\n", insert(num%10, num/10));
		insert(num%10, num/10);
		num = num / 10;
	}
	display();
}

