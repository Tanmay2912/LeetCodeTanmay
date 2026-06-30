class Solution {
    public int numberOfSubstrings(String s) {
        int low = 0, high = 0;
        int hash[] = new int[3];
        int ans = 0;
        int n = s.length();
        while(high < n) {
            hash[s.charAt(high)-'a']++;
            while(hash[0] > 0 && hash[1] > 0 && hash[2] > 0) {
                ans += n - high;
                hash[s.charAt(low)-'a']--;
                low++;
            }
            high++;
        }
        return ans;
    }
}