import java.util.Arrays;

class Solution {
    // 5D Memoization table to store states: 
    // [digit_position][last_digit][second_last_digit][is_tight][has_started]
    private long[][][][][] dp; 

    public long totalWaviness(long num1, long num2) {
        // Standard Digit DP range property: f(num2) - f(num1 - 1)
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long num) {
        if (num < 100) return 0;
        
        String s = Long.toString(num);
        int n = s.length();
        
        // 11 is used as a placeholder state for 'no digit placed yet'
        dp = new long[n][11][11][2][2];
        for (long[][][][] d1 : dp) {
            for (long[][][] d2 : d1) {
                for (long[][] d3 : d2) {
                    for (long[] d4 : d3) {
                        Arrays.fill(d4, -1);
                    }
                }
            }
        }
        
        return backtrack(s, 0, 10, 10, 1, 0);
    }

    private long backtrack(String s, int pos, int last, int secondLast, int tight, int isStarted) {
        // Base Case: If we've processed all positions, no more waves can be formed
        if (pos == s.length()) {
            return 0; 
        }
        
        // Return cached result if already computed
        if (dp[pos][last][secondLast][tight][isStarted] != -1) {
            return dp[pos][last][secondLast][tight][isStarted];
        }

        int limit = (tight == 1) ? (s.charAt(pos) - '0') : 9;
        long res = 0;

        for (int digit = 0; digit <= limit; digit++) {
            int nextTight = (tight == 1 && digit == limit) ? 1 : 0;
            int nextStarted = (isStarted == 1 || digit > 0) ? 1 : 0;

            int wavinessContribution = 0;
            // A wave happens if the 'last' digit forms a valid peak or valley
            if (isStarted == 1 && secondLast != 10 && last != 10) {
                if ((last > secondLast && last > digit) || (last < secondLast && last < digit)) {
                    wavinessContribution = 1;
                }
            }

            // If a wave is formed at this step, it contributes to all valid numbers formed ahead
            long combinationsAhead = countCombinations(s, pos + 1, nextTight, nextStarted);
            
            res += (wavinessContribution * combinationsAhead) 
                   + backtrack(s, pos + 1, (nextStarted == 1) ? digit : 10, last, nextTight, nextStarted);
        }

        return dp[pos][last][secondLast][tight][isStarted] = res;
    }

    // Helper method to count how many suffix combinations can be formed from the current state
    private long countCombinations(String s, int pos, int tight, int isStarted) {
        if (pos == s.length()) return isStarted; 
        
        if (tight == 0) {
            // Optimization: If not tight, any combination of remaining digits is valid
            return (long) Math.pow(10, s.length() - pos);
        }

        long count = 0;
        int limit = s.charAt(pos) - '0';
        
        for (int digit = 0; digit <= limit; digit++) {
            int nextTight = (tight == 1 && digit == limit) ? 1 : 0;
            int nextStarted = (isStarted == 1 || digit > 0) ? 1 : 0;
            count += countCombinations(s, pos + 1, nextTight, nextStarted);
        }
        return count;
    }
}