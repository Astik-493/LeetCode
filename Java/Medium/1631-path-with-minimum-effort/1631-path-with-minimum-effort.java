class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0]));

        pq.add(new int[]{0, 0, 0});
        dist[0][0] = 0;

        int[] r = {1, 0, -1, 0};
        int[] c = {0, -1, 0, 1};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int val = curr[0];
            int row = curr[1];
            int col = curr[2];

            if (row == n - 1 && col == m - 1)
                return val;

            // if (val > dist[row][col])
            //     continue;

            for (int i = 0; i < 4; i++) {
                int ur = row + r[i];
                int uc = col + c[i];

                if (ur >= 0 && ur < n && uc >= 0 && uc < m) {
                    int diff = Math.abs(
                        heights[ur][uc] - heights[row][col]
                    );

                    int max = Math.max(val, diff);

                    if (dist[ur][uc] > max) {
                        dist[ur][uc] = max;
                        pq.add(new int[]{max, ur, uc});
                    }
                }
            }
        }

        return 0;
    }
}