public class PaintersPartitionProblem {


    public static boolean check(int arr[], int n , int k, long mid){
        // count =1 as I am assuming 1 painter working on it first
        long work = 0;
        long count = 1;

        //if work and the arr[i] < mid, means if the work to do all is smaller than mid , then we can add more work for one painter
        //else we need anther painter, and that painter will start working from the next board so work will be arr[i]
        for(int i=0; i<n; i++){
            if(work + arr[i]< mid){
                work += arr[i];
            }else
            {   count++;
                work = arr[i];
            }
        }

        // after all the iterations if i get count <=k, which satisfies my parameters, i will return true
        //else false
        //and false will eliminate all the small time possibilities and update the low with mid+1 for next iteration
        if(count<= k){
            return true;
        }else{
            return false;
        }
    }



    public static long paintersPartitionProblem(int []arr, int k, int n){

        //low is storing the atleast time, which should be when k=n and all of them work together and which is max element of the array
        // high is if there is only one painter k=1, so sum of the whole array.
        long low = arr[0];
        long high = 0;

        for(int i= 0; i<n; i++){
            low = Math.max(low, arr[i]);
            high += arr[i];
        }

        //now the answer lies in between low and high so run a loop to get it, we will perform binary search
        // get a mid and check if it satisfies the situation in check method and eliminate all the greater possibilities
        // else eliminate all the small times and start with mid+1 in else statement.
        //update the answer with mid all the times and return it.
        long ans = -1;
        while(low<= high){
            long mid = (low + high)/2;
            if((check(arr, n, k, mid))){
                ans = mid;
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }return ans;
    }


    public static void main(String[] args) {

    }
}
