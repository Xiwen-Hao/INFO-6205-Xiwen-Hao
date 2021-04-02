public class Q4 {
    public static void main(String[] args) {
        System.out.println("It should be 5: " + new Solution().getIndex(new int[] {2,4,4,4,6,7,7,7,8,9,9,9}, 7));
        System.out.println("It should be 1: " + new Solution().getIndex(new int[] {2,4,4,4,6,7,7,7,8,9,9,9}, 4));
        System.out.println("It should be 9: " + new Solution().getIndex(new int[] {2,4,4,4,6,7,7,7,8,9,9,9}, 9));
    }
}

class Solution {
    /**
     * the space complexity is O(1)
     * the time complexity is O(log n)
     *
     * @param nums a sorted array
     * @param x the target
     * @return the first occurrence of an integer x
     */
    public int getIndex(int[] nums, int x){
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > x) {
                r = mid - 1;
            } else if (nums[mid] < x) {
              l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}