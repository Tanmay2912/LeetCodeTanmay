class Solution {
    public void generatePairs(int[] candidates, int target, List<List<Integer>> ans, int idx, List<Integer> ds) {
        if(idx == candidates.length) {
            if(target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        // choosen
        if(candidates[idx] <= target) {
            ds.add(candidates[idx]);
            generatePairs(candidates, target-candidates[idx], ans, idx, ds);
            ds.remove(ds.size()-1);
        }
        //not choosen
        generatePairs(candidates, target, ans, idx+1, ds);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int idx = 0;
        List<Integer> ds = new ArrayList<>();
        generatePairs(candidates, target, ans, idx, ds);
        return ans;
    }
}








