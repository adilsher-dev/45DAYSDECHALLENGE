package Array4;
import java.util.*;

public class TwoSum {
    public static void main(String[] args){
        int [] nums = {12, 5, 8, 19, 3, 14, 7, 1, 25, 10, 6, 18, 4, 9, 15};
        int target = 43;

        HashMap<Integer,Integer> mpp = new HashMap<>();

        for(int i = 0 ; i < nums.length;i++){
            int complement = target - nums[i];

            if(mpp.containsKey(complement)){
                System.out.println("");
            }
            else{
                mpp.put(nums[i],i);
            }
        }
    }
}