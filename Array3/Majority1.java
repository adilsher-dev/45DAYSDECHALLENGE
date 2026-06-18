package Array3;

public class Majority1 {
    public static void main(String[] args){
        int [] nums = {2,2,1,1,1,2,2};
        int n = nums.length;

        int count = 0;
        int el = nums[0];

        for(int i = 0; i < n ;i++){
            if(el == nums[i]){
                count++;
            }
            else if(count == 0){
                count = 1;
                el = nums[i];
            }
            else{
                count--;
            }
        }

        count = 0;
        for(int i = 0; i < n ;i++){
            if(el == nums[i]){
                count++;
            }
        }
        if(count > n/2){
            System.out.println("The Majority Element is:"+el);
        }
    } 
}
