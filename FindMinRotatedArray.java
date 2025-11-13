public class FindMinRotatedArray {
    public static int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while (l <= r) {
            int mid = (l + r) / 2;

            // Case 1: If the array or the current segment is already sorted
            if (nums[l] <= nums[r]) {
                min = Math.min(min, nums[l]);
                break; // no need to continue, already sorted
            }

            // Case 2: Left half is sorted
            if (nums[l] <= nums[mid]) {
                min = Math.min(min, nums[l]); // leftmost is minimum in left sorted half
                l = mid + 1; // move to right half
            } 
            // Case 3: Right half is sorted
            else {
                min = Math.min(min, nums[mid]); // mid could be the smallest
                r = mid - 1; // move to left half
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 4, 5, 1, 2};
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int[] nums3 = {11, 13, 15, 17};
        int[] nums4 = {2, 3, 4, 5, 6, 1}; 

        System.out.println(findMin(nums1)); // Output: 1
        System.out.println(findMin(nums2)); // Output: 0
        System.out.println(findMin(nums3)); // Output: 11
        System.out.println(findMin(nums4)); // Output: 1
    }
}
