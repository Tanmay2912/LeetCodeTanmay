class Solution {
    public int reverseDigit(int n) {
        int rn = 0;
        while(n!=0) {
            int lastDigit = n%10;
            rn = rn*10 + lastDigit;
            n = n/10;
        }
        return rn;
    }
    public int mirrorDistance(int n) {
        int og = n;
        int rn = reverseDigit(n);
        return Math.abs(og - rn);
    }
}