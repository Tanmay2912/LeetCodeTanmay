class Solution {
    public String reverseWords(String s) {
        String[] stringWords = s.split("\\s+");
        StringBuilder result = new StringBuilder();
        for(int i = stringWords.length-1; i >= 0; i--) {
            result.append(stringWords[i]);
            if(i != 0) {
                result.append(" ");
            }
        }
        return result.toString().trim();
    }
}