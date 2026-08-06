class Solution {
    public int digitProd(int n) {
        int prod = 1;
        while(n != 0) {
            int rem = n%10;
            prod *= rem;
            n = n/10;
        }
        return prod;
    }
    public int smallestNumber(int n, int t) {
        for(int i = 0; i <= 10; i++) {
            int prod = digitProd(n+i);
            if(prod % t == 0) {
                return n+i;
            }
        }
        return -1;
    }
}