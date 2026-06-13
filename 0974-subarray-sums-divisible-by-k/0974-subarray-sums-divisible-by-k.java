class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();  
        map.put(0, 1);  
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = sum % k;
            if (remainder < 0) {
                remainder += k;
            }
             if (map.containsKey(remainder)) {
                res += map.get(remainder); 
            }
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        return res;
    }
}