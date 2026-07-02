package StackQueues;
import java.util.Stack;
import java.util.Arrays;

public class H {
    public static int[] NextGreaterElement(int [] arr){

        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int [] nge = new int[n];

        for(int i= n - 1; i >= 0;i--){

            while(!s.isEmpty() && s.peek() <= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nge[i] = -1;
            }
            else{
                nge[i] = s.peek();
            }
            s.push(arr[i]);
        }
        return nge;
    }
    public static void main(String [] args){
        int[] arr = {4, 5, 2, 10};

        int[] result = NextGreaterElement(arr);

        System.out.println(Arrays.toString(result));
    }
}
