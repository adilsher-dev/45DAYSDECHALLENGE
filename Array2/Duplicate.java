import java.util.*;
public class Duplicate {
    public static void main(String[] args){
        //first brute force is sort the array and search until when a[i] == a[i+1] then e = a[i] then return e;

        // int [] nums = {1,3,4,2,2};
        // HashMap<Integer,Integer> mpp = new HashMap<>();

        // for(int num : nums){
        //     if(mpp.containsKey(num)){
        //         System.out.println(num);
        //     }
        //     else{
        //         mpp.put(num,1);
        //     }
        //Optimal soln
        int [] nums = {1,3,4,2,2};

        int slow = nums[0];
        int fast = nums[0];

        while(slow!=fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = nums[0];

        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        System.out.println(slow);
        }
    }

