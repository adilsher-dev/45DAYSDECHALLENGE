
import java.util.*;

public class Merge2 {

    public static void swap(int[] nums1, int i, int[] nums2, int j) {
        int temp = nums1[i];
        nums1[i] = nums2[j];
        nums2[j] = temp;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {0, 2, 6, 8, 9};

        int n = nums1.length;
        int m = nums2.length;

        int high1 = n - 1;
        int low2 = 0;

        while (high1 >= 0 && low2 < m) {

            if (nums1[high1] > nums2[low2]) {
                swap(nums1, high1, nums2, low2);
                high1--;
                low2++;
            } else {
                break;
            }
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        System.out.println("Array 1:");
        for (int x : nums1) {
            System.out.print(x + " ");
        }

        System.out.println();

        System.out.println("Array 2:");
        for (int x : nums2) {
            System.out.print(x + " ");
        }
    }
}