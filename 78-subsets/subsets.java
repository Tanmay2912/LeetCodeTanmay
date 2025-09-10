class Solution {
    public void generateSubsets(int[] nums, int index, List<Integer> path, List<List<Integer>> ds) {
        if (index == nums.length) {
            ds.add(new ArrayList<>(path)); 
            return;
        }
        path.add(nums[index]);
        generateSubsets(nums, index + 1, path, ds);
        path.remove(path.size() - 1);
        generateSubsets(nums, index + 1, path, ds);
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ds = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<>(), ds);
        return ds;
    }
}
