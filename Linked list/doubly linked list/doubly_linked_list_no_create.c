#include <stdio.h>
#include <stdlib.h>
struct node {
	int data;
	struct node *prev, *next;
}*start, *temp;
void display() {
	if (start == NULL) printf("data underflow\n\n");
	else {
		printf("these are the elements in the linked list : ");
		for (temp = start; temp != NULL; temp = temp -> next) {
			printf("%d ", temp -> data);
		}
		printf("\n\n");
	}
}
void count() {
    int i = 0;
    if (start == NULL) printf("data underflow\n\n");
    else {
    	for (temp = start; temp -> next != NULL; temp = temp -> next) i++;
    	printf("The number of elements in the list are %d\n\n", i+1);
	}
}
void ins_begin() {
	struct node *newnode;
	newnode = (struct node*)malloc(sizeof(struct node));
	printf("enter the data : ");
	scanf("%d",&newnode -> data);
	newnode -> prev = NULL;
	if (start == NULL) {
		newnode -> next = NULL;
		start = newnode;
	}
	else {
		newnode -> next = start;
		start = newnode;
	}
}
void ins_end() {
	struct node *newnode;
	newnode = (struct node*)malloc(sizeof(struct node));
	printf("enter the data :");
	scanf("%d", &newnode -> data);
	newnode -> next = NULL;
	if (start == NULL) {
		newnode -> prev = NULL;
		start = newnode;
	}
	else {
		// here for breaking condition we cant write temp != NULL
		// as it breaks when temp = NULL 
		// and we assign NODE to next of temp(NULL)
		for(temp = start; temp -> next != NULL; temp = temp -> next);
		temp -> next = newnode;
		newnode -> prev = temp; 
	}
}
void ins_pos() {
	struct node *newnode;
	int i = 1, n;
	for (temp = start; temp -> next != NULL; temp = temp -> next) i++;
	newnode = (struct node*)malloc(sizeof(struct node));
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
void ins_bef() {
	struct node *newnode;
	newnode = (struct node*)malloc(sizeof(struct node));
	if (newnode == NULL) printf("Insufficient memory to add\n\n");
	else if (start == NULL) 
		printf("data underflow\n\n");
	else {
		int x;
		printf("enter data to add before : ");
		scanf("%d", &x);
		printf("enter the data : ");
		scanf("%d", &newnode -> data);
		for (temp = start; temp -> data != x; temp = temp -> next) {
			if (temp -> next == NULL) {
				printf("data not found to add before\n\n");
				return main();
			}
		}
		newnode -> next = temp;
		newnode -> prev = temp -> prev;
		(temp -> prev) -> next = newnode;
		temp -> prev = newnode;
	}	
}
void ins_aft() {
	struct node *newnode;
	newnode = (struct node*)malloc(sizeof(struct node));
	if (newnode == NULL) printf("insufficient memory to add\n\n");
	else if (start == NULL) printf("data underflow\n\n");
	else {
		int x;
		printf("enter data to add after : ");
		scanf("%d", &x);
		printf("enter the data : ");
		scanf("%d", &newnode -> data);
		for (temp = start; temp -> data != x; temp = temp -> next) {
			if (temp -> next == NULL) {
				printf("data not found to add after\n\n");
				return main();
			}
		}
		newnode -> next = temp -> next;
		newnode -> prev = temp;
		(temp -> next) -> prev = newnode;
		temp -> next = newnode;
	}
}
void del_begin() {
	if (start == NULL) {
		printf("data underflow\n\n");
		return main();
	}
	else {
		start = start -> next;
	}	
}
void del_end() {
	if (start == NULL) {
		printf("data underflow\n\n");
		return main();
	}
	else {
		for (temp = start; temp -> next != NULL; temp = temp -> next);
		(temp -> prev) -> next = NULL;
	}
}
void del_pos() {
	if (start == NULL) {
		printf("data underflow\n\n");
		return main();
	}
	else {
		int i, n;
		printf("enter position to delete : ");
		scanf("%d", &n);
		for (i = 1, temp = start; i < n; i++, temp = temp -> next) {
			if (temp -> next == NULL) {
				printf("invalid position to delete\n\n");
				return main();
			}
		}
		(temp -> prev) -> next = temp -> next;
		(temp -> next) -> prev = temp -> prev;
	}
}
void del_element() {
	if (start == NULL) {
		printf("data underflow\n\n");
		return main();
	}
	else {
		int x;
		printf("enter the element to delete : ");
		scanf("%d", &x);
		for (temp = start; temp -> data != x; temp = temp -> next){
			if (temp -> next == NULL) {
				printf("data not found\n\n");
				return main();
			}
		}
		(temp -> prev) -> next = temp -> next;
		(temp -> next) -> prev = temp -> prev;
	}
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
void search() {
    int d, i = 1;
    if (start == NULL)
        printf("the list is still empty\n\n");
    else {
        printf("enter the element to be searched :");
        scanf("%d", &d);
        for (temp = start; temp -> data != d; temp = temp -> next, i++){
        	if (temp -> next == NULL) {
        		printf("data not found\n\n");
        		return main();
			}
		}
    	printf("the element is found at position %d\n\n", i);
	}
}
void main () {
	// start = temp = NULL;
	int i;
    do {
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
    	if (i == 6)
	    	break;
	}
	while (1);
}