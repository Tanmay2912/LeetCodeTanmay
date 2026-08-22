class Solution {
    public boolean checkDivisibility(int n) {
        int og = n;
        int sum = 0;
        int prod = 1;
        while(n > 0) {
            int rem = n % 10;
            sum += rem;
            prod *= rem;
            n = n / 10;
        }
        int div = sum + prod;
        if(og % div == 0) {
            return true;
        }
        return false;
    }
}
