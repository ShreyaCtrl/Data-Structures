import java.util.*;
public class PizzaShop {
    public static void main(String[] arg) {
        int n, size;
        Scanner sc = new Scanner(System.in);
        Deque<Integer> meatOrders = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        n = sc.nextInt();
        size = sc.nextInt();
        int[] orderPlaced = new int[n];
        for (int i = 0; i < n; i++) {
            orderPlaced[i] = sc.nextInt();
        }
        for (int i = 0; i < size; i++) {
            if (orderPlaced[i] < 0) {
                meatOrders.addLast(orderPlaced[i]);
            }
        }
        if (meatOrders.isEmpty()) {
            result.add(-1);
        } else {
            result.add(meatOrders.getFirst());
        }
        for (int i = 1; i < orderPlaced.length; i++) {
            if (result.contains(orderPlaced[i-size])) {
                meatOrders.removeFirst();
            }
            if (orderPlaced[i] < 0) {
                meatOrders.addFirst(orderPlaced[i]);
            }
            if (meatOrders.isEmpty()) {
                result.add(-1);
            } else {
                result.add(meatOrders.getFirst());
            }
        }
        for (int x :
                result) {
            System.out.println(x);
        }
    }
}
