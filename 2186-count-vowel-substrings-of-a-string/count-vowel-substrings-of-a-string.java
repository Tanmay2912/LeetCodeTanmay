class Solution {
    public int countVowelSubstrings(String word) {
        int n = word.length(), ans = 0;
        for (int i = 0; i < n; i++) {
            if (!isVowel(word.charAt(i))) continue;
            boolean[] seen = new boolean[5];
            int distinct = 0;
            for (int j = i; j < n && isVowel(word.charAt(j)); j++) {
                int idx = "aeiou".indexOf(word.charAt(j));
                if (!seen[idx]) {
                    seen[idx] = true;
                    distinct++;
                }
                if (distinct == 5) ans++;
            }
        }
        return ans;
    }
    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) >= 0;
    }
}
