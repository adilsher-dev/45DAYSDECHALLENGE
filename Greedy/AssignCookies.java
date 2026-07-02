package Greedy;

import java.util.Arrays;

public class AssignCookies {

    public static int findContentChildren(int[] greed, int[] cookies) {

        Arrays.sort(greed);
        Arrays.sort(cookies);

        int i = 0 ;
        int j = 0;

        while(i < greed.length && j < cookies.length){
            if(cookies[j] >= greed[i]){
                i++;
            }
            j++;
        }
        return i;

    }

    public static void main(String[] args) {

        int[] greed = {1, 2, 3};
        int[] cookies = {1, 1};

        System.out.println(findContentChildren(greed, cookies));
    }
}