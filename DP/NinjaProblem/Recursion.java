package DP.NinjaProblem;
//i==task

public class Recursion {
    
    public static int solve(int day,int last,int [][] points){

        if(day == 0){
            int maxi = 0;
            for(int i = 0 ; i < 3;i++){
                if(i != last){
                   maxi = Math.max(maxi,points[0][i]);
                }
            }
            return maxi;
        }
        int maxi = 0;

        for(int i = 0; i < 3; i++){
            if(i != last){
                int maxPoints = points[day][i] + solve(day-1,i,points);
                maxi =  Math.max(maxi,maxPoints);
            }
        }
        return maxi;
    }
    public static void main(String[]args){
        int[][] points = {
                {10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}
        };

        int n = points.length;
        //int m = points[0].length;

        // last = 3 means there is no previous task
        System.out.println(solve(n - 1, 3, points));
    }
}
