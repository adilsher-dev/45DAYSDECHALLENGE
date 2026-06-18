package Recursion;

import java.util.*;

public class CombinationSum2 {

    private void findCombinations(int ind, int[] arr, int target,
                                  List<List<Integer>> ans,
                                  List<Integer> ds) {

        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < arr.length; i++) {

            // Skip duplicates
            if (i > ind && arr[i] == arr[i - 1]) {
                continue;
            }

            // No need to proceed further
            if (arr[i] > target) {
                break;
            }

            ds.add(arr[i]);

            findCombinations(i + 1, arr, target - arr[i], ans, ds);

            // Backtrack
            ds.remove(ds.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(candidates);

        findCombinations(0, candidates, target, ans, new ArrayList<>());

        return ans;
    }

    public static void main(String[] args) {

        CombinationSum2 obj = new CombinationSum2();

        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        List<List<Integer>> result = obj.combinationSum2(candidates, target);

        System.out.println(result);
    }
}