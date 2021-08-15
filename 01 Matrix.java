class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(matrix[i][j] == 0) {
                    q.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        int[][] dir = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int[] d : dir) {
                int i = curr[0] + d[0];
                int j = curr[1] + d[1];
                if(i < 0 || j < 0 || i >= r || j >= c || matrix[i][j] <= matrix[curr[0]][curr[1]] + 1) continue;
                matrix[i][j] = matrix[curr[0]][curr[1]] + 1;
                q.offer(new int[]{i, j});
            }
        }
        return matrix;
    }
}
//anshika
