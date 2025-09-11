class Solution {
    public void generateCombinations(int idx, int target, int arr[], List<List<Integer>> ans, List<Integer> ds) {
        if(idx == arr.length) {
            if(target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(arr[idx] <= target) {
            ds.add(arr[idx]);
            generateCombinations(idx, target-arr[idx], arr, ans, ds);
            ds.remove(ds.size()-1);
        }
        generateCombinations(idx+1, target, arr, ans, ds);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        generateCombinations(0, target, candidates, ans, new ArrayList<>());
        return ans;
    }
}