class Solution {
    public String addBinary(String a, String b) {
        char arrA[] = a.toCharArray();
        char arrB[] = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = arrA.length-1, j = arrB.length-1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int aNum = i >= 0 ? arrA[i] - '0' : 0;
            int bNum = j >= 0 ? arrB[j] - '0' : 0;
            int sum = aNum + bNum + carry;
            int digit = sum % 2;
            carry = sum / 2;
            i--;
            j--;
            sb.append((char)(digit + '0'));
        }
        return sb.reverse().toString();
    }
}