#include <stdio.h>
//a program that removes all nodes that have duplicate information.
#include <stdlib.h>
struct node {
	int data;
	struct node *next;
};
struct node *temp, *start;
int x;
void create(), display(), dupl_del();
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
    x++;
}
int main() {
	if (x == 0) create();
    display();
	dupl_del();
	display();
}
void dupl_del() {
	int n;
	struct node *ptr;
	ptr = (struct node *)malloc(sizeof(struct node));
	for (temp = start; temp -> next!= NULL; temp = temp -> next) {
		printf("temp = %d\n", temp -> data);
		for (ptr = temp; ptr -> next != NULL; ptr = ptr -> next) {
			if ((ptr -> next) -> data == temp -> data && ptr -> next != NULL) {
				ptr -> next = (ptr -> next) -> next;
			}
            else if (ptr -> next == NULL) break;
		}
	display();
	}
	if ((ptr -> next) -> data == temp -> data && ptr -> next != NULL) {
				ptr -> next = (ptr -> next) -> next;
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
