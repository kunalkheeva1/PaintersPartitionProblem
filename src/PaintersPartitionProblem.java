public class PaintersPartitionProblem {


    public static boolean check(int arr[], int n , int k, long mid){
        long work = 0;
        long count = 1;

        for(int i=0; i<n; i++){
            if(work + arr[i]< mid){
                work += arr[i];
            }else
            {   count++;
                work = arr[i];
            }
        }
        if(count<= k){
            return true;
        }else{
            return false;
        }
    }



    public static long paintersPartitionProblem(int []arr, int k, int n){

        // low will be the time when n= k and they do all the paints together.
        long low = arr[0];
        //high is the time when only one painter do all the paints
        long high = 0;


        for(int i= 0; i<n; i++){
            low = Math.max(low, arr[i]);
            high += arr[i];
        }
        long ans = -1;
        while(low<= high){
            long mid = (low + high)/2;
            if((check(arr, n, k, mid))){
                ans = mid;
                high = mid-1;
            }else
            {
                low = mid+1;
            }
        }return ans;




    }


    public static void main(String[] args) {

    }
}
