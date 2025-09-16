class Solution {
    public int countSetBit(int num) {
        int cnt = 0;
        while(num > 0) {
            int bit = num % 2;
            if(bit == 1) {
                cnt++;
            }
            num = num / 2; 
        }
        return cnt;
    }
    public int minBitFlips(int start, int goal) {
        int ans = start ^ goal;
        int cnt = 0;
        for(int i = 0; i < 31; i++) {
            if ((ans & (1 << i)) != 0) {
                cnt += 1;
            }
        }
        return countSetBit(ans);
    }
}