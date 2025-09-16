class Solution {
    public int calculateGCD(int a, int b) {
        while(b != 0) {
           int rem = a%b;
           a = b;
           b = rem;
        }
        return a;
    }
    public int calculateLCM(int a, int b, int GCD) {
        return (a/GCD)*b;
    }
    public List<Integer> replaceNonCoprimes(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(nums[0]); 
        for(int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            while(!ans.isEmpty()) {
                int last = ans.get(ans.size()-1);
                int GCD = calculateGCD(last, curr);
                if(GCD > 1) {
                    curr = calculateLCM(last, curr, GCD);
                    ans.remove(ans.size()-1);
                }
                else {
                    break;
                }
            }
            ans.add(curr);
        }
        return ans;
    }
}