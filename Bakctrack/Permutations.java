package Bakctrack;

import java.util.*;

public class Permutations {

    static void generate(int index, int[] arr, List<List<Integer>> ans) {
        if(index == arr.length){

            List<Integer> temp = new ArrayList<>();

            for(int num : arr){
                temp.add(num);
            }

            ans.add(temp);
            return;
        }

        for(int i = index ; i < arr.length;i++){

            swap(arr,index,i);

            generate(index+1,arr,ans);

            swap(arr,index,i);

        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3};

        List<List<Integer>> ans = new ArrayList<>();

        generate(0, arr, ans);

        System.out.println(ans);
    }
}