class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int totalDrank = numBottles;
        int empty = numBottles;

        while (empty >= numExchange) {
            int newFull = empty / numExchange;  // number of new bottles
            totalDrank += newFull;
            empty = empty % numExchange + newFull; // leftover empty+new empty
        }

        return totalDrank;
    }
}
