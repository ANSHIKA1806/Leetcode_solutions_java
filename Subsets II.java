class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        int index = 0;
        
        backtrack(temp, result, index, nums);
        return result;
    }
    
    public void backtrack(LinkedList<Integer> temp, List<List<Integer>> result, int index, int[] nums) {
        result.add(new ArrayList<>(temp));
        
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            backtrack(temp, result, i + 1, nums);
            temp.removeLast();
        }
    }
}
