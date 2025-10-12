class Solution  {
    public String multiply(String a, String b) {
        int len1 = a.length(), len2 = b.length();
        int res[] = new int[len1 + len2];
        // Multiply digits from end to start
        for (int x = len1 - 1; x >= 0; x--) {
            int d1 = a.charAt(x) - '0';
            for (int y = len2 - 1; y >= 0; y--) {
                int d2 = b.charAt(y) - '0';
                int idxLow = x + y + 1;
                int idxHigh = x + y;
                
                int total = d1 * d2 + res[idxLow];
                res[idxLow] = total % 10;
                res[idxHigh] += total / 10;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int val : res) {
            if (result.length() == 0 && val == 0) continue;
            result.append(val);
        }
        return result.length() == 0 ? "0" : result.toString();
    }
}