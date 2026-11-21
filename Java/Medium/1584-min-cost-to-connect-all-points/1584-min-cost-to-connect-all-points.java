class Solution {
    public int minCostConnectPoints(int[][] points) {
      int n = points.length;
       PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        boolean[] visited = new boolean[n];

        pq.add(new int []{0,0});
        int totalC = 0;
        int count = 0;
        while(count<n && !pq.isEmpty()){
            int [] curr = pq.remove();
            int cost = curr[0];
            int idx = curr[1];

            if(visited[idx])
                continue;
            
            visited[idx] = true;
            totalC += cost;
            count++;

            for(int i=0;i<n;i++){
                if(!visited[i]){
                    int dist = Math.abs(points[idx][0]- points[i][0]) + Math.abs(points[idx][1]- points[i][1]);

                    pq.add(new int []{dist,i});
                }
            }
        }
            return totalC;
    }
}