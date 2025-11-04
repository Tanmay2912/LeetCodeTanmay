class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] answer = new int[n - k + 1];     
        for (int i = 0; i <= n - k; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = i; j < i + k; j++) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            }
            List<int[]> freqList = new ArrayList<>();
            for (int key : map.keySet()) {
                freqList.add(new int[]{key, map.get(key)});
            }
            Collections.sort(freqList, (a, b) -> {
                if (b[1] == a[1]) return b[0] - a[0];
                return b[1] - a[1];
            });
            Set<Integer> keep = new HashSet<>();
            for (int p = 0; p < Math.min(x, freqList.size()); p++) {
                keep.add(freqList.get(p)[0]);
            }
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                if (keep.contains(nums[j])) sum += nums[j];
            }
            answer[i] = sum;
        }
        return answer;
    }
}
