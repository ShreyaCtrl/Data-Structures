#include <stdio.h>
#include <stdlib.h>
#define size 10
int key(int data) {
     // division method 
     int key = data % size;
     return key;
}
struct node {
     int data;
     struct node *next;
};
struct node *create() {
     struct node *newnode;
     newnode = (struct node*)malloc(sizeof(struct node));
     newnode -> next = NULL;
     return newnode;
}
struct node *h[size];
int insert(int data, int index) {
     struct node *n;
     if (h[index] == NULL) {
          n = create();
          n -> data = data;
          h[index] = n;
     }
     else if (h[index] != NULL) {
          for (n = h[index]; n -> next != NULL; n = n -> next);
          n -> next = create();
          n = n -> next;
          n -> data = data;
     }
     return index;
}
void delete(int data, int index) {
     struct node *n = h[index];
     if (n -> data == data) {
          h[index] = n -> next;
     }
     else if (n -> data != data) {
          for (n = h[index] ; n != NULL; n = n -> next) {
               if (n -> next -> data == data) {
                    n -> next = n -> next -> next;
                    printf("data deleted\n\n");
                    return;
               }
          }
          printf("data not found \n\n");
          return;
     }
}
void display() {
     struct node *n;
     int i;
     for (i = 0; i < size; i++) {
          printf("key = %d --> ", i);
          for (n = h[i]; n != NULL; n = n -> next) {
               printf("data = %d ", n -> data);
          }
          printf("\n");
     }
     printf("\n\n");
}
void main() {
     int i, d;
     do {
          printf("1. Insert\n2. Delete\n3. Search\n4. Display\n5. Exit\n\nenter your choice : ");
          scanf("%d", &i);
          switch(i) {
               case 1:
                    printf("enter the data :");
                    scanf("%d", &d);
                    printf("data %d is inserted at %d\n", d, insert(d, key(d)));
                    break;
               case 2:
                    printf("enter the data to delete : ");
                    scanf("%d", &d);
                    delete(d, key(d));
                    break;
               case 4:
                    printf("the elements in the hash table are : \n");
                    // for (int i = 0; i < size; i++)
                    //      printf("%d ", h[i]);
                    display();
                    break;
          }
     }
     while (i != 5);
}