class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxBan = 0;
        for (int pile : piles) {
            maxBan = Math.max(maxBan, pile);
        }

        int l = 1;              // minimum speed
        int r = maxBan;         // maximum possible speed
        int ans = r;            // store result

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int hours = numHours(piles, mid);

            if (hours <= h) {
                ans = mid;      // possible answer, try smaller speed
                r = mid - 1;
            } else {
                l = mid + 1;    // too slow, need higher speed
            }
        }

        return ans;
    }

    private int numHours(int[] piles, int k) {
        int total = 0;
        for (int pile : piles) {
            total += Math.ceil((double) pile / k);
        }
        return total;
    }
}
