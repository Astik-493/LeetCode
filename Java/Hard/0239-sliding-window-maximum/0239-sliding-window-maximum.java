class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Deque<Integer> dq = new ArrayDeque<>();
        // int n = nums.length;
        // int res [] = new int[n-k+1];
        // for(int i=0;i<k;i++){
        //     while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i])
        //     dq.pollLast();
        //     dq.addLast(i);
        // }
        // res[0] = nums[dq.peekFirst()];
        // for(int i = k;i<nums.length;i++){
        //     while(!dq.isEmpty() && (i - dq.peekFirst()) >= k)
        //     dq.pollFirst();
            
        //     while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i])
        //     dq.pollLast();

        //     dq.addLast(i);
    
        // res[i-k+1] = nums[dq.peekFirst()];
        // }
        // return res;


        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)-> b[0]-a[0]);
         int n = nums.length;
         int res [] = new int[n-k+1];

         for(int i=0;i<k;i++)
            pq.add(new int []{nums[i],i});

        res[0] = pq.peek()[0];

        for(int i=k;i<n;i++){
            while(!pq.isEmpty() && pq.peek()[1]<=i-k)
                pq.poll();

            pq.add(new int []{nums[i],i});

            res[i-k+1] = pq.peek()[0];
        }
        return res;
    }
}