class Solution {
    public String sortVowels(String s) {
        ArrayList<Character> vowel = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a' ||
               s.charAt(i) == 'e' ||
               s.charAt(i) == 'i' ||
               s.charAt(i) == 'o' ||
               s.charAt(i) == 'u' ||
               s.charAt(i) == 'A' ||
               s.charAt(i) == 'E' ||
               s.charAt(i) == 'I' ||
               s.charAt(i) == 'O' ||
               s.charAt(i) == 'U' ) 
            {
                vowel.add(s.charAt(i));
            }
        }
        Collections.sort(vowel);
        StringBuilder sb = new StringBuilder(s);
        int k = 0;
        for(int i = 0; i < s.length(); i++) {
            if(sb.charAt(i) == 'a' ||
               sb.charAt(i) == 'e' ||
               sb.charAt(i) == 'i' ||
               sb.charAt(i) == 'o' ||
               sb.charAt(i) == 'u' ||
               sb.charAt(i) == 'A' ||
               sb.charAt(i) == 'E' ||
               sb.charAt(i) == 'I' ||
               sb.charAt(i) == 'O' ||
               sb.charAt(i) == 'U' ) 
            {
                sb.setCharAt(i, vowel.get(k));
                k++;
            }
        }
        return sb.toString();
    }
}