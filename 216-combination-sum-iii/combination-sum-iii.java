class Solution {
    public void generateSubset(int idx, int cnt, int k, int n, List<List<Integer>> ans, List<Integer> ds) {
        if (idx > 9) {
            if (n == 0 && cnt == k) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if (cnt < k && n - idx >= 0) {
            ds.add(idx);
            generateSubset(idx + 1, cnt + 1, k, n - idx, ans, ds);
            ds.remove(ds.size() - 1);
        }
        generateSubset(idx + 1, cnt, k, n, ans, ds);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        generateSubset(1, 0, k, n, ans, new ArrayList<>());
        return ans;
    }
}
