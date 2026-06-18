import java.util.*;
public class MergeSortedArray {
    public static void main(String [] args){
        int [] nums1 = {1,2,3,0,0,0};
        int [] nums2 = {2,5,6};
        int l1 = 0;
        int l2 = 0;
        int n = 3;
        int m = 3;

        List<Integer> ans = new ArrayList<>();

        while( l1 < n && l2 < m){
            if(nums1[l1] <= nums2[l2]){
                ans.add(nums1[l1]);
                l1++;
            }
            else{
                ans.add(nums2[l2]);
                l2++;
            }
        }

        while(l1<n){
            ans.add(nums1[l1]);
            l1++;
        }
        while(l2<m){
            ans.add(nums2[l2]);
            l2++;
        }

        for(int x : ans){
            System.out.println(x + " ");
        }
    }
}
