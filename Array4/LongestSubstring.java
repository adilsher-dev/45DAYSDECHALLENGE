package Array4;
import java.util.*;

public class LongestSubstring {
    public static void main(String [] args){
        String s = "";
        int n = s.length();

        HashMap<Character,Integer> mpp = new HashMap<>();


        int left = 0;
        int maxLen = 0;

        for(int right = 0; right<n;right++){

            char ch = s.charAt(right);

            if(mpp.containsKey(ch)){
                left = Math.max(left,mpp.get(ch)+1);
            }

            mpp.put(ch,right);

            maxLen = Math.max(maxLen,right-left+1);
        }
        System.out.println(maxLen);
    }
    
}
