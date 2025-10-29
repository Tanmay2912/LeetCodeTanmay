class Solution {
    public int smallestNumber(int n) {
        ArrayList<Integer> bits = new ArrayList<>();
        int og = n;
        while(n != 0) {
            bits.add(n%2);
            n /= 2;
        }
        StringBuilder sb = new StringBuilder();
        for(int bit : bits) {
            if(bit == 0) {
                bit = 1;
            }
            sb.append(bit);
        }
        String binary = sb.toString();
        return Integer.parseInt(binary, 2);
    }
}