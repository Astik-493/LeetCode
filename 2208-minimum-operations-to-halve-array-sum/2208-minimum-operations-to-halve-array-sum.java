class Solution {
    public int halveArray(int[] nums) {
       PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> Double.compare(b, a)); 
       double sum = 0;
       for(int x: nums){
            sum+=x;
            pq.add((double)x);
        }
        sum/=2;
        int cnt=0;
        while(sum>0){
            double x = pq.remove()/2;
            pq.add(x);
            sum-=x;
            cnt++;
        }

        return cnt;
        
       }
}