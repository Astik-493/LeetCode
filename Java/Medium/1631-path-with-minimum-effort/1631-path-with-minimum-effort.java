class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        
        if(n==1&&m==1)
        return 0;

        int [][] dist = new int[n][m];
        for(int i=0;i<n;i++)
        Arrays.fill(dist[i],Integer.MAX_VALUE);

        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{0,0,0});

        int [] r = {1,0,-1,0};
        int [] c = {0,-1,0,1};

        while(!q.isEmpty()){
            int [] curr = q.poll();
            int val = curr[0];
            int row = curr[1];
            int col = curr[2];
            
            for(int i=0;i<4;i++){
                int ur = row + r[i];
                int uc = col + c[i];

                if(ur>=0&&ur<n&&uc>=0&&uc<m){
                    int diff = Math.abs(heights[ur][uc]-heights[row][col]); 
                    int max = Math.max(val,diff);

                    if(dist[ur][uc]>max){
                        dist[ur][uc] = max;
                        q.add(new int[]{max,ur,uc});
                    }
                }
            }
        }
        return dist[n-1][m-1];
    }
}