import java.util.Arrays;

public class Sample2 {
//    public static void main(String[] args) {
//        int heroHealth1=3, heroes1=4, villans1=4;
//        int[] villanHealth1 = {3, 1, 3, 3};
//        System.out.println(Arrays.toString(villanHealth1)+villans1);
//        System.out.println(heroHealth1+" "+heroes1);
//        System.out.println(battle(villanHealth1,villans1,heroHealth1,heroes1));
////        System.out.println(minVillans(heroHealth1,heroes1,villans1,villanHealth1));
//        System.out.println("________________________________________________");
//
//        int heroHealth2=3, heroes2=3, villans2=5;
//        int[] villanHealth2 = {1, 2, 3, 1, 1};
//        System.out.println(Arrays.toString(villanHealth2)+villans2);
//        System.out.println(heroHealth2+" "+heroes2);
//        System.out.println(battle(villanHealth2,villans2,heroHealth2,heroes2));
////        System.out.println(minVillans(heroHealth2,heroes2,villans2,villanHealth2));
//        System.out.println("________________________________________________");
//
//        int heroHealth3=4, heroes3=1, villans3=5;
//        int[] villanHealth3 = {1, 2, 3, 1, 3};
//        System.out.println(Arrays.toString(villanHealth3)+villans3);
//        System.out.println(heroHealth3+" "+heroes3);
//        System.out.println(battle(villanHealth3,villans3,heroHealth3,heroes3));
////        System.out.println(minVillans(heroHealth2,heroes2,villans2,villanHealth2));
//        System.out.println("________________________________________________");
//    }

    public static void main(String[] args) {
        // Test cases from the problem statement
        int heroHealth1 = 3, heroes1 = 4, villains1 = 4;
        int[] villainHealth1 = {3, 1, 3, 3};
        System.out.println("Test Case 1:");
        System.out.println("Expected Output: 0");
        System.out.println("Actual Output: " + battle(villainHealth1, villains1, heroHealth1, heroes1));
        System.out.println("________________________________________________");

        int heroHealth2 = 3, heroes2 = 3, villains2 = 5;
        int[] villainHealth2 = {1, 2, 3, 1, 1};
        System.out.println("Test Case 2:");
        System.out.println("Expected Output: 0");
        System.out.println("Actual Output: " + battle(villainHealth2, villains2, heroHealth2, heroes2));
        System.out.println("________________________________________________");

        int heroHealth3 = 4, heroes3 = 1, villains3 = 5;
        int[] villainHealth3 = {1, 2, 3, 1, 3};
        System.out.println("Test Case 3:");
        System.out.println("Expected Output: 3");
        System.out.println("Actual Output: " + battle(villainHealth3, villains3, heroHealth3, heroes3));
        System.out.println("________________________________________________");

        // Additional Test Cases
        int heroHealth4 = 5, heroes4 = 2, villains4 = 5;
        int[] villainHealth4 = {1, 2, 3, 4, 5};
        System.out.println("Additional Test Case 1:");
        System.out.println("Expected Output: 2");
        System.out.println("Actual Output: " + battle(villainHealth4, villains4, heroHealth4, heroes4));
        System.out.println("________________________________________________");

        int heroHealth5 = 2, heroes5 = 2, villains5 = 4;
        int[] villainHealth5 = {2, 3, 1, 5};
        System.out.println("Additional Test Case 2:");
        System.out.println("Expected Output: 0");
        System.out.println("Actual Output: " + battle(villainHealth5, villains5, heroHealth5, heroes5));
        System.out.println("________________________________________________");

        int heroHealth6 = 4, heroes6 = 3, villains6 = 7;
        int[] villainHealth6 = {4, 2, 3, 1, 6, 5, 4};
        System.out.println("Additional Test Case 3:");
        System.out.println("Expected Output: 4");
        System.out.println("Actual Output: " + battle(villainHealth6, villains6, heroHealth6, heroes6));
        System.out.println("________________________________________________");
    }


    static int battle(int[] v, int villans, int heroHealth, int hero) {
        int tempH = heroHealth;
        int vi= 0, hi= 0;
//        Arrays.sort(v);
        while ((hi < hero) && (vi < villans)) {
            if (tempH > v[vi]) {
                System.out.println("Hero:"+hi+" Villan:"+vi+"tempH:"+tempH);
                tempH -= v[vi];
                vi++;
            } else if (tempH < v[vi]) {
                System.out.println("Hero:"+hi+" Villan:"+vi+"tempH:"+tempH);
                tempH = 0;

            } else {
                System.out.println("Hero:"+hi+" Villan:"+vi+"tempH:"+tempH);
                vi++;
                tempH = 0;
            }
            if (tempH == 0) {
                tempH = heroHealth;
                hi++;
            }
        }

        if ((vi == villans)) return 0;
        else if (hi != 0) return (villans-vi);
        else return 0;
    }

//    static int minVillans(int heroHealth, int heroes, int villains, int[] villainHealth) {
//        Arrays.sort(villainHealth); // Sort villains by health ascending
//        int villainsToRemove = 0;
//        int heroIndex = 0;
//
//        while (heroIndex < heroes && villainsToRemove < villains) {
//            if (heroHealth >= villainHealth[villainsToRemove]) {
//                heroHealth -= villainHealth[villainsToRemove];
//                villainsToRemove++;
//            } else {
//                break; // Hero can't defeat the next villain, stop the loop
//            }
//        }
//
//        return Math.max(0, villainsToRemove - heroes); // Minimum villains to remove
//    }

}
