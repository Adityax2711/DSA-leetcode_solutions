class Solution {
    public int totalWaviness(int num1, int num2) {
        int totalSum = 0;
        for (int i = num1; i <= num2; i++) {
            totalSum += getWaviness(i);
        }
        return totalSum;
    }
    private int getWaviness(int num) {
  
        if (num < 100) {
            return 0;
        }
        String s = Integer.toString(num);
        int count = 0;
 
        for (int i = 1; i < s.length() - 1; i++) {
            char curr = s.charAt(i);
            char left = s.charAt(i - 1);
            char right = s.charAt(i + 1);
            if (curr > left && curr > right) {
                count++;
            }
            else if (curr < left && curr < right) {
                count++;
            }
        }
        
        return count;
    }
}