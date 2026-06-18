package Array4;
import java.util.*;

public class LargestSubarr {
    public static void main(String [] args){
        //this is better for +ve numbers and optimal for +ve and -ve are there in this 

        // int [] arr = {1,2,3,1,1,1,1,3,3};
        // int n = arr.length;
        // int k = 3;
        // int len = 0;

        // HashMap<Integer,Integer> mpp = new HashMap<>();
        // int sum = 0;

        // for(int i = 0; i < n ;i++){
        //     sum += arr[i];

        //     if(sum == k){
        //         len = i + 1;
        //     }

        //     int rem = sum - k;
        //     if(mpp.containsKey(rem)){
        //         len = Math.max(len,i - mpp.get(i));
        //     }

        //     if(!mpp.containsKey(rem)){
        //         mpp.put(sum,i);
        //     }
        // }
        // System.out.println("The max length is:"+len);


        //optimal for +ve two pointer approach

        int [] arr = {1,2,3,1,1,1,1,3,3};
        int n = arr.length;
        int k = 3;
        int len = 0;

        int left = 0;
        int right = 0;
        int sum = 0;

        while(right < n ){
            sum += arr[right];

            while(sum > k){
                sum -= arr[left];
                left++;
            }
            if(sum == k){
                len = Math.max(len,right-left+1);
            }
            right++;
        }
        System.out.println(len);
    }
}
