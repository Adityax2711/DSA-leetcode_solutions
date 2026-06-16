class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        
        // Replaced 'zero' and 'one' counts with a running prefix sum
        int prefixSum = 0; 
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); 

        for (int i = 0; i < n; i++) {
            // Update the running sum instead of zero/one counts
            prefixSum += nums[i];
            
            // Calculate the remainder instead of 'diff'
            int remainder = prefixSum % k;
            
            // If we've seen this remainder before...
            if (map.containsKey(remainder)) {
                // ...check if the subarray length is at least 2!
                if (i - map.get(remainder) >= 2) {
                    return true; // We found it, no need to keep searching!
                }
            } else {
                // Store the first time we see this remainder
                map.put(remainder, i);
            }
        }
        
        return false;
    }
}