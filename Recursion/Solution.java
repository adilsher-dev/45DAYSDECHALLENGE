package Recursion;
import java.util.*;

public class Solution {

    public void findSubsets(int ind, int[] nums,
                            List<Integer> ds,
                            List<List<Integer>> ansList) {

        ansList.add(new ArrayList<>(ds));

        for (int i = ind; i < nums.length; i++) {

            // Skip duplicates
            if (i != ind && nums[i] == nums[i - 1]) {
                continue;
            }

            ds.add(nums[i]);
            findSubsets(i + 1, nums, ds, ansList);
            ds.remove(ds.size() - 1); // Backtrack...
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> ansList = new ArrayList<>();

        findSubsets(0, nums, new ArrayList<>(), ansList);

        return ansList;
    }

    public static void main(String[] args) {

        Solution obj = new Solution();

        int[] nums = {1, 2, 2};

        List<List<Integer>> result = obj.subsetsWithDup(nums);

        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}