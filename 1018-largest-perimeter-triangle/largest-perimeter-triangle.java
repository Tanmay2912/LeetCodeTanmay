/*class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int k = nums.length-3;
        while(k >= 0) {
            if(nums[k]+nums[k+1] > nums[k+2]) {
                return nums[k]+nums[k+1]+nums[k+2];
            }
            k--;
        }
        return 0;
    }
}*/
class Solution {
    public int largestPerimeter(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            pq.add(num);
        }
        while (pq.size() >= 3) {
            int a = pq.poll(); 
            int b = pq.poll(); 
            int c = pq.poll(); 
            if (b + c > a) {
                return a + b + c; 
            } 
            pq.add(b);
            pq.add(c);
        }
        return 0; 
    }
}
