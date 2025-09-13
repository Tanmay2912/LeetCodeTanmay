class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character, Integer> v = new HashMap<>();
        HashMap<Character, Integer> c = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ("aeiou".indexOf(ch) != -1) {  
                v.put(ch, v.getOrDefault(ch, 0) + 1);
            } 
            else {  
                c.put(ch, c.getOrDefault(ch, 0) + 1);
            }
        }
        int vmax = 0, cmax = 0;
        for (int val : v.values()) {
            vmax = Math.max(vmax, val);
        }
        for (int val : c.values()) {
            cmax = Math.max(cmax, val);
        }
        return vmax + cmax;
    }
}
