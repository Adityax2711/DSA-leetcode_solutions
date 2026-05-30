class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // Calculate the sum of the first window
        double currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }
        double maxSum = currentSum;
        // Slide the window from index k to the end of the array
        for (int i = k; i < nums.length; i++) {
            // Add the new element, remove the leftmost element of the previous window
            currentSum += nums[i] - nums[i - k];
            // Keep track of the maximum sum found so far
            maxSum = Math.max(maxSum, currentSum);
        }
        // The maximum average is the maximum sum divided by k
        return maxSum / k;
    }
}