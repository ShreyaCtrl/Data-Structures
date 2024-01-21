// print the total number of occurrences of a given item in the linked list
#include <stdio.h>
#include <stdlib.h>
struct node {
	int data;
	struct node *next;
};
struct node *start, *temp;
int x = 0;
int main() {
	int n;
	if (x == 0) create();
	printf("enter the element for counting occurances : ");
	scanf("%d", &n);
	printf("the number of occurances of %d is %d\n", n, count(n));
}
int count(int n) {
	int i = 0;
	for (temp = start; temp != NULL; temp = temp -> next) {
		if (temp -> data == n) i++;
	}
	return i;
}
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

