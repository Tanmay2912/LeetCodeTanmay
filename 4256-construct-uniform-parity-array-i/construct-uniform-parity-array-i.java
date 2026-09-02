class Solution {
    public boolean checkifAllOddorEven(int[] nums1) {
        int countE = 0, countO = 0;
        for(int i = 0; i < nums1.length; i++) {
            if(nums1[i]%2 == 0) 
                countE++;
            else
                countO++;
        }
        if(countE == nums1.length || countO == nums1.length) 
            return true;
        return false;
    }
    public boolean uniformArray(int[] nums1) {
        if(checkifAllOddorEven(nums1))
            return true;
        return true;
    }
}