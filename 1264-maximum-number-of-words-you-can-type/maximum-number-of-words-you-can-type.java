class Solution {
    public boolean helper(String word, String brokenLetters) {
        for(int i = 0; i < word.length(); i++) {
            for(int j = 0; j < brokenLetters.length(); j++) {
                if(word.charAt(i) == brokenLetters.charAt(j)) {
                    return false; 
                }
            }
        }
        return true; 
    }
    public int canBeTypedWords(String text, String brokenLetters) {
        String words[] = text.split(" ");
        int cnt = 0;
        for(String word : words) {
            if(helper(word, brokenLetters)) {
                cnt++;
            }
        }
        return cnt;
    }
}
