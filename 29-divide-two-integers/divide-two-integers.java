class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) 
            return Integer.MAX_VALUE;
        if (dividend == divisor) 
            return 1;
        boolean isPositive = true;
        if (dividend >= 0 && divisor < 0) 
            isPositive = false;
        else if (dividend < 0 && divisor > 0)
            isPositive = false;
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        long ans = 0;   
        while (n >= d) {
            int count = 0;
            while (n >= (d << (count + 1))) {
                count++;
            }
            ans += (1L << count);      
            n -= d * (1L << count);    
        }
        if (ans > Integer.MAX_VALUE)  
            return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        return isPositive ? (int) ans : (int) -ans;  
    }    
}
