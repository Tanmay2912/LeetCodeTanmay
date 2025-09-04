import java.util.*;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> mapped = new HashSet<>(); 
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (map.containsKey(sc)) {
                if (map.get(sc) != tc) {
                    return false; 
                }
            } 
            else {
                if (mapped.contains(tc)) {
                    return false; 
                }
                map.put(sc, tc);
                mapped.add(tc);
            }
        }
        return true;
    }
}
