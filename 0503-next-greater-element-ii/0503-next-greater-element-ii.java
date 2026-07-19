class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        java.util.Arrays.fill(result, -1); 
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        
        for (int i = 0; i < 2 * n; i++) {
            int currentIdx = i % n;
            
            while (!stack.isEmpty() && nums[currentIdx] > nums[stack.peek()]) {
                int indexToUpdate = stack.pop();
                result[indexToUpdate] = nums[currentIdx];
            }
            
            if (i < n) {
                stack.push(i);
            }
        }
        
        return result;
    }
}