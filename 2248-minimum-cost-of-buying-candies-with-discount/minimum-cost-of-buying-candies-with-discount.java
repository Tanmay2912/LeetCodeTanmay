// This fails because here for the length 2 array first element is indexed 0 and 0%3==0 hence that element is not added  in the total amount for that we need keep a count indexed 1
/*class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int Mcost = 0;
        for(int i = cost.length-1; i >= 0; i--) {
            if(i%3 == 0) {
                continue;
            }
            Mcost += cost[i];
        }
        return Mcost;
    }
}*/
class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int Mcost = 0;
        for(int i = cost.length-1, count = 1; i >= 0; i--, count++) {
            if(count%3 == 0) {
                continue;
            }
            Mcost += cost[i];
        }
        return Mcost;
    }
}