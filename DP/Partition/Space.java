package DP.Partition;

public class Space{

    public static boolean partition(int [] arr){

        int n = arr.length;
        int sum = 0;

        for(int i = 0; i < n;i++){
            sum += arr[i];
        }

        if(sum % 2 != 0){
            return false;
        }
        int TARGET = sum/2;

        return subset(arr,TARGET);
    }

    public static boolean subset(int [] arr,int k){

        boolean [] prev = new boolean[k+1];
        prev[0] = true;

        if(arr[0] <= k){
            prev[arr[0]]= true;
        }

        for(int i = 1; i < arr.length;i++){
            boolean [] curr = new boolean[k+1];
            curr[0] = true;
            for(int target = 1;target <= k;target++){
                
                boolean notTake = prev[target];
                boolean Take = false;
                if(target >= arr[i]){
                    Take = prev[target-arr[i]];
                }
                curr[target] = Take || notTake;
            }
            prev = curr;
        }

        return prev[k];
      
    }
    public static void main(String[] args){

        int [] arr = {1,5,11,5};
        int n = arr.length;

        boolean result = partition(arr);

        if(result){
            System.out.println("Yes two subsequence exists");
        }
        else{
            System.out.println("No subsequence exists");
        }
    

    }
}