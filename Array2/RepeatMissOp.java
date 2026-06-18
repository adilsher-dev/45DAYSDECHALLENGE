public class RepeatMissOp {
    public static void main(String [] args){
        int [] arr = {4,3,6,2,1,1};
        int n = arr.length;

        long sumArr = 0;
        long sumN = 0;

        long sqArr = 0;
        long sqN = 0;

        for(int i = 0; i < n;i++){
            sumArr += arr[i];
            sqArr += (long)(arr[i] *arr[i]);
        }

        for(int i = 1;i <= n;i++){
            sumN += i;
            sqN += (long)(i*i);
        }

        long xMinusY = sumArr - sumN;
        long sqDiff = sqArr - sqN;
        long xPlusY = sqDiff/xMinusY;

        long x = (xMinusY + xPlusY)/2;
        long y = xPlusY - x;

        System.out.println("Repeating:"+x);
        System.out.println("Missing:"+y);
    } 
}
