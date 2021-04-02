public class Q3 {
    public static void main(String[] args) {
        System.out.println("It should be 3: " + new Solution().getMaxConsecutiveOnes(new int[]{0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0}));
        System.out.println("It should be 0: " + new Solution().getMaxConsecutiveOnes(new int[]{0, 0, 0, 0, 0}));
        System.out.println("It should be 5: " + new Solution().getMaxConsecutiveOnes(new int[]{1, 1, 1, 1, 1}));
    }
}

class Solution {
    /**
     * the space complexity is O(1)
     * the time complexity is O(n)
     *
     * @param nums the binary array
     * @return the maximum number of consecutive 1s in this array
     */
    public int getMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                if (count > result) {
                    result = count;
                }
            } else {
                count = 0;
            }
        }
        return result;
    }
}