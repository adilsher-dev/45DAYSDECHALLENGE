import java.util.*;

public class RepeatAndMissing {
    //better approach

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 5, 3};

        HashMap<Integer, Integer> map = new HashMap<>();

        int repeating = -1;
        int missing = -1;

        // Count frequencies
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Find repeating and missing
        for (int i = 1; i <= arr.length; i++) {

            if (!map.containsKey(i)) {
                missing = i;
            }

            else if (map.get(i) > 1) {
                repeating = i;
            }
        }

        System.out.println("Repeating Number = " + repeating);
        System.out.println("Missing Number = " + missing);
    }
}