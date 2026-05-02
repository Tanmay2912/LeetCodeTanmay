/*class Solution {
    public String convertToBase7(int num) {
        return Integer.toString(num, 7);
    }
}*/
class Solution {
    public String convertToBase7(int num) {
        if (num == 0) return "0";

        boolean negative = num < 0;
        num = Math.abs(num);
        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            int rem = num % 7;
            sb.append(rem);   // append remainder
            num /= 7;         // divide by 7
        }

        if (negative) sb.append('-');

        return sb.reverse().toString();
    }
}