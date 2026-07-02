package String;
import java.util.*;

public class LCP {
    public static void main(String[] args){
        String [] arr = {"flower","flow","flight"};
        int n = arr.length;

        Arrays.sort(arr);

        String s1 = arr[0];
        String s2 = arr[n-1];
        String ans = "";

        int i = 0;
        int j = 0;

        while(i < s1.length() && j < s2.length() && s1.charAt(i) == s2.charAt(j)){
            ans += s1.charAt(i);
            i++;
            j++;

        }
            System.out.println(ans);
        }
    }
