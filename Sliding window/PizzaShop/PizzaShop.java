import java.util.*;
//public class PizzaShop {
//    public static void main(String[] arg) {
//        int n, size;
//        Scanner sc = new Scanner(System.in);
//        Deque<Integer> meatOrders = new ArrayDeque<>();
//        List<Integer> result = new ArrayList<>();
//        n = sc.nextInt();
//        size = sc.nextInt();
//        int[] orderPlaced = new int[n+2];
//        for (int i = 0; i < n; i++) {
//            orderPlaced[i] = sc.nextInt();
//        }
//        for (int i = 0; i < size; i++) {
////            System.out.println(0);
////            System.out.println(' '+size);
//            if (orderPlaced[i] < 0) {
//                meatOrders.addLast(orderPlaced[i]);
//            }
//        }
//        if (meatOrders.isEmpty()) {
//            result.add(-1);
//        } else {
//            result.add(meatOrders.getFirst());
//        }
//        for (int i = 1; i < orderPlaced.length; i++) {
////            System.out.println(i);
//            if (!meatOrders.isEmpty()) {
//                if ((i < size) && (meatOrders.getFirst() == orderPlaced[i-1])) {
//                    meatOrders.removeFirst();
//                }
////                if ((i >= size) && (meatOrders.getFirst() == orderPlaced[i-size])) {
////                    meatOrders.removeFirst();
////                }
//            }
//            if ((orderPlaced[i] < 0) && (i >= size)) {
//                meatOrders.addLast(orderPlaced[i]);
//            }
//            if (meatOrders.isEmpty()) {
//                result.add(-1);
//            } else {
//                result.add(meatOrders.getFirst());
//            }
//        }
//        for (int i = 0; i < result.size()-size; i++) {
////            System.out.print(orderPlaced[i]+' '+orderPlaced[i+1]+' '+orderPlaced[i+2]+" : ");
//            System.out.println(result.get(i));
//        }
//    }
//}
public class PizzaShop {
    public static void main(String[] arg) {
        int n, size;
        Scanner sc = new Scanner(System.in);
        Deque<Integer> meatOrders = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        n = sc.nextInt();
        size = sc.nextInt();
        int[] orderPlaced = new int[n+2];
        for (int i = 0; i < n; i++) {
            orderPlaced[i] = sc.nextInt();
        }
        for (int i = 0; i < size; i++) {
            if (orderPlaced[i] < 0) {
                meatOrders.addLast(orderPlaced[i]);
            }
        }
        if (meatOrders.isEmpty()) {
            result.add(0, -1);
        } else {
            result.add(0, meatOrders.peekFirst());
        }
        for (int i =size; i < orderPlaced.length; i++) {
            if ((!meatOrders.isEmpty()) && (meatOrders.peekFirst() == orderPlaced[i-size])) {
                meatOrders.removeFirst();
            }
            if (orderPlaced[i] < 0) {
                meatOrders.addLast(orderPlaced[i]);
            }
            if (meatOrders.isEmpty()) {
                result.add(i-size+1, -1);
            } else {
                result.add(i-size+1, meatOrders.peekFirst());
            }
            System.out.println(meatOrders);
        }
        System.out.println(result);
    }
}