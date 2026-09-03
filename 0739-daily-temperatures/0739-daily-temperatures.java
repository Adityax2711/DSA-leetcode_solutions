class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        
        // The stack will store the INDICES of the temperatures
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            int currentTemp = temperatures[i];
            
            // While stack is not empty AND current day is warmer than the day at the top of the stack
            while (!stack.isEmpty() && currentTemp > temperatures[stack.peek()]) {
                int prevDay = stack.pop();
                // The number of days waited is the difference in indices
                answer[prevDay] = i - prevDay; 
            }
            
            // Push the current day's index onto the stack
            stack.push(i);
        }
        
        return answer;
    }
}