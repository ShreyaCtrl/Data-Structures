#include <stdio.h>
#include <stdlib.h>
struct node {
	int data;
	struct node *left;
	struct node *right;
}*root = NULL;
typedef struct node n;
n *insert(n *tree, int x) {
	n *newnode;
	newnode = (n*)malloc(sizeof(n));
	if (tree == NULL) {
		tree = newnode;
		tree -> data = x;
		tree -> left = tree -> right = NULL;
	}
	else if (tree -> data > x) {
		tree -> left = insert(tree -> left, x);
	}
	else if (tree -> data < x) {
		tree -> right = insert(tree -> right, x);
	}
	return tree;
}
void inorder(n *temp) {
	if (temp == NULL) return;
	else if (temp != NULL) {
		inorder(temp -> left);
		printf("%d->", temp -> data);
		inorder(temp -> right);
	}
}
void preorder(n *temp) {
	if (temp == NULL) return;
	else if (temp != NULL) {
		printf("%d->", temp -> data);
		preorder(temp -> left);
		preorder(temp -> right);
	}
}
void postorder(n *temp) {
	if (temp == NULL) return;
	else if (temp != NULL) {
		postorder(temp -> left);
		postorder(temp -> right);
		printf("%d->", temp -> data);
	}
}
void search(n *tree, int x) {
	if (tree == NULL) {
		printf("element not found \n\n");
	}
	else if (tree -> data > x) {
		printf("1-> ");
		search(tree -> left, x);
	}
	else if (tree -> data < x) {
		printf("0-> ");
		search(tree -> right, x);
	}
	else if (tree -> data == x) {
		printf("element found\n\n");
	}
}
n *smallest (n *tree) {
	if (tree == NULL || tree -> left == NULL) {
		return tree;
	}
	else {
		smallest(tree -> left);
	}
}
n *largest(n *tree) {
	if (tree == NULL || tree -> right == NULL) {
		return tree;
	}
	else {
		largest(tree -> right);
	}
}
struct node *dele(n *tree, int x) {
	if (tree == NULL) {
		printf("element not found\n\n");
	}
	else if (tree -> data > x) {
		tree -> left = dele(tree -> left, x);
	}
	else if (tree -> data < x) {
		tree -> right = dele(tree -> right, x);
	}
	else if (tree -> data == x) {
		n *temp;
		if (tree -> left == NULL && tree -> right == NULL) {
			printf("case 1 : node is leaf node\n\n");
			tree = NULL;
		}
		else if (tree -> left == NULL && tree -> right != NULL) {
			printf("case 2 : node with 1 child\n\n");
			tree -> data = tree -> right -> data;
			tree -> right = NULL;
		}
		else if (tree -> right == NULL && tree -> left != NULL) {
			printf("case 2 : node with 1 child\n\n");
			tree -> data = tree -> left -> data;
			tree -> left = NULL;
		}
		else {
			printf("case 3 : node with 2 child\n\n");
			temp = smallest(tree -> right);
			tree -> data = temp -> data;
			tree -> right = dele(tree -> right, temp -> data);
		}
	}	
	return tree;
}
int height (n *tree) {
	int lh, rh;
	//Since the base condition is considered NULL
	//at the leaf nodes height is 1 which should actually be 0
	//hence subtract 1 while display
	if (tree == NULL) return 0;
	else {
		lh = height(tree -> left);
		rh = height(tree -> right);
		if (lh > rh) {
			return (lh+1);			
		}
		else return (rh+1);
	}
}
int t_nodes(n *tree) {
	if (tree == NULL) return 0;
	else {
		return (t_nodes(tree -> left)+t_nodes(tree -> right)+1);
	}
}
void main() {
	int i, x, y;
	struct node *temp;
	do {
		printf("1.  Insert\n2.  Delete\n3.  Inorder transversal\n4.  Pre order transversal\n5.  Post order transversal\n6.  Search\n");
		printf("7.  Height\n8.  Total nodes\n9.  Maximum value\n10. Minimum value\n11. Quit\n\n");
		printf("enter your choice : ");
		scanf("%d", &i);
		switch(i) {
			case 1:
				printf("enter data to insert : ");
				scanf("%d", &x);
				root = insert(root, x);
				break;
			case 2:
				printf("enter data to delete : ");
				scanf("%d", &x);
				root = dele(root, x);
				break;
			case 3:
				printf("The inorder transversal of the tree is : ");
				inorder(root);
				printf("end\n\n");
				break;
			case 4:
				printf("The pre order transversal of the tree is : ");
				preorder(root);
				printf("end\n\n");
				break;
			case 5:
				printf("The post order transversal of the tree is : ");
				postorder(root);
				printf("end\n\n");
				break;
			case 6:
				printf("enter data to search : ");
				scanf("%d", &x);
				printf("1. in left\n0. in right\n");
				search(root, x);
				break;
			case 7:
				printf("height of the tree is %d\n\n", height(root)-1);
				break;
			case 8:
				printf("total nodes in the tree are %d\n\n", t_nodes(root));
				break;
			case 9:
				temp = largest(root);
				printf("the largest element is %d\n\n", temp -> data);
				break;
			case 10:
				temp = smallest(root);
				printf("the smallest element is %d\n\n", temp -> data);
				break;
//			case 11:
//				printf("enter value of x and y : ");
//				scanf("%d %d", &x, &y);
//				temp = common(root, x, y);
//				printf("common ancestor of highest level is %d", temp -> data);
			case 11: 
				break;
			default:
				printf("enter a valid input!!!");		
		}
	}
	while(i != 11);
}
