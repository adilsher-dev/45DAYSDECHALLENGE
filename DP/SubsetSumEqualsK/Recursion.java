package DP.SubsetSumEqualsK;

public class Recursion{

    public static boolean subset(int [] arr,int idx,int target){

        if(target == 0){
            return true;
        }
        if(idx == 0){
            return arr[0] == target;
        }

        boolean notTake = subset(arr,idx-1,target);

        boolean Take = false;
        if(target >= arr[idx]){
            notTake = subset(arr,idx-1,target-arr[idx]);
        }

        return notTake || Take;
      
    }
    public static void main(String[] args){

        int [] arr = {1,2,3,4};
        int k = 5;

        boolean result = subset(arr,arr.length-1,k);

        if(result){
            System.out.println("Yes subsequence exists");
        }
        else{
            System.out.println("No subsequence exists");
        }

    }
}