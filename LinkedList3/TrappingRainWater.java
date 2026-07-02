package LinkedList3;

public class TrappingRainWater {

    public static int trap(int[] height) {
        int n = height.length;
        int ans = 0;

        int lmax = 0;
        int rmax = 0;
        int l = 0;
        int r = n - 1;

        while (l < r) {
            lmax = Math.max(lmax, height[l]);
            rmax = Math.max(rmax, height[r]);

            if (lmax < rmax) {
                ans += lmax - height[l];
                l++;
            } else {
                ans += rmax - height[r];
                r--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] height = {4, 2, 0, 3, 2, 5};
        System.out.println(trap(height)); // 9
    }
}