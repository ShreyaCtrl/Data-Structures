#include <stdio.h>
#define size 10
#define c1 1
#define c2 3
int h[size] = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
int key(int data, int i) {
     // multiplication method 
     int key = data % size + c1*i + c2*i*i;
     return key;
}
int insert(int index, int data, int i) {
     if (h[index] == -1) {
          h[index] = data;
          return index;
     }
     else if (h[index] != -1) {
          insert(key(key(data, (i+1)%size), 0), data, (i+1)%size);
     }
     else {
          printf("the hash table is full\n\n");
     }
}
int search(int index, int data, int i) {
     if (h[index] == data) {
          return index;
     }
     else if (key(key(data, (i+1)%size), 0) == key(data, 0)) {
          // looping condition is also sufficient for quadratic probing beacause we use mod function
          printf("the data is not found\n\n");
          return -1;
     }
     else if (h[index] != data) {
          search(key(key(data, (i+1)%size), 0), data, (i+1)%size);
     }
}
int delete (int data) {
     int index = search(key(data, 0), data, 0);
     if (index == -1) {
          return -1;
     }
     else {
          h[index] = -1;
          return index;
     }
}
void display() {
     for (int i = 0; i < size; i++) {
          printf("key = %d --> data = %d\n", i, h[i]);
     }
}
void main() {
     int i, data;
     do {
          printf("1. Insert\n2. Delete\n3. Search\n4. Display\n5. Exit\n\n");
          printf("enter your choice : ");
          scanf("%d", &i);
          switch (i) {
               case 1:
                    printf("enter the value : ");
                    scanf("%d", &data);
                    printf("the data %d is inserted at %d\n\n", data, insert(key(data, 0), data, 0), key(data, 0));
                    break;
               case 2:
                    printf("enter the value : ");
                    scanf("%d", &data);
                    if (delete(data) != -1)
                         printf("data %d present at %d deleted\n\n", data, delete(data));
                    else 
                         printf("data is not found in hash table\n\n");
                    break;
               case 3:
                    printf("enter the value to search : ");
                    scanf("%d", &data);
                    if (search(key(data, 0), data, 0) != -1)
                         printf("data %d found at %d\n\n", data, search(key(data, 0), data, 0));
                    break;
               case 4:
                    printf("the elements in the hash function are :- \n");
                    display();
                    break;
               case 5:
                    break;
          }
     }
     while (i != 5);
}