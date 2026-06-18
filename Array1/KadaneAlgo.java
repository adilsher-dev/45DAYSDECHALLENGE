public class KadaneAlgo {
    //2 June...
    public static void main(String[] args){
        int [] nums = {-2,1,-3,4,-1,2,1,-5,4};

        int currSum = 0 ;
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < n;i++){
            currSum += nums[i];

            if(currSum > maxSum){
                maxSum = currSum;
            }

            if(currSum < 0){
                currSum = 0;
            }
        }
        System.out.println("The max sum is:"+maxSum);
    }
}
