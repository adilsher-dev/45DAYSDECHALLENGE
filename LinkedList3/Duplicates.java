package LinkedList3;

public class Duplicates {
    public static void main(){
        int [] arr = {1,1,2,2,2,3,3};
        int n = arr.length;

        int idx = 0;

        for(int i = 1 ; i < n;i++){
            if(arr[i] != arr[idx]){
                idx++;
                arr[idx] = arr[i];
            }
        }
        System.out.println(idx+1);
    }
}
