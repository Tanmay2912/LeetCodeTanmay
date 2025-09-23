class Solution {
    public int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int i = 0, j = 0;
        while(i < nums1.length || j < nums2.length) {
            int n1 = (i < nums1.length) ? Integer.parseInt(nums1[i]) : 0;
            int n2 = (j < nums2.length) ? Integer.parseInt(nums2[j]) : 0;

            if (n1 < n2) {
                return -1;
            } 
            else if (n1 > n2) {
                return 1;
            }
            i++;
            j++;
        } 
        return 0;
    }
}