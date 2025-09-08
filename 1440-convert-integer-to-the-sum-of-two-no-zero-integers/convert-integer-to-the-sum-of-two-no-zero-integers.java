class Solution {
    // public boolean findZero(int i, int j) {
    //     int flag1 = 0, flag2 = 0;
    //     while(i > 0) {
    //         int rem = i%10;
    //         if(rem == 0) {
    //             flag1 = 1;
    //             break;
    //         }
    //         i = i/10;
    //     }
    //     while(j > 0) {
    //         int rem = j%10;
    //         if(rem == 0) {
    //             flag2 = 1;
    //             break;
    //         }
    //         j = j/10;
    //     }
    //     if(flag1 == 0 && flag2 == 0) {
    //         return true;
    //     }
    //     return false;
    // }
    public boolean findZero(int i) {
        while(i > 0) {
            int rem = i%10;
            if(rem == 0) {
                return false;
            }
            i = i/10;
        }
        return true;
    }
    public int[] getNoZeroIntegers(int n) {
        int ans[] = new int[2];
        // for(int i = 1; i < n; i++) {
        //     for(int j = i; j < n; j++) {
        //         if(i+j == n) {
        //             if(findZero(i, j)) {
        //                 ans[0] = i;
        //                 ans[1] = j;
        //                 break;
        //             }
        //         }
        //     }
        // }
        int low = 1, high = n-1;
        // if(low == high ) {
        //     ans[0] = low;
        //     ans[1] = high;
        //     return ans;
        // }
        while(low <= high) {
            if(!findZero(low)) {
                low++;
                continue;
            }
            if(!findZero(high)) {
                high--;
                continue;
            }
            if(low+high == n) {
                return new int[] {low, high};
                // ans[0] = low;
                // ans[1] = high;
                // break;
            }
            else if((low+high) > n) {
                high--;
            }
            else {
                low++;
            }
        }
        return new int[] {-1, -1};
    }
}