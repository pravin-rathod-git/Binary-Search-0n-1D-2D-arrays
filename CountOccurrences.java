public class CountOccurrences {

    // Function to find first occurrence of target
    public static int findFirst(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int first = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                first = mid;   // store index
                r = mid - 1;   // move left for first occurrence
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return first;
    }

    // Function to find last occurrence of target
    public static int findLast(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int last = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                last = mid;    // store index
                l = mid + 1;   // move right for last occurrence
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return last;
    }

    // Function to count occurrences
    public static int countOccurrences(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        if (first == -1 || last == -1) return 0; // not found
        return last - first + 1;
    }

    // Main function for testing
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;

        int count = countOccurrences(nums, target);
        System.out.println("Count of " + target + " = " + count);
    }
}
