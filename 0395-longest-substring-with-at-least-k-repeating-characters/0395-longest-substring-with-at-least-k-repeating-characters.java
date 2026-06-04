class Solution {
    public int longestSubstring(String s, int k) {
        // Step 1: Base Case
        if (s == null || s.length() < k) {
            return 0;
        }
        
        // Step 2: Frequency Count Array
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        // Step 3: Loop to find the culprit character
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            
            // Agar kisi character ka count 0 se bada hai par k se kam hai
            if (count[currChar - 'a'] > 0 && count[currChar - 'a'] < k) {
                
                // Step 4: Divide into Left and Right substrings
                String leftSubstring = s.substring(0, i);
                String rightSubstring = s.substring(i + 1);
                
                // Dono par recursion call karo
                int leftLength = longestSubstring(leftSubstring, k);
                int rightLength = longestSubstring(rightSubstring, k);
                
                // Dono me se jo maximum ho return kar do
                return Math.max(leftLength, rightLength);
            }
        }
        return s.length();
    }
}