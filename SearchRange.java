public class SearchRange {

    public static int[] searchRange(int[] nums, int target) {
        int[] occurence = {-1, -1};

        // Find first occurrence
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                occurence[0] = mid; // store index
                r = mid - 1;        // search left side
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        // Find last occurrence
        l = 0; 
        r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                occurence[1] = mid; // store index
                l = mid + 1;        // search right side
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return occurence;
    }

    // Main method to test
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        int[] result = searchRange(nums, target);
        System.out.println("First occurrence = " + result[0]);
        System.out.println("Last occurrence = " + result[1]);
    }
}
