public class SortColor {
    public static void swap(int [] nums,int i ,int j){
        int temp = i;
        i = j;
        j = temp;
    }


    
    public static void main(String[] args){


        int [] nums = {2,0,2,1,1,0};
        int n = nums.length;

        int low = 0;
        int mid = 0;
        int high = n - 1;

        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums,nums[low],nums[mid]);
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else{
                swap(nums,nums[mid],nums[high]);
            }
        }
    
    }
}
