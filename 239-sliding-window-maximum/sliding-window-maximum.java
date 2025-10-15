class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int i = 0, j = 0;
        Deque<Integer> dq = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        while(j < nums.length) {
            while(!dq.isEmpty() && dq.peekLast() < nums[j]) {
                dq.pollLast();
            }
            dq.offerLast(nums[j]);
            if(j-i+1 < k) {
                j++;
            }
            else if(j-i+1 == k) {
                ans.add(dq.peekFirst());
                if(dq.peekFirst() == nums[i]) {
                    dq.pollFirst();
                }
                i++;
                j++;
            }
        }
        int[] res = new int[ans.size()];
        for (int x = 0; x < ans.size(); x++) {
            res[x] = ans.get(x);
        }
        return res;
    }
}
