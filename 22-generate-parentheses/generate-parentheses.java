class Solution {
    public List<String> checkValidParenthesis(int idx, String s, int open, int close, List<String> list, int n) {
        if(open > n) {
            return list;
        }
        if(open + close == 2*n && open == close) {
            list.add(s);
            return list;
        }
        checkValidParenthesis(idx+1, s+"(", open+1, close, list, n);
        if(open > close) {
            checkValidParenthesis(idx+1, s+")", open, close+1, list, n);
        }
        return list;
    }
    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();
        int idx = 0, open = 0, close = 0;
        return checkValidParenthesis(idx, "", open, close, list, n);
    }
}