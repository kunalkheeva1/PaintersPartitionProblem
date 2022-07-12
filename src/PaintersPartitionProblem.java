public class PaintersPartitionProblem {

        //a method to check if the mid satisfy the situation, or nay other number in the array
    // of containing low to high;
    // also gives me the count
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

        // get the values of high and low
        for(int i= 0; i<n; i++){
            low = Math.max(low, arr[i]);
            high += arr[i];
        }


        // after getting high and low,
        // store them in an array low to high  and check them accordingly
        long ans = -1;
        while(low<= high){
            // mid
            long mid = (low + high)/2;
           // check if mid satisfies the condition and if k<=n;
            if((check(arr, n, k, mid))){
                //store mid in ans and then repeat the iteration with other half of array
                ans = mid;
                high = mid-1;
            }else
            // else amount of work is more than mid for painter then check the other half of the array
            {
                low = mid+1;
            }
        }return ans;




    }


    public static void main(String[] args) {

    }
}
