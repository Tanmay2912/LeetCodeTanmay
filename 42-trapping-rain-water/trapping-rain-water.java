class Solution {
    public int[] prefixMax(int[] height) {
        int[] prefix = new int[height.length];
        prefix[0] = height[0];
        for(int i = 1; i < height.length-1; i++) {
            prefix[i] = Math.max(prefix[i-1], height[i]);
        }
        return prefix;
    }
    public int[] suffixMax(int[] height) {
        int suffix[] = new int[height.length];
        suffix[height.length-1] = height[height.length-1];
        for(int i = height.length-2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i+1], height[i]);
        }
        return suffix;
    }
    public int trap(int[] height) {
        int prefix[] = prefixMax(height);
        int suffix[] = suffixMax(height);
        int total = 0;
        for(int i = 0; i < height.length; i++) {
            if(height[i] < prefix[i] && height[i] < suffix[i]) {
                total += (Math.min(prefix[i], suffix[i]) - height[i]);
            }
        }
        return total;
    }
}