public class BinarySearch {

    // Binary Search function
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = (l + r) / 2; // Find the middle index

            // If element is found
            if (nums[mid] == target) {
                return mid;
            }

            // If target is greater, ignore the left half
            if (target > nums[mid]) {
                l = mid + 1;
            } 
            // If target is smaller, ignore the right half
            else {
                r = mid - 1;
            }
        }

        // If not found, return -1
        return -1;
    }

    // Main function to test the search
    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 8, 10, 12, 14};
        int target = 10;

        int result = search(nums, target);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}




