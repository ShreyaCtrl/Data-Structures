#include <stdio.h>
#include <stdlib.h>
struct node
{
    int data;
    struct node *next;
};
void ins_pos(), ins_begin(), input (int i), display(), count(), ins_end(), create(), ins_bef();
void ins_aft(), del_begin(), del_end(), del_pos(), del_element(), search();
struct node *start, *temp;
int x = 0;
void main ()
{
    char ch;
    int i;
    if (x == 0) create();
    do
    {
        printf("\nenter the input operation of your choice\n\n");
        printf("1. Display\n2. Count\n3. Insert\n4. Delete\n5. Search\n6. Quit operation\n\n");
        scanf("%d", &i);
        switch(i)
        {
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
               case 6:
                    break;
               default:
                    printf("enter a valid input\n\n");
                    break;
          }
          break;
     }
     while (1);
}
void input (int i)
{
     int j;
     printf("enter type of insertion or deletion\n\n");
     printf("1. Beginning\n2. End\n3. Position\n4. Insert- before element Delete- element\n5. Insert - after element\n\n");
     scanf("%d", &j);
     switch(j)
     {
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
void create()
{
     int i, n;
     // only executed in main as it is not a compiler directive
     // it is a executable statement
     // malloc assigns memory
     temp = start = (struct node *)malloc(sizeof(struct node));
     printf("enter the number of inputs : ");
     scanf("%d", &n);
     // creating the linked list
     for (i = 0; i < n; i++)
     {
          printf("enter the number to be appended in the list :");
          scanf("%d", &(temp->data));
          if (i == n-1)
               temp -> next = start;
          else
          {
               temp -> next = (struct node *)malloc(sizeof(struct node));
               temp = temp -> next;
          }
     }
     x++;
}
void display()
{
     if (start == NULL)
          printf("the list is still empty\n\n");
     else
     {
          printf("the elements in the linked list are :-\n");
          for (temp = start; temp -> next != start; temp = temp->next)
          {
               printf("%d \n", temp -> data);
          }
          // last element printed outside the loop as
          // after incrementation the condition is checked
          // the loop is exited without printing the last element
          printf("%d\n\n", temp->data);
     }
     return main();
}
void count()
{
     int i = 0;
     if (start == NULL)
          printf("the list is still empty\n\n");
     else
     {
          for (temp = start; temp -> next != start; temp = temp->next)
          {
               i++;
          }
          // printed as i+1 as the first element in linked list is counted as 0
          printf("the count of the number of elements in linked list is %d\n\n", i+1);
     }
     return main();
}
void ins_begin()
{
     struct node *newnode;
     newnode = (struct node *)malloc(sizeof(struct node));
     if (newnode == NULL)
          printf("insufficient memory to add element in list\n\n");
     else 
     {
          printf("enter the element to be inserted at beginning : ");
          scanf("%d", &newnode -> data);
          for (temp = start; temp -> next != NULL; temp = temp -> next);
          // start contains the address of the current first element
          // which after addition of newnode in list is the 2nd element
          // hence start contains the address of the new next element
          newnode -> next = start;
          start = newnode;
          temp -> next = start;
          printf("the element has been inserted\n\n");
     }
     return main();
}
void ins_end()
{
     struct node *newnode;
     for (temp = start; temp -> next != start; temp = temp ->next);
     newnode = (struct node *)malloc(sizeof(struct node));
     if (newnode == NULL)
          printf("insufficient memory to add element in list\n\n");
     else
     {
          printf("enter the element to be inserted at end :");
          scanf("%d", &(newnode->data));
          newnode -> next = start;
          temp -> next = newnode;
          printf("the element has been successfully introduced at end\n\n");
     }
     return main();
}
void ins_pos()
{
     int i, n;
     struct node *newnode;
     newnode = (struct node *)malloc(sizeof(struct node));
     if (newnode == NULL)
          printf("insufficient memory to add element in list\n\n");
     else
     {
          printf("enter the position at which we have to add\n");
          scanf("%d", &n);
          for (i = 1, temp = start; temp -> next != start; temp = temp ->next) i++;
          if (n>= i) printf("invalid position to add\n");
          else
          {
               printf("enter the element to be inserted : ");
               scanf("%d", &(newnode -> data));
               // to go forward in the list
               for (i = 1, temp = start; i < n-1; temp = temp ->next, i++);
               // the next of temp contains the address of the next node which is connected to the newnode
               newnode -> next = temp -> next;
               temp -> next = newnode;
               printf("the element has been inserted at the position\n\n");
          }
     }
     return main();
}
void ins_bef()
{
     int d;
     struct node *newnode;
     newnode = (struct node *)malloc(sizeof(struct node));
     if (newnode == NULL)
          printf("insufficient memory to add element in list\n\n");
     else
     {
          printf("new element to be inserted before :");
          scanf("%d", &d);
          printf("enter the element to be inserted :");
          scanf("%d", &(newnode -> data));
          for (temp = start; (temp -> next) -> data != d; temp = temp ->next);
          newnode -> next = temp -> next;
          temp -> next = newnode;
          printf("the element has been inserted\n\n");
     }
     return main();
}
void ins_aft()
{
     int d;
     struct node *newnode;
     newnode = (struct node *)malloc(sizeof(struct node));
     if (newnode == NULL)
          printf("insufficient memory to add element in the list\n");
     else 
     {
          printf("new element to be inserted after :");
          scanf("%d", &d);
          printf("enter the element to be inserted :");
          scanf("%d", &(newnode -> data));
          for (temp = start; temp -> data != d; temp = temp -> next);
          newnode -> next = temp -> next;
          temp -> next = newnode;
          printf("the element has been inserted\n\n");
     }
     // if return main() not written then execution goes back to the calling function 
     return main();
}
void del_begin()
{
     if (start == NULL)
          printf("list is still empty\nnothing to delete\n\n");
     start = start -> next;
     printf("the beginning element has been deleted\n\n");
     return main();
}
void del_end()
{
     if (start == NULL)
          printf("list is still empty\nnothing to add in the list\n");
     else 
     {
          for (temp = start; (temp -> next) -> next != start; temp = temp -> next);
               temp -> next = NULL;
          printf("the ending element has been deleted\n\n");
     }
     return main();
}
void del_pos()
{
     int n;
     if (start == NULL)
          printf("the list is still empty\n\n");
     else 
     {
          int i = 1;
          printf("enter the postion to be deleted :");
          scanf("%d", &n);
          // n-1 as we have to change the next of the element present at n-1 th postion
          // because its next is being deleted
          for ( temp = start; i != n-1; temp = temp -> next, i++);
          temp -> next = (temp -> next) -> next;
          printf("the element at %d has been deleted\n\n", n);
     }
     return main();
}
void del_element()
{
     if (start == NULL)
          printf("the list is still empty\n\n");
     else
     {
          int d;
          printf("enter the element to be deleted :");
          scanf("%d", &d);
          for (temp = start; (temp -> next )-> data != d; temp = temp -> next);
          temp -> next = (temp -> next) -> next;
          printf("the element has been sucessfully deleted\n\n");
     }     
     return main();
}
void search()
{
     int d, i = 1;
     if (start == NULL)
          printf("the list is still empty\n\n");
     else
     {
          printf("enter the element to be searched :");
          scanf("%d", &d);
          for (temp = start; temp -> data != d; temp = temp -> next, i++);
          printf("the element is found at position %d\n\n", i);
     }
}
