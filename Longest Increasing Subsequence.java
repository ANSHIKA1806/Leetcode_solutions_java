public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        ArrayList<Integer> lis = new ArrayList<Integer>();
        for (int n : nums) {
            if (lis.size() == 0 || lis.get(lis.size() - 1) < n) {
                lis.add(n);
            } else {
                updateLIS(lis, n);
            }
        }
        return lis.size();
    }
    
    private void updateLIS(ArrayList<Integer> lis, int n) {
        int l = 0, r = lis.size() - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (lis.get(m) < n) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        lis.set(l, n);
    }
}
