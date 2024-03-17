import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class RemoveNth {
    public static void main(String[] arg) {
        int n;
        ListNode start, head;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements : ");
        n = sc.nextInt();
        System.out.print("Enter data: ");
        start = new ListNode(sc.nextInt(), new ListNode());
        head = start.next;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter data: ");
            head.val = sc.nextInt();
            head.next = new ListNode();
            head = head.next;
        }
        removeNthFromEnd(start, sc.nextInt());
        for (head = start; head.next != null; head = head.next) {
            System.out.print(head.val+' ');
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
////        int length = 0;
//        Deque<ListNode> slidingWindow = new ArrayDeque<ListNode>();
//        ListNode ptr = head;
//        for (int i = 0; i < n; i++) {
//            if (i == 1) {
//                ptr = head;
//            }
//            slidingWindow.addLast(ptr);
//            ptr = ptr.next;
////            length++;
//        }
////        ListNode prev = head;
//        for (ptr = slidingWindow.peekLast(); ptr.next != null; ptr = ptr.next) {
////            prev = prev.next;
//            slidingWindow.removeFirst();
//            slidingWindow.addLast(ptr);
////            length++;
//        }
//        ptr = slidingWindow.peekFirst();
//        ptr.next = ptr.next.next;
//        return head;
        // Check for invalid input
        if (head == null || n <= 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        // Move fast pointer ahead by n+1 steps
        for (int i = 0; i <= n; i++) {
            if (fast == null) {
                return null; // Invalid scenario
            }
            fast = fast.next;
        }
        // Move both pointers simultaneously until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // Skip the nth node from the end
        slow.next = slow.next.next;
        return dummy.next;
    }
}
