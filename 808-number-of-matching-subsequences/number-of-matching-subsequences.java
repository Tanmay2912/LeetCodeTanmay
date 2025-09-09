/*class Solution {
    public Set<String> findSubseq(String p, String up, Set<String> set) {
        if (up.isEmpty()) {
            set.add(p);
            return set;
        }
        char ch = up.charAt(0);
        findSubseq(p + ch, up.substring(1), set);
        findSubseq(p, up.substring(1), set);
        return set;
    }
    public int numMatchingSubseq(String s, String[] words) {
        Set<String> set = new HashSet<>();
        Set<String> subSeqSet = findSubseq("", s, set); 
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (subSeqSet.contains(words[i])) {
                count++;
            }
        }
        return count;
    }
    private boolean isSubsequence(String word, String s) {
        int i = 0, j = 0;
        while (i < word.length() && j < s.length()) {
            if (word.charAt(i) == s.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == word.length();
    }
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        for (String w : words) {
            if (isSubsequence(w, s)) {
                count++;
            }
        }
        return count;
    }
}*/
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            indexMap.computeIfAbsent(c, k -> new ArrayList<>()).add(i);
        }
        int count = 0;
        for (String word : words) {
            if (isSubsequence(word, indexMap)) {
                count++;
            }
        }
        return count;
    }
    private boolean isSubsequence(String word, Map<Character, List<Integer>> indexMap) {
        int prev = -1; 
        for (char c : word.toCharArray()) {
            if (!indexMap.containsKey(c)) return false;
            List<Integer> positions = indexMap.get(c); 
            int idx = Collections.binarySearch(positions, prev + 1);
            if (idx < 0) idx = -idx - 1; 
            if (idx == positions.size()) {
                return false; 
            }
            prev = positions.get(idx);
        }
        return true;
    }
}

