package Array3;

public class Majority2 {
    public static void main(String [] args){
        int [] nums = {1,1,1,3,3,2,2,2};
        int n = nums.length;
        int count1 = 0;
        int count2 = 0;
        int el1 = 0;
        int el2 = 0;

        for(int num : nums){
            if(num == el1){
                count1++;
            }
            else if(num == el2){
                count2++;
            }
            else if(count1 == 0){
                count1 = 1;
                el1 = num;
                
            }
            else if(count2 == 0){
                count2 = 1;
                el2 = num;
            }
            else{
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for(int num : nums){
            if(num == el1){
                count1++;
            }
            if(num == el2){
                count2++;
            }
        }
        if(count1 > n / 3){
            System.out.println("Majority Element1:"+count1);
        }
        if(count2 > n / 3){
            System.out.println("Majority Element:"+count2);
        }
    }
}
