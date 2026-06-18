package Recursion;
import java.util.*;

public class Combination {

    public static void findCombination(int idx, int[] arr, int target,
                                       List<List<Integer>> ans,
                                       List<Integer> ds) {

        // Base Case
        if (idx == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        // Pick the element
        if (arr[idx] <= target) {
            ds.add(arr[idx]);
            findCombination(idx, arr, target - arr[idx], ans, ds);

            // Backtrack
            ds.remove(ds.size() - 1);
        }

        // Not Pick the element
        findCombination(idx + 1, arr, target, ans, ds);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        findCombination(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    public static void main(String[] args) {

        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> result = combinationSum(candidates, target);

        System.out.println(result);
    }
}