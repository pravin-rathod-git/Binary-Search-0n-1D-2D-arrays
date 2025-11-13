public class RotationCount {
    
    // Function to find how many times the array has been rotated
    public static int findRotationCount(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            // Case 1: If array is already sorted
            if (nums[left] <= nums[right]) {
                return left;
            }

            int mid = (left + right) / 2;
            int next = (mid + 1) % n;
            int prev = (mid + n - 1) % n;

            // Case 2: Check if mid element is the minimum
            if (nums[mid] <= nums[next] && nums[mid] <= nums[prev]) {
                return mid;
            }

            // Case 3: Decide which half to search
            if (nums[mid] >= nums[left]) {
                // Left part sorted, so rotation is in right part
                left = mid + 1;
            } else {
                // Right part sorted, so rotation is in left part
                right = mid - 1;
            }
        }

        return 0; // Default (should not reach here)
    }

    // Main function
    public static void main(String[] args) {
        int[] nums = {5, 6, 1, 2, 3, 4};

        int rotationCount = findRotationCount(nums);
        System.out.println("The array has been rotated " + rotationCount + " times.");
    }
}
