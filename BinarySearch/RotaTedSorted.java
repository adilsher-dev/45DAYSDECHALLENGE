package BinarySearch;

public class RotaTedSorted {
    public static void main(String[] args){
        int [] arr = {4,5,6,7,0,1,2};
        int n = arr.length;
        int target = 0;
        int low = 0;
        int high = n - 1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(arr[mid] == target){
                System.out.println("The index is :"+mid);
                break;
            }

            if(arr[mid] >= arr[low]){
                if(target >= arr[low] && target <= arr[mid]){
                    high = mid - 1;

                }
                else{
                    low = mid + 1;
                }
            }
            else{
                if(target >= arr[mid] && target <= arr[high]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
    }
}
