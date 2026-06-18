package BinarySearch;

public class SingleElement {
    public static void main(String [] args){
        int [] nums = {1,1,2,3,3,4,4,8,8};
        int n = nums.length;
        int low = 1;
        int high = n - 2;

        if(n == 1){
            System.out.println(nums[0]);

        }
        if(nums[0] != nums[1]){
            System.out.println(nums[0]);
        }
        else if(nums[n-1] != nums[n-2]){
            System.out.println(nums[n-1]);
        }

        while( low <= high){
            int mid = low + (high - low)/2;

            if(nums[mid] != nums[mid+1] && nums[mid] != nums[mid-1]){
                System.out.println(nums[mid]);
            }
            
            if((mid % 2 == 0 && nums[mid] == nums[mid-1]) || (mid % 2 == 1 && nums[mid] == nums[mid+1])){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
    }
}