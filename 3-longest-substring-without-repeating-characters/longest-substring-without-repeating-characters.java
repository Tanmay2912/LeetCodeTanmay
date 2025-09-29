/*class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        Map<Character, Integer> lastSeen = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (lastSeen.containsKey(c) && lastSeen.get(c) >= left) {
                left = lastSeen.get(c) + 1;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            lastSeen.put(c, right);
        }

        return maxLength;       
    }
}*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, maxLen = 0;
        int hash[] = new int[256];
        Arrays.fill(hash, -1);
        while(r < s.length()) {
            if(hash[s.charAt(r)] != -1) {
                if(hash[s.charAt(r)] >= l) {
                    l = hash[s.charAt(r)]+1;
                }
            }
            maxLen = Math.max(maxLen, r-l+1);
            hash[s.charAt(r)] = r;
            r++;
        }
        return maxLen;
    }
}