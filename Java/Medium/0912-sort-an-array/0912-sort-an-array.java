class Solution {
    public void heapify(int [] nums,int i,int n){
        int left = 2*i+1;
        int right = 2*i+2;
        int maxI = i;
        if(left<n && nums[maxI]<nums[left])
            maxI = left;

        if(right<n && nums[maxI]<nums[right])
            maxI = right;

        if(maxI!=i){
            int temp = nums[i];
            nums[i] = nums[maxI];
            nums[maxI] = temp;

            heapify(nums,maxI,n);
        }
    }
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        for(int i=n/2;i>=0;i--)
            heapify(nums,i,n);

        for(int i=n-1;i>=0;i--){
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            heapify(nums,0,i);
        }
        return nums;   
    }
    // public int[] sortArray(int[] nums) {
    //   if ( nums.length <= 1) {
    //         return nums;
    //     }

    //     sort(nums, 0, nums.length - 1);
    //     return nums;
    // }

    // private void sort(int[] A, int l, int r) {
    //     if (l >= r) {
    //         return;
    //     }

    //     int m = (l + r) / 2;

    //     sort(A, l, m);       
    //     sort(A, m + 1, r);   
    //     merge(A, l, m, r);  
    // }

    //  private void merge(int[] A, int l, int m, int r) {

    // int N = m - l + 1;
    // int M = r - m;

    // int[] L = new int[N];
    // int[] R = new int[M];

    // for (int i = 0; i < N; i++) {
    //     L[i] = A[l + i];
    // }

    // for (int j = 0; j < M; j++) {
    //     R[j] = A[m + 1 + j];
    // }

    // int i = 0, j = 0;
    // int k = l;

    // while(i<N && j<M){
    //     if(L[i] <= R[j]){
    //          A[k] = L[i];
    //         i++;
    //     }
    //     else {
    //         A[k] = R[j];
    //         j++;
    //     }
    //     k++;
    // }
    // while(i<N){
    //     A[k] = L[i];
    //         i++;
    //         k++;
    // }
    // while(j<M){
    //     A[k] = R[j];
    //         j++;
    //         k++;
    // }
    //  }
}
