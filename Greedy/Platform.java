package Greedy;
import java.util.*;
//very nice question on 19 july
public class Platform {

    static int findPlatform(int [] arr , int [] dep){

        int N = arr.length;
//greedy Approach
        Arrays.sort(arr);
        Arrays.sort(dep);

        int count = 0 ;
        int maxCount = 0;
        int i = 0;
        int j = 0;

        while(i < N && j < N){

            if(arr[i] <= dep[j]){
                count++;
                maxCount = Math.max(maxCount,count);
                i++;
            }
            else{
                count--;
                j++;
            }
        }
        return maxCount;
    }
    public static void main(String [] args){

    int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};

        int result = findPlatform(arr, dep);

        System.out.println("Minimum Platforms Required: " + result);
    }
}
