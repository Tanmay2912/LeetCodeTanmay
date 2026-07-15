/*class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        int mini=prices[0];
        for(int i=1; i< prices.length; i++) {
            int currProfit=prices[i]-mini;
            maxProfit=Math.max(currProfit, maxProfit);
            mini=Math.min(mini, prices[i]);
        }
        return maxProfit;
    }
}*/
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int mini = prices[0];
        for(int i = 0; i < prices.length; i++) {
            int currentprofit = prices[i] - mini;
            maxProfit = Math.max(currentprofit, maxProfit);
            mini = Math.min(mini, prices[i]);
        }
        return maxProfit;
    }
}