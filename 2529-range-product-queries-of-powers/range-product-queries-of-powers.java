class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int[] powers = buildPowersArray(n);
        long[] prefixProd = buildPrefixProducts(powers);

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            long product = prefixProd[right];
            if (left > 0) {
                product = (product * modInverse(prefixProd[left - 1])) % MOD;
            }
            ans[i] = (int) product;
        }
        return ans;
    }

    private int[] buildPowersArray(int n) {
        int[] temp = new int[32];
        int count = 0;
        int power = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                temp[count++] = power;
            }
            power <<= 1;
            n >>= 1;
        }
        int[] powers = new int[count];
        System.arraycopy(temp, 0, powers, 0, count);
        return powers;
    }

    final int MOD = 1_000_000_007;
    private long[] buildPrefixProducts(int[] powers) {
        long[] prefixProd = new long[powers.length];
        prefixProd[0] = powers[0] % MOD;
        for (int i = 1; i < powers.length; i++) {
            prefixProd[i] = (prefixProd[i - 1] * powers[i]) % MOD;
        }
        return prefixProd;
    }

    private long modInverse(long x) {
        return modPow(x, MOD - 2);
    }

    private long modPow(long base, long exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }
}
