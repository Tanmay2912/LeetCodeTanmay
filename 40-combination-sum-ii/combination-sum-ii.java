class Solution {
    public void generateCombinations(int[] candidates, int target, List<List<Integer>> ans, int idx, List<Integer> ds) {
        if(idx == candidates.length) {
            if(target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        //choose
        if(candidates[idx] <= target) {
            ds.add(candidates[idx]);
            generateCombinations(candidates, target-candidates[idx], ans, idx+1, ds);
            ds.remove(ds.size()-1);
        }
        int next = idx+1;
        while(next < candidates.length && candidates[next] == candidates[idx]) next++;
        generateCombinations(candidates, target, ans, next, ds);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        // this is done to escape the duplicates eaisly
        Arrays.sort(candidates);
        int idx = 0;
        generateCombinations(candidates, target, ans, idx, ds);
        return ans;
    }
}







