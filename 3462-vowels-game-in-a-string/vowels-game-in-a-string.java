class Solution {
    public int countVowels(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if ("aeiou".indexOf(s.charAt(i)) != -1) {
                cnt++;
            }
        }
        return cnt;
    }

    public boolean doesAliceWin(String s) {
        int cV = countVowels(s);
        if (cV == 0) {
            return false;
        }
        return true;
    }
}
