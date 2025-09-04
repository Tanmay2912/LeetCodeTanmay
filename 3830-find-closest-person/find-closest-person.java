class Solution {
    public int findClosest(int x, int y, int z) {
        int disPerson1 = Math.abs(x - z); 
        int disPerson2 = Math.abs(y - z); 

        if (disPerson1 < disPerson2) {
            return 1; 
        } else if (disPerson2 < disPerson1) {
            return 2; 
        } else {
            return 0; 
        }
    }
}
