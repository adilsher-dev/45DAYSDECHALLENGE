package Recursion;


import java.util.*;

public class PalindromePartitioning {

    public static void main(String[] args) {

        String s = "aab";

        PalindromePartitioning obj = new PalindromePartitioning();

        List<List<String>> result = obj.partition(s);

        System.out.println(result);
    }

    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();
        List<String> res = new ArrayList<>();

        func(0, s, ans, res);

        return ans;
    }

    private void func(int idx, String s,
                      List<List<String>> ans,
                      List<String> res) {

        if (idx == s.length()) {
            ans.add(new ArrayList<>(res));
            return;
        }

        for (int i = idx; i < s.length(); i++) {

            if (isPalindrome(s, idx, i)) {

                // Take
                res.add(s.substring(idx, i + 1));

                func(i + 1, s, ans, res);

                // Backtrack
                res.remove(res.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {

        while (start <= end) {

            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}