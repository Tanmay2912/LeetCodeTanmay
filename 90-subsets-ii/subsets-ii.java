class Solution {
    public void generateSubsets(int idx, int nums[], List<List<Integer>> ans, List<Integer> ds) {
        if(idx == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        ds.add(nums[idx]);
        generateSubsets(idx+1, nums, ans, ds);
        ds.remove(ds.size()-1);
        int next = idx + 1;
        while(next < nums.length && nums[next] == nums[idx]) {
            next++;
        }
        generateSubsets(next, nums, ans, ds);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        generateSubsets(0, nums, ans, new ArrayList<>());
        return ans;
    }
}