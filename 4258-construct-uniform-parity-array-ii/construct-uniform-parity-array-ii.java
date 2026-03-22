class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        int min = Integer.MAX_VALUE;
        for(int i : nums1) {
            min = Math.min(min, i);
        }
        if(min%2 == 1) return true;
        for(int i : nums1) {
            if(i%2 == 1) return false;
        }
        return true;
    }
}