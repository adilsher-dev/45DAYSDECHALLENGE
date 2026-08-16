package DP.HouseRobber;

public class Recursion {

    public static int solve(int index,int [] nums){
        if(index == 0){
            return nums[0];
        }

        if(index < 0){
            return 0;
        }

        int pick = nums[index] + solve(index - 2,nums);
        int nonPick = solve(index-1,nums);


        return Math.max(pick,nonPick);




    }
    public static void main(String [] args){
        int [] nums = {2,7,9,3,1};
        int n = nums.length - 1;

        System.out.println(solve(n,nums));
    }
    
}
