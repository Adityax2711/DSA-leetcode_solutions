class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int maxVal = nums[0];
        int minVal = nums[0];
        
        // Find the absolute max and min in the array
        for (int num : nums) {
            if (num > maxVal) maxVal = num;
            if (num < minVal) minVal = num;
        }
        
        // The best subarray is the one containing the global max and min
        long diff = (long) maxVal - minVal;
        
        // You can pick this exact same subarray k times
        return diff * k;
    }
}