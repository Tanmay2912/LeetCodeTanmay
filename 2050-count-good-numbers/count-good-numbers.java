class Solution {
    static final int MOD = 1000000007;
    public int countGoodNumbers(long n) {
        long evenPosition = (n + 1) / 2;
        long oddPosition = n / 2;
        long evenWays = calPower(evenPosition, 5);
        long oddWays = calPower(oddPosition, 4);

        return (int) ((evenWays * oddWays) % MOD);
    }
    public long calPower(long number, long base) {
        long result = 1;
        base %= MOD;

        while(number > 0) {
            if(number % 2 == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            number /= 2;
        }
        return result;
    }
}