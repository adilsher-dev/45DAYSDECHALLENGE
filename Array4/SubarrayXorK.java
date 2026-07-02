package Array4;

import java.util.HashMap;

public class SubarrayXorK {

    public static int subarraysWithXorK(int [] arr, int k) {

        HashMap<Integer,Integer> mpp = new HashMap<>();

        int n = arr.length;

        int xr = 0;
        int count = 0;

        mpp.put(0,1);

        for(int i = 0; i < n;i++){

            xr = xr ^ arr[i];

            int x = xr ^ k;

            if(mpp.containsKey(x)){
                count += mpp.get(x);
            }

            mpp.put(xr,mpp.getOrDefault(xr,0)+1);


        }
        return count;
    }

    public static void main(String[] args) {

        int[] arr = {4, 2, 2, 6, 4};
        int k = 6;

        System.out.println(subarraysWithXorK(arr, k));
    }
}