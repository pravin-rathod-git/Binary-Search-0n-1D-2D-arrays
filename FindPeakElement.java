class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;

        while (l < r) { // ✅ safer boundary
            int mid = (l + r) / 2;

            // ✅ Compare with next element instead of previous
            if (nums[mid] < nums[mid + 1]) {
                l = mid + 1; // Peak is on the right side
            } else {
                r = mid; // Peak is at mid or on the left side
            }
        }

        return l; // ✅ l == r -> index of peak element
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3, 1};
        int peakIndex = sol.findPeakElement(nums);
        System.out.println("Peak index: " + peakIndex);
        System.out.println("Peak element: " + nums[peakIndex]);
    }
}
