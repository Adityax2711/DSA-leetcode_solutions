class Solution {
    public int findMin(int[] nums) {
        int minVal = nums[0]; 
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < minVal) {
                minVal = nums[i];
            }
        }
        return minVal;
    }
}