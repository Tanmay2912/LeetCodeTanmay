/*class Solution {
    public boolean checkPrime(int x) {
        int cnt = 0;
        for(int i = 1; i < x; i++) {
            if(x%i == 0) {
                cnt++;
            }
        }
        return cnt == 1;
    }
    public int countPrimes(int n) {
        int numcnt = 0;
        for(int i = 1; i < n; i++) {
            if(checkPrime(i)) {
                numcnt++;
            }
        }
        return numcnt;
    }
}*/
// 1 and 0 are not prime numbers 
class Solution {
    public int countPrimes(int n) {

        if (n <= 2) return 0;

        boolean[] isPrime = new boolean[n];

        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;

        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }

        return count;
    }
}