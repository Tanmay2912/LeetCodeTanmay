class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int ele=-1, cnt=0;

        for(int i=0;i<n;i++)
        {
            if(cnt==0)
            {
                ele=nums[i];
                cnt=cnt+1;
            }
            else if(nums[i]==ele)
            {
                cnt++;
            }
            else
            {
                cnt--;
            }
        }

        return ele;
    }
}