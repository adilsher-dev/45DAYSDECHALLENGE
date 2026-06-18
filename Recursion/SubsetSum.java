
package Recursion;

import java.util.*;

public class SubsetSum {

    void func(int idx, int sum, ArrayList<Integer> arr,
              int N, ArrayList<Integer> sumSubSet) {

        if (idx == N) {
            sumSubSet.add(sum);
            return;
        }

        // Take
        func(idx + 1, sum + arr.get(idx), arr, N, sumSubSet);

        // Not Take
        func(idx + 1, sum, arr, N, sumSubSet);
    }

    public static void main(String[] args) {

        SubsetSum r = new SubsetSum();

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(1);
        arr.add(2);

        int N = arr.size();

        ArrayList<Integer> sumSubSet = new ArrayList<>();

        r.func(0, 0, arr, N, sumSubSet);

        Collections.sort(sumSubSet);

        System.out.println(sumSubSet);
    }
}