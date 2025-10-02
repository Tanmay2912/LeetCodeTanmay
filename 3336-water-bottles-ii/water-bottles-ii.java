class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int totalDrank = 0;
        int empty = 0;
        totalDrank += numBottles;
        empty += numBottles;
        numBottles = 0;
        while(empty >= numExchange) {
            empty -= numExchange;
            numExchange += 1;
            numBottles = 1;
            totalDrank += numBottles;
            empty += numBottles;
            numBottles = 0;
        }
        return totalDrank;
    }
}