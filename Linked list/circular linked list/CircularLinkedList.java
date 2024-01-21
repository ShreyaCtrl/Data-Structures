import java.util.Scanner;

class Node {
    int data;
    Node next;
}

public class CircularLinkedList {
    static Node start, temp;
    static int x = 0;

    public static void main(String[] args) {
        char ch;
        int i;
        if (x == 0)
            create();
        do {
            System.out.println("\nEnter the input operation of your choice\n");
            System.out.println("1. Display\n2. Count\n3. Insert\n4. Delete\n5. Search\n6. Quit operation\n");
            Scanner scanner = new Scanner(System.in);
            i = scanner.nextInt();
            switch (i) {
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
                    System.out.println("Enter a valid input\n");
                    break;
            }
            break;
        } while (true);
    }

    static void input(int i) {
        int j;
        System.out.println("Enter type of insertion or deletion\n");
        System.out.println("1. Beginning\n2. End\n3. Position\n4. Insert- before element Delete- element\n5. Insert - after element\n");
        Scanner scanner = new Scanner(System.in);
        j = scanner.nextInt();
        switch (j) {
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
                System.out.println("Enter a valid input\n");
                input(i);
        }
    }

    static void create() {
        int i, n;
        temp = start = new Node();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of inputs : ");
        n = scanner.nextInt();
        for (i = 0; i < n; i++) {
            System.out.println("Enter the number to be appended in the list :");
            temp.data = scanner.nextInt();
            if (i == n - 1)
                temp.next = start;
            else {
                temp.next = new Node();
                temp = temp.next;
            }
        }
        x++;
    }

    static void display() {
        if (start == null)
            System.out.println("The list is still empty\n");
        else {
            System.out.println("The elements in the linked list are :-\n");
            for (temp = start; temp.next != start; temp = temp.next) {
                System.out.println(temp.data);
            }
            System.out.println(temp.data + "\n");
        }
    }

    static void count() {
        int i = 0;
        if (start == null)
            System.out.println("The list is still empty\n");
        else {
            for (temp = start; temp.next != start; temp = temp.next) {
                i++;
            }
            System.out.println("The count of the number of elements in linked list is " + (i + 1) + "\n");
        }
    }

    static void ins_begin() {
        Node newnode = new Node();
        if (newnode == null)
            System.out.println("Insufficient memory to add element in list\n");
        else {
            System.out.println("Enter the element to be inserted at the beginning : ");
            Scanner scanner = new Scanner(System.in);
            newnode.data = scanner.nextInt();
            for (temp = start; temp.next != null; temp = temp.next) ;
            newnode.next = start;
            start = newnode;
            temp.next = start;
            System.out.println("The element has been inserted\n");
        }
    }

    static void ins_end() {
        Node newnode;
        for (temp = start; temp.next != start; temp = temp.next) ;
        newnode = new Node();
        if (newnode == null)
            System.out.println("Insufficient memory to add element in list\n");
        else {
            System.out.println("Enter the element to be inserted at end :");
            Scanner scanner = new Scanner(System.in);
            newnode.data = scanner.nextInt();
            newnode.next = start;
            temp.next = newnode;
            System.out.println("The element has been successfully introduced at end\n");
        }
    }

    static void ins_pos() {
        int i, n;
        Node newnode;
        newnode = new Node();
        if (newnode == null)
            System.out.println("Insufficient memory to add element in list\n");
        else {
            System.out.println("Enter the position at which we have to add\n");
            Scanner scanner = new Scanner(System.in);
            n = scanner.nextInt();
            for (i = 1, temp = start; temp.next != start; temp = temp.next) i++;
            if (n >= i) System.out.println("Invalid position to add\n");
            else {
                System.out.println("Enter the element to be inserted : ");
                newnode.data = scanner.nextInt();
                for (i = 1, temp = start; i < n - 1; temp = temp.next, i++) ;
                newnode.next = temp.next;
                temp.next = newnode;
                System.out.println("The element has been inserted at the position\n");
            }
        }
    }

    static void ins_bef() {
        int d;
        Node newnode;
        newnode = new Node();
        if (newnode == null)
            System.out.println("Insufficient memory to add element in list\n");
        else {
            System.out.println("New element to be inserted before :");
            Scanner scanner = new Scanner(System.in);
            d = scanner.nextInt();
            System.out.println("Enter the element to be inserted :");
            newnode.data = scanner.nextInt();
            for (temp = start; temp.next.data != d; temp = temp.next) ;
            newnode.next = temp.next;
            temp.next = newnode;
            System.out.println("The element has been inserted\n");
        }
    }

    static void ins_aft() {
        int d;
        Node newnode;
        newnode = new Node();
            if (newnode == null)
                System.out.println("Insufficient memory to add element in the list\n");
            else {
                System.out.println("New element to be inserted after :");
                Scanner scanner = new Scanner(System.in);
                d = scanner.nextInt();
                System.out.println("Enter the element to be inserted :");
                newnode.data = scanner.nextInt();
                for (temp = start; temp.data != d; temp = temp.next) ;
                newnode.next = temp.next;
                temp.next = newnode;
                System.out.println("The element has been inserted\n");
            }
        }

        static void del_begin() {
        if (start == null)
            System.out.println("List is still empty\nNothing to delete\n");
        start = start.next;
        System.out.println("The beginning element has been deleted\n");
    }

    static void del_end() {
        if (start == null)
            System.out.println("List is still empty\nNothing to add in the list\n");
        else {
            for (temp = start; temp.next.next != start; temp = temp.next) ;
            temp.next = null;
            System.out.println("The ending element has been deleted\n");
        }
    }

    static void del_pos() {
        int n;
        if (start == null)
            System.out.println("The list is still empty\n");
        else {
            int i = 1;
            System.out.println("Enter the position to be deleted :");
            Scanner scanner = new Scanner(System.in);
            n = scanner.nextInt();
            for (temp = start; i != n - 1; temp = temp.next, i++) ;
            temp.next = temp.next.next;
            System.out.println("The element at " + n + " has been deleted\n");
        }
    }

    static void del_element() {
        if (start == null)
            System.out.println("The list is still empty\n");
        else {
            int d;
            System.out.println("Enter the element to be deleted :");
            Scanner scanner = new Scanner(System.in);
            d = scanner.nextInt();
            for (temp = start; temp.next.data != d; temp = temp.next) ;
            temp.next = temp.next.next;
            System.out.println("The element has been successfully deleted\n");
        }
    }

    static void search() {
        int d, i = 1;
        if (start == null)
            System.out.println("The list is still empty\n");
        else {
            System.out.println("Enter the element to be searched :");
            Scanner scanner = new Scanner(System.in);
            d = scanner.nextInt();
            for (temp = start; temp.data != d; temp = temp.next, i++) ;
            System.out.println("The element is found at position " + i + "\n");
        }
    }
}
