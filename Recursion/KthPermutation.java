package Recursion;

import java.util.*;

public class KthPermutation {

    public static String getPermutation(int n, int k) {

        List<Integer> numbers = new ArrayList<>();
        int fact = 1;

        // Calculate (n-1)! and store numbers 1 to n
        for (int i = 1; i < n; i++) {
            fact *= i;
            numbers.add(i);
        }
        numbers.add(n);

        // Convert k to 0-based indexing
        k--;

        StringBuilder ans = new StringBuilder();

        while (true) {

            ans.append(numbers.get(k / fact));
            numbers.remove(k / fact);

            if (numbers.size() == 0) {
                break;
            }

            k = k % fact;
            fact = fact / numbers.size();
        }

        return ans.toString();
    }

    public static void main(String[] args) {

        int n = 4;
        int k = 17;

        System.out.println("K-th Permutation: " + getPermutation(n, k));
    }
}