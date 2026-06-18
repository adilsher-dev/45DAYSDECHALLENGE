package BinarySearch;
public class Nthroot {

    static int NRoot(int n,int m){

        int low = 1;
        int high = m;

        while(low <= high){

            int mid = low + (high - low)/2;

            long value = power(mid,n);

            if(value == m){
                return mid;
            }
            else if( value < m){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }

    static long power(int num,int exp){
        long ans = 1;
        for(int i = 0 ; i < exp;i++){
            ans *= num;
        }
        return ans;
    }
    public static void main(String[] args){
        int n = 3;
        int m = 27;
        System.out.println(NRoot(n,m));
    }
}
