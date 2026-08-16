package DP.FrogJump2;

public class Recursion {

    public static int func(int idx,int [] height,int k){
        if(idx == 0){
            return 0;
        }

        int minEnergy = Integer.MAX_VALUE;

        for(int j = 1; j <= k;j++){

            if(idx - j >= 0){
                int jump = func(idx - j,height,k) + Math.abs(height[idx] - height[idx - j]);
                minEnergy = Math.min(minEnergy,jump);
            }
        }
        return minEnergy;
    }
    public static void main(String[] args){
        Recursion r = new  Recursion();
        int [] height = {10,30,40,50,20};
        int k = 3;

        System.out.println(r.func(height.length - 1,height,k));
    }
    
}
