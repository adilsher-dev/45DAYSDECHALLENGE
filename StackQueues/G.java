package StackQueues;
import java.util.Stack;
//Largest histogram in a rectangle...
class Solution {
    public int largestRectangleArea(int[] arr) {

        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {

            while (!s.isEmpty() &&
                   arr[s.peek()] >= arr[i]) {

                int el = s.peek();
                s.pop();

                int nse = i;
                int pse = s.isEmpty() ? -1 : s.peek();

                maxArea = Math.max(
                    maxArea,
                    arr[el] * (nse - pse - 1)
                );
            }

            s.push(i);
        }

        while (!s.isEmpty()) {

            int el = s.peek();
            s.pop();

            int nse = n;
            int pse = s.isEmpty() ? -1 : s.peek();

            maxArea = Math.max(
                maxArea,
                arr[el] * (nse - pse - 1)
            );
        }

        return maxArea;
    }
}