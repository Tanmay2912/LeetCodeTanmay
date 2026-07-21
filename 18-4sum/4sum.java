class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            // to skip duplicate elements
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < nums.length; j++) {
                // to skip duplicate elements
                if(j != i+1 && nums[j] == nums[j-1]) continue;
                int k = j+1, l = nums.length-1;
                while(k < l) {
                    long sum = (long) nums[i]+nums[j]+nums[k]+nums[l];
                    if(sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        ans.add(temp);
                        k++;
                        l--;
                        // to skip duplicate elements
                        while(k < l && nums[k] == nums[k-1]) k++;
                        while(k < l && nums[l] == nums[l+1]) l--;
                    }
                    else if(sum > target) l--;
                    else k++;
                }
            }
        }
        return ans;
    }
}