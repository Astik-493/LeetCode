class Solution {
    class point{
        int x;
        int y;
        int dist;
        public point(int x,int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<point> pq = new PriorityQueue<>((a,b)-> a.dist - b.dist);

        for(int i=0;i<points.length;i++){
            int dist = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            pq.add(new point(points[i][0],points[i][1],dist));
        }
        int ans [][] =new int [k][2];
        for(int i=0;i<k;i++){
            point p = pq.remove();
            ans[i][0] = p.x;
            ans[i][1] = p.y; 
        }
        return ans;
    }
}