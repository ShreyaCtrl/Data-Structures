#include <stdio.h>
#include <stdlib.h>
struct node {
    int data;
    struct node *next, *prev;
};
typedef struct node dll;
void ins_pos(), ins_begin(), input (int i), display(), count(), ins_end(), create(), ins_bef();
void ins_aft(), del_begin(), del_end(), del_pos(), del_element(), search();
int x = 0;
dll *start, *temp;
void main () {
    int i, n;
    start = (dll*)malloc(sizeof(dll));
    if (x == 0) {
        printf("enter the number of inputs : ");
        scanf("%d", &n);
        create(n);     
    } 
    printf("1. Display\n2. Count\n3. Insert\n4. Delete\n5. Search\n6. Quit operation\n\n");
    printf("\nenter the input operation of your choice : ");
    scanf("%d", &i);
    switch(i) {
        case 1: 
           display();
           break;
        case 2:
            count();
            break;
        case 3:
            input(i);
            break;
        case 4: 
        	input(i);
        	break;
        case 5: 
        	search();
        	break;
        case 6: 
        	break;
        default:
        	printf("enter a valid operatio to perform\n\n");
    }
    
}
void ins_aft() {
	dll *newnode, *p;
	newnode = (dll*)malloc(sizeof(dll));
	if (newnode == NULL) printf("Insufficient memory to add\n\n");
	else {
		int x;
		printf("enter the element to be added : ");
		scanf("%d", &newnode -> data);
		printf("enter after which element to be added : ");
		scanf("%d", &x);
		for (p = start; p -> data != x; p = p -> next);
		newnode -> next = p -> next;
		newnode -> prev = p;
		(p -> next) -> prev = newnode;
		p -> next = newnode;
		printf("the element has been inserted\n\n");
	}
	return main();
}
void ins_bef() {
	dll *newnode;
	newnode = (dll*)malloc(sizeof(dll));
	if (newnode == NULL) printf("Insufficient memory to add\n\n");
	else {
		int x;
		printf("enter the element to be added : ");
		scanf("%d", &newnode -> data);
		printf("enter before which element to be added : ");
		scanf("%d", &x);
		for (temp = start; temp -> data != x; temp = temp -> next);
		newnode -> next = temp;
		newnode -> prev = temp -> prev;
		(temp -> prev) -> next = newnode;
		temp -> prev = newnode;
		printf("the element has been inserted\n\n");
	}
	return main();
}
void ins_pos() {
	dll *newnode;
	int i = 1, n;
	for (temp = start; temp -> next != NULL; temp = temp -> next) i++;
	newnode = (dll*)malloc(sizeof(dll));
	if (newnode == NULL) printf("Insufficient memory to add\n\n");
	else {
		printf("enter position to add at : ");
		scanf("%d", &n);
		if (i <= n) printf("invalid position to add\n\n");
		else {
			printf("enter the element to be added : ");
			scanf("%d", &newnode -> data);
			for (i = 1, temp = start; i != n; temp = temp -> next, i++);
			newnode -> next = temp;
			newnode -> prev = temp -> prev;
			(temp -> prev) -> next = newnode;
			temp -> prev = newnode;
			printf("the element has been inserted\n\n");
		}
		return main();
	}
}
void ins_end() {
	dll *newnode;
	for(temp = start; temp -> next != NULL; temp = temp -> next);
	newnode = (dll*)malloc(sizeof(dll));
	if (newnode == NULL) printf("Insufficient memory to add element\n\n");
	else {
		printf("enter the element to be inserted : ");
		scanf("%d", &newnode -> data);
		newnode -> next = NULL;
		newnode -> prev = temp;
		temp -> next = newnode;
		printf("the element has been inserted\n\n");
	}
	return main();
}
void ins_begin() {
    dll *newnode;
    newnode = (dll *)malloc(sizeof(dll));
    if (newnode == NULL) printf("insufficient memory to add element\n\n");
    else {
        // temp = start;
        printf("enter the element to be inserted : ");
        scanf("%d", &newnode -> data);
        newnode -> next = start;
        newnode -> prev = NULL;
        start -> prev = newnode;
        start = newnode;
        printf("the element has been inserted\n\n");
    }
    return main();
}
void create (int n) {
    int i;
    dll *newnode;
    for (i = 0; i < n; i++) {
        newnode = (dll *)malloc(sizeof(dll));
        printf("enter the data : ");
        scanf("%d", &newnode -> data);
        if (i == 0) {
            newnode -> next = NULL;
            newnode -> prev = NULL;
            // temp over here is start of the node
            start = newnode;
            temp = newnode;
        }
        else {
            newnode -> next = NULL;
            newnode -> prev = temp;
            temp -> next = newnode;
            temp = newnode; 
        }
    }
    x++;
}
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
    return main();
}
void count() {
    int i = 0;
    if (start == NULL) printf("data underflow\n\n");
    else {
    	for (temp = start; temp -> next != NULL; temp = temp -> next) i++;
    	printf("The number of elements in the list are %d\n\n", i+1);
	}
    return main();
}
void input (int i) {
     int j;
     printf("1. Beginning\n2. End\n3. Position\n4. Insert- before element Delete- element\n5. Insert - after element\n\n");
     printf("enter type of insertion or deletion : ");
     scanf("%d", &j);
     switch(j) {
          case 1:
               if (i == 3) ins_begin();
               if (i == 4) del_begin();
               break;
          case 2:
               if (i == 3) ins_end();
               if (i == 4) del_end();
               break;
          case 3:
               if (i == 3) ins_pos();
               if (i == 4) del_pos();
               break;
          case 4:
               if (i == 3) ins_bef();
               if (i == 4) del_element();
               break;
          case 5:
               if (i == 3) ins_aft();
               break;
          default:
               printf("enter a valid input\n\n");
               input(i);
     }
}
void del_begin() {
	if(start == NULL) printf("data underflow\n\n");
	else {
		start = start -> next;
		printf("the element has been deleted\n\n");
	}
	return main();
}
void del_end() {
	if (start == NULL) printf("data underflow\n\n");
	else {
		for(temp = start; (temp -> next) -> next != NULL; temp = temp -> next);
		(temp -> next) -> prev = NULL;
		temp -> next = NULL;
		printf("the element has been deleted\n\n");
	}
	return main();
}
void del_pos() {
	int i = 1, n;
	if (start == NULL) printf("data underflow\n\n");
	else {
		for (temp = start; temp -> next != NULL; temp = temp -> next) i++;
		printf("Enter the position to delete : ");
		scanf("%d", &n);
		if (n >= i) printf("invalid position to delete\n\n");
		else {
			for (i = 1, temp = start; i != n; temp = temp -> next, i++);
			(temp -> prev) -> next = temp -> next;
			(temp -> next) -> prev = temp -> prev;
			printf("the element has been deleted\n\n");
		}
		return main();
	}
}
void del_element() {
	if (start == NULL) printf("data underflow\n\n");
	else {
		int x;
		printf("enter the element to be deleted : ");
		scanf("%d", &x);
		for (temp = start; temp -> data != x; temp = temp -> next);
		(temp -> prev) -> next = temp -> next;
		(temp -> next) -> prev = temp -> prev;
		printf("the element has been deleted\n\n");
	}
	return main();
}
void search() {
    int d, i = 1;
    if (start == NULL)
        printf("the list is still empty\n\n");
    else {
        printf("enter the element to be searched :");
        scanf("%d", &d);
        for (temp = start; temp -> data != d; temp = temp -> next, i++);
    	if (temp -> data == d) printf("the element is found at position %d\n\n", i);
     	else printf("element not fornd in the list\n\n");
	}
}
