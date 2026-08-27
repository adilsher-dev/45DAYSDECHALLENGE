package DP.Partition;

public class Recursion{

    public static boolean partition(int [] arr){

        int n = arr.length;
        int sum = 0;

        for(int i = 0; i < n;i++){
            sum += arr[i];
        }

        if(sum % 2 != 0){
            return false;
        }

        return subset(arr,n-1,sum/2);
    }

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
            Take = subset(arr,idx-1,target-arr[idx]);
        }

        return Take || notTake;
      
    }
    public static void main(String[] args){

        int [] arr = {1,5,11,5};

        boolean result = partition(arr);

        if(result){
            System.out.println("Yes two subsequence exists");
        }
        else{
            System.out.println("No subsequence exists");
        }
    

    }
}