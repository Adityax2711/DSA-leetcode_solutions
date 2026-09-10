class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int totalNumbers = n * n; // The maximum number we should have
        
        // This boolean array is our "checklist". 
        // It defaults to 'false' (meaning unchecked).
        boolean[] seen = new boolean[totalNumbers + 1];
        
        int repeated = -1;
        int missing = -1;
        
        // STEP 1: Go through every number in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int currentNumber = grid[i][j];
                
                // Have we already checked this number off?
                if (seen[currentNumber] == true) {
                    repeated = currentNumber; // We found the duplicate!
                } else {
                    seen[currentNumber] = true; // Check it off the list
                }
            }
        }
        
        // STEP 2: Find the missing number
        // Go through our checklist from 1 to totalNumbers
        for (int i = 1; i <= totalNumbers; i++) {
            // Which number was never checked off?
            if (seen[i] == false) {
                missing = i; // We found the missing one!
                break;       // Stop searching
            }
        }
        
        // Return them in the order LeetCode asked for: [repeated, missing]
        return new int[]{repeated, missing};
    }
}