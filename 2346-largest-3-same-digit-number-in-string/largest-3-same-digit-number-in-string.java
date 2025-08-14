class Solution {
    public String largestGoodInteger(String num) {
        String result = "";
        
        for (int i = 0; i <= num.length() - 3; i++) {
            char c = num.charAt(i);
            if (num.charAt(i + 1) == c && num.charAt(i + 2) == c) {
                String triple = num.substring(i, i + 3);
                if (result.isEmpty() || triple.compareTo(result) > 0) {
                    result = triple;
                }
            }
        }
        return result;
    }
}
