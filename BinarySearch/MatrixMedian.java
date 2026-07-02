package BinarySearch;

import java.util.*;

public class MatrixMedian {

    public static int median(int[][] matrix, int R, int C) {

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // Find min and max element
        for (int i = 0; i < R; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][C - 1]);
        }

        int required = (R * C) / 2;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int count = 0;

            for (int i = 0; i < R; i++) {
                count += upperBound(matrix[i], mid);
            }

            if (count <= required) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    public static int upperBound(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}
        };

        int R = matrix.length;
        int C = matrix[0].length;

        System.out.println("Median = " + median(matrix, R, C));
    }
}