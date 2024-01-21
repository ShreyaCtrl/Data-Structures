//merge two sorted linked lists. 
//The resultant list must also be sorted.
#include <stdio.h> 
#include <stdlib.h>
struct node {
	int data;
	struct node *next;
};
struct node *start, *temp;
void create() {
    int i, n;
    // only executed in function as it is not a compiler directive
    // it is a executable statement
    // malloc assigns memory
    temp = start = (struct node *)malloc(sizeof(struct node));
    printf("enter the number of inputs :");
    scanf("%d", &n);
    // creating the linked list
    for (i = 0; i < n; i++) {
        printf("enter the number to be appended in the list :");
        scanf("%d", &(temp->data));
        if (i == n-1)
            temp -> next = NULL;
        else {
            temp -> next = (struct node *)malloc(sizeof(struct node));
            temp = temp -> next;
        }
    }
}
void sort() {
	int n;
	struct node *temp1;
	for (temp = start; temp != NULL; temp = temp -> next) {
		for (temp1 = start; temp1 != NULL; temp1 = temp1 -> next) {
			if (temp -> data < temp1 -> data) {
				n = temp -> data;
				temp -> data = temp1 -> data;
				temp1 -> data = n;
			}
		}
	}
} 
void display() {
    if (start == NULL)
        printf("the list is still empty\n\n");
    else {
        printf("the elements in the linked list are :-\n");
        for (temp = start; temp -> next != NULL; temp = temp->next) {
            printf("%d \n", temp -> data);
        }
        // last element printed outside the loop as
        // after incrementation the condition is checked
        // the loop is exited without printing the last element
        printf("%d\n\n", temp->data);
    }
}
void main() {
	create();
	sort();
	display();
	
}
