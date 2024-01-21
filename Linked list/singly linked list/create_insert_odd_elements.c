//create a linked list from an already given list. 
//The new linked list must contain every alternate element of the existing linked list.
#include <stdio.h>
#include <stdlib.h> 
struct node {
	int data;
	struct node *next;
};
struct node *start, *temp, *start1, *temp1;
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
void display() {
    if (start == NULL)
        printf("the list is still empty\n\n");
    else {
        printf("the elements in the linked list are :-\n");
        for (temp = start1; temp -> next != NULL; temp = temp->next) {
            printf("%d \n", temp -> data);
        }
        // last element printed outside the loop as
        // after incrementation the condition is checked
        // the loop is exited without printing the last element
        printf("%d\n\n", temp->data);
    }
}
void ins_cond() {
	int i;
	for (i = 1, temp = start; temp != NULL; i++, temp = temp -> next) {
		if (i % 2 == 1 && temp == start) {
			temp1 = start1 = (struct node *)malloc(sizeof(struct node));
			temp1 -> data = temp -> data;
			temp1 -> next = (struct node *)malloc(sizeof(struct node));
			temp1 = temp1 -> next;
		}
		else if (i % 2 == 1 && (temp -> next == NULL || (temp -> next) -> next == NULL)) {
			temp1 -> data = temp -> data;
			temp1 -> next = NULL;
		}
		else if (i % 2 == 1){
			temp1 -> data = temp -> data;
			temp1 -> next = (struct node *)malloc(sizeof(struct node));
			temp1 = temp1 -> next;
		}
	}
}
void main() {
	create();
	ins_cond();
	printf("the elements in new linked list are : ");
	display();
}

