public class RotatedBinarySearch {

    public static int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            // Case 1: Target found
            if (nums[mid] == target) 
                return mid;

            // Case 2: Left part is sorted
            if (nums[mid] >= nums[l]) {
                if (target >= nums[l] && target < nums[mid]) {
                    // Target lies in left sorted half
                    r = mid - 1;
                } else {
                    // Target lies in right half
                    l = mid + 1;
                }
            } 
            // Case 3: Right part is sorted
            else {
                if (target > nums[mid] && target <= nums[r]) {
                    // Target lies in right sorted half
                    l = mid + 1;
                } else {
                    // Target lies in left half
                    r = mid - 1;
                }
            }
        }

        // Target not found
        return -1;
    }

    // Main function for testing
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        int result = search(nums, target);
        System.out.println("Index of target = " + result);
    }
}
