// class Solution {
//     public int[] closestPrimes(int left, int right) {
//         boolean isPrime[] = new boolean[n+1];
//         for(int i = 2; i <= n; i++) {
//             isPrime[i] = true;
//         }
//         for(int i = 2; i <=n; i++) {
//             if(isPrime[i]) {
//                 for(int j = i*i; j <= n; j += i) {
//                     isPrime[j] = false;
//                 }
//             }
//         }
//         ArrayList<Integer> prime = new ArrayList<Integer>();
//         for(int i = 0; i <= n; i++) {
//             if(isPrime) 
//                 prime.add(i);
//         }
//         Collection.sort(prime);
//         int ans = prime.get(0) - prime.get(1);
//         return ans;
//     }
// }
class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean isPrime[] = new boolean[right + 1];
        for (int i = 2; i <= right; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= right; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        ArrayList<Integer> prime = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                prime.add(i);
            }
        }
        if (prime.size() < 2) {
            return new int[]{-1, -1};
        }
        int minDiff = Integer.MAX_VALUE;
        int[] ans = new int[2];
        for (int i = 1; i < prime.size(); i++) {
            int diff = prime.get(i) - prime.get(i - 1);
            if (diff < minDiff) {
                minDiff = diff;
                ans[0] = prime.get(i - 1);
                ans[1] = prime.get(i);
            }
        }
        return ans;
    }
}