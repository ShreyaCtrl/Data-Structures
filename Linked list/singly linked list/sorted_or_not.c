//prints whether the given linked list is sorted (in ascending order) or not.
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
int is_sorted() {
	for (temp = start; temp != NULL; temp = temp -> next) {
        // here if condition should be given first 
        // if not so the > operation will work for the last element denoted by (temp -> data)
        // which doesnt have a next element to check 
		if (temp -> next == NULL) return 1;
		else if (temp -> data > (temp -> next) -> data) return 0;
		else continue;
	}
	return 1;
}
void main() {
	create();
	if (is_sorted() == 0) printf("The linked list is not sorted\n\n");
	else printf("The linked list is sorted\n\n");
}
