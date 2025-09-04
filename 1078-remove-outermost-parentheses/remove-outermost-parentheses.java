class Solution {
    public String removeOuterParentheses(String s) {
        int cnt = 0;
        int start = 0;
        List<String> primitive = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                cnt++;
            }
            else {
                cnt--;
            }
            if(cnt == 0) {
                primitive.add(s.substring(start, i+1));
                start = i+1;
            }
        }
        StringBuilder result = new StringBuilder();
        for(String str : primitive) {
            result.append(str.substring(1, str.length()-1));
        }
        return result.toString();
    }
}