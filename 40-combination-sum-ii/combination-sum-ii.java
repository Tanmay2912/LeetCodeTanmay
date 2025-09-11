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
            generateCombinations(idx+1, target-arr[idx], arr, ans, ds);
            ds.remove(ds.size()-1);
        }
        int next = idx + 1;
        while (next < arr.length && arr[next] == arr[idx]) next++;
        generateCombinations(next, target, arr, ans, ds);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        generateCombinations(0, target, candidates, ans, new ArrayList<Integer>());
        return ans;
    }
}