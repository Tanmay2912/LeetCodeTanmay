class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<Integer>();
        List<Integer> num = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++) {
            num.add(nums[i]);
        }
        int low = nums[0], high = nums[nums.length-1];
        for(int i = low+1; i < high; i++) {
            if(!num.contains(i)) {
                ans.add(i);
            }
        }
        return ans;
    }
}