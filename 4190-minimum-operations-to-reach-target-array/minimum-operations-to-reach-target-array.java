class Solution {
    public int minOperations(int[] nums, int[] target) {
        // A Set stores unique elements only.
        // We use it to track which distinct x values need updating.
        Set<Integer> valuesToChange = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            // If the current value doesn't match the target...
            if (nums[i] != target[i]) {
                // ...we must eventually perform an operation on value nums[i].
                // Because all segments of nums[i] update simultaneously,
                // we only count each unique value once.
                valuesToChange.add(nums[i]);
            }
        }
        // The number of operations is the count of unique 'x' values identified.
        return valuesToChange.size();
    }
}