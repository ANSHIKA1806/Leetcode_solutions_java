class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(r * c != nums.length * nums[0].length){ return nums; }
        int[] f = new int[r * c];
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums[0].length; j++){
                f[i*nums[0].length + j] = nums[i][j];
            }
        }
        int[][] ans = new int[r][];
        for(int i = 0; i < r; i++){
            ans[i] = Arrays.copyOfRange(f, i*c, i*c+c);
        }
        return ans;
    }
}
