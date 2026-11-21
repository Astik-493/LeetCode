class Solution {
    class Row{
        int idx;
        int cnt;

        public Row(int idx,int cnt){
            this.idx = idx;
            this.cnt = cnt;
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Row> pq= new PriorityQueue<>((a,b)->{
            if(a.cnt==b.cnt) return a.idx - b.idx;
            else return a.cnt - b.cnt;
            });

        for(int i=0;i<mat.length;i++){
            int count = 0;
            for(int j=0;j<mat[0].length;j++){
                count+=mat[i][j];
            }
            pq.add(new Row(i,count));
        }
        int ans [] = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = pq.remove().idx;

        }
        return ans;
    }

}