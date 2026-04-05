class Solution {
    public boolean judgeCircle(String moves) {
        char[] arr = moves.toCharArray();
        int vertical = 0;
        int horizontal = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 'U') vertical += 1;
            if(arr[i] == 'D') vertical -= 1;
            if(arr[i] == 'R') horizontal += 1;
            if(arr[i] == 'L') horizontal -= 1;
        }
        return vertical == 0 && horizontal == 0;
    }
}