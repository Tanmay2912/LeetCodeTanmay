class Solution {
    public String largestOddNumber(String num) {
        ArrayList<Character> numList = new ArrayList<>();
        for(int i = 0; i < num.length(); i++) {
            numList.add(num.charAt(i));
        }
        String ans = "";
        for (int i = numList.size() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(numList.get(i));
            if (digit % 2 != 0) {
                ans = num.substring(0, i + 1);
                break;
            }
        }
        return ans;
    }
}