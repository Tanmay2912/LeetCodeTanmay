class Solution {
    public static void merge(int nums[], int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low, right = mid+1;

        while (left <= mid && right <= high) {
            if(nums[left] <= nums[right]) {
                temp.add(nums[left]);
                left ++;
            }
            else {
                temp.add(nums[right]);
                right ++;
            }
        }

        while (left <= mid) {
            temp.add(nums[left]);
            left ++;
        }
        while (right <= high) {
            temp.add(nums[right]);
            right ++;
        }

        for(int i = low; i <= high; i ++) {
            nums[i] = temp.get(i - low);
        }
    }
    public static int countReversePair(int nums[], int low, int mid, int high) {
        int right = mid + 1;
        int cnt = 0;
        for(int i = low; i <= mid; i++) {
            while(right <= high && nums[i] > (long) 2 * nums[right]) {
                right ++;
            }
            cnt += (right - (mid + 1));
        }
        return cnt;
    }
    public static int mergeSortHelper(int nums[], int low, int high) {
        if(low >= high) {
            return 0;
        }
        int mid = (low + high) / 2;
        int cnt = 0;

        cnt += mergeSortHelper(nums, low, mid);
        cnt += mergeSortHelper(nums, mid+1, high);
        cnt += countReversePair(nums, low, mid, high);
        merge(nums, low, mid, high);

        return cnt;
    }
    public int reversePairs(int[] nums) {
        int n = nums.length;
        return mergeSortHelper(nums, 0, n - 1);
    }
}
