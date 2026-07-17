class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Integer ele1=0;
        Integer ele2=0;
        int count1=0;
        int count2=0;

        for (int num : nums) {
            if (num==ele1) {
                count1++;
            } else if (num==ele2) {
                count2++;
            } else if (count1==0) {
                ele1=num;
                count1++;
            } else if (count2==0) {
                ele2=num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1=0;
        count2=0;

        for (int num : nums) {
            if (num==ele1) {
                count1++;
            } else if (num==ele2) {
                count2++;
            }
        }

        List<Integer> res=new ArrayList<>();
        int n=nums.length;

        if (count1 > n/3) {
            res.add(ele1);
        }
        if (count2 > n/3) {
            res.add(ele2);
        }

        return res;        
    }
}