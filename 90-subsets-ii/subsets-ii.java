class Solution {
    public void generateSubsets(int[] nums, List<List<Integer>> ans, List<Integer> ds, int idx) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        ds.add(nums[idx]);
        generateSubsets(nums, ans, ds, idx + 1);
        ds.remove(ds.size() - 1);
        int next = idx + 1;
        while (next < nums.length && nums[next] == nums[idx]) {next++;}
        generateSubsets(nums, ans, ds, next);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        generateSubsets(nums, ans, new ArrayList<>(), 0);
        return ans;
    }
}