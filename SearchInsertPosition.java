public class SearchInsertPosition {

    // Function to find the insert position or exact index
    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = (l + r) / 2; // find middle index

            if (nums[mid] == target)
                return mid; // Target found

            if (target > nums[mid]) {
                l = mid + 1; // Search right half
            } else {
                r = mid - 1; // Search left half
            }
        }

        // When not found, 'l' is the correct insert position
        return l;
    }

    // Main method to test
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};

        int target1 = 5;
        int target2 = 2;
        int target3 = 7;
        int target4 = 0;

        System.out.println("Position of " + target1 + " = " + searchInsert(nums, target1)); // Output: 2
        System.out.println("Position of " + target2 + " = " + searchInsert(nums, target2)); // Output: 1
        System.out.println("Position of " + target3 + " = " + searchInsert(nums, target3)); // Output: 4
        System.out.println("Position of " + target4 + " = " + searchInsert(nums, target4)); // Output: 0
    }
}
