class Solution {
    public boolean checkPalindrome(String s, int left, int right) {
        if(left >= right) {
            return true;
        }
        if(s.charAt(left) != s.charAt(right)) {
            return false;
        }
        return checkPalindrome(s, left+1, right-1);
    }
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        String newStr = sb.toString();
        return checkPalindrome(newStr, 0, newStr.length()-1);
    }
}