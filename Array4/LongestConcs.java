package Array4;
import java.util.HashSet;


public class LongestConcs {
    public static void main(String[] args){
        //better 

        //  int [] num = {100,102,100,101,101,4,3,2,3,2,1,1,1,2};

        // Arrays.sort(arr);

        // int n = arr.length;

        // int maxi = 1;
        // int count = 1;

        // for(int i = 0; i < n ;i++){
        //     if(arr[i] == arr[i+1]){
        //         continue;
        //     }
        //     else if(arr[i] + 1 == arr[i+1]){
        //         count++;
        //     }
        //     else{
        //         maxi = Math.max(maxi,count);
        //         count = 1;
        //     }
        // }
        // maxi = Math.max(maxi,count);

        //Optimal...

        HashSet<Integer> set = new HashSet<>();
        int [] nums = {100,102,100,101,101,4,3,2,3,2,1,1,1,2};

        for(int num : nums){
            set.add(num);
        }
        int maxi = 0;

        for(int num : set){
            if(set.contains(num-1)){
                continue;
            }

            int check = num;
            int longest = 1;

            while(set.contains(check+1)){
                check++;
                longest++;
            }
            maxi = Math.max(maxi,longest);
        }
        System.out.println(maxi);
    }
}
        
        
        
        