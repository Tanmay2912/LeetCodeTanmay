class Solution {
    public int strStr(String haystack, String needle) {
        /*int i = 0, j = 0;
        int index = -1;
        while(i < haystack.length() && j < needle.length()) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                i++; j++;
                continue;
            }
            else {
                i++;
            }
        }
        if(needle == null) return -1; 
        if(haystack.isEmpty()) return 0; 
        if(needle.length() > haystack.length()) return -1;
        for(int i = 0; i < haystack.length()-needle.length(); i++) {
            if(haystack.substring(i, i+needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;*/
        return haystack.indexOf(needle);
    }
}