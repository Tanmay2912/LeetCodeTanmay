class Solution {
    public void generateSubsets(int[] nums, List<List<Integer>> ans, int idx, List<Integer> ds) {
        if(idx == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        ds.add(nums[idx]);
        generateSubsets(nums, ans, idx+1, ds);
        ds.remove(ds.size()-1);
        generateSubsets(nums, ans, idx+1, ds);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        int idx = 0;
        generateSubsets(nums, ans, idx, ds);
        return ans;
    }
}