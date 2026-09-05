class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int maxLen = 0;
        int currentLen = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > threshold) {
                currentLen = 0;
            } else {
                if (currentLen > 0) {
                    if (nums[i] % 2 != nums[i - 1] % 2) {
                        currentLen++;
                    } else{
                        if (nums[i] % 2 == 0) {
                            currentLen = 1;
                        } else {
                            currentLen = 0;
                        }
                    }
                } else {
                    if (nums[i] % 2 == 0) {
                        currentLen = 1;
                    }
                }
            }
            maxLen = Math.max(maxLen, currentLen);
        }
        
        return maxLen;
    }
}