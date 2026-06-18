package LinkedList3;

public class MaxCons {
    public static void main(String[] args){
       int [] arr = {1,1,0,1,1,1};

       int n = arr.length;

       int count = 0;
       int maxi = 0;

       for(int i = 0; i < n;i++){
        if(arr[i] == 1){
            count++;
            maxi = Math.max(maxi,count);
        }
        else {
            count = 0;
        }
       }
       System.out.println(maxi);
    }
}
