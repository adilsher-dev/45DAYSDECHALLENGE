
package DP.HouseRobber2;
import java.util.*;
public class Space{

    public static int solve(int index,int [] nums,int [] dp){
        if(index == 0){
            return nums[0];
        }

        if(index < 0){
            return 0;
        }
        int n = nums.length;

        int prev2 = 0;
        int prev1 = 0;

        for(int i = 0;i < n - 1;i++){

        int pick = nums[i];
        if(i > 1){
            pick+= prev2;
        }
        int nonPick = prev1;

        int curr1 = Math.max(pick,nonPick);

        prev2 = prev1;
        prev1 = curr1;
        }

        int prev4 = 0;
        int prev3 = 0;

        for(int i = 1 ; i <n;i++){
            int pick = nums[i];
            if(i > 1){
                pick += prev4;
            }
            int nonPick = prev3;

            int curr2 = Math.max(pick,nonPick);

            prev4 = prev3;
            prev3 = curr2;

        }

        return Math.max(prev1,prev3);
    }
    public static void main(String [] args){
        int [] nums = {2,7,9,3,1};
        int n = nums.length - 1;
        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);

        System.out.println(solve(n,nums,dp));
    }
}
