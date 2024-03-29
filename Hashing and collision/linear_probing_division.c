#include <stdio.h>
#define size 10
int h[size] = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
int key(int data) {
     // division method 
     int key = data % size;
     return key;
}
int insert(int index, int data) {
     if (h[index] == -1) {
          h[index] = data;
          return index;
     }
     else if (h[index] != -1) {
          insert((index+1)%size,data);
     }
     else {
          printf("the hash table is full\n\n");
     }
}
int search(int index, int data) {
     if (h[index] == data) {
          return index;
     }
     // here we need to check for data not found condition just before reaching the 1st check box
     // because reaching there will cause the code to give not found condition 
     // even for those elements where it is present in some box ahead of key index
     else if ((index+1)%size == key(data)) {
          printf("the data is not found\n\n");
          return -1;
     }
     else if (h[index] != data) {
          search((index+1)%size, data);
     }
}
int delete(int index, int data) {
     if (h[index] == data) {
          h[index] = -1;
          return index;
     }
     else if ((index+1)%size == key(data)) {
          return -1;
     }
     else if (h[index] != data) {
          delete((index+1)%size, data);
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
                    printf("the data %d is inserted at %d\n\n", data, insert(key(data), data), key(data));
                    break;
               case 2:
                    printf("enter the value : ");
                    scanf("%d", &data);
                    if (delete(key(data),data) != -1)
                         printf("data %d present at %d deleted\n\n", data, delete(key(data),data));
                    else 
                         printf("data is not found in hash table\n\n");
                    break;
               case 3:
                    printf("enter the value to search : ");
                    scanf("%d", &data);
                    if (search(key(data), data) != -1)
                         printf("data %d found at %d\n\n", data, search(key(data), data));
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