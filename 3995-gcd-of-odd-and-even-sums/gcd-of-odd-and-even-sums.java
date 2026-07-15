class Solution {
    public int gcd(int a, int b) {
        while(b != 0) {
            int rem = a%b;
            a = b;
            b = rem;
        }
        return a;
    }
    public int gcdOfOddEvenSums(int n) {
        int esum = 0, osum = 0;
        for(int i = 1; i <= n; i++) {
            osum += (2*i-1);
            esum += (2*i);
        }
        System.out.println(esum);
        return gcd(osum, esum);
    }
}