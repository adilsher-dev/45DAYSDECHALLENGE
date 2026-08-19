
package DP.NinjaProblem;

import java.util.*;

public class Space {

    public static int solve(int[][] points, int[] prev) {

        int n = points.length;

        // Base case: Day 0

        prev[0] = Math.max(points[0][1], points[0][2]);

        prev[1] = Math.max(points[0][0], points[0][2]);

        prev[2] = Math.max(points[0][0], points[0][1]);

        prev[3] = Math.max(
                points[0][0],
                Math.max(points[0][1], points[0][2])
        );

        // Remaining days
        for (int day = 1; day < n; day++) {

            int[] temp = new int[4];

            for (int last = 0; last < 4; last++) {

                for (int i = 0; i < 3; i++) {

                    if (i != last) {

                        temp[last] = Math.max(
                                temp[last],
                                points[day][i] + prev[i]
                        );
                    }
                }
            }

            // Current day becomes previous day
            prev = temp;
        }

        return prev[3];
    }

    public static void main(String[] args) {

        int[][] points = {
                {10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}
        };

        int[] dp = new int[4];

        Arrays.fill(dp, -1);

        // last = 3 means there is no previous task
        System.out.println(solve(points, dp));
    }
}
//isko smjhna hai
