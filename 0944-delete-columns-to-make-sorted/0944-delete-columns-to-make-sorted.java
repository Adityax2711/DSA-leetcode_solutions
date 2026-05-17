class Solution {
    public int minDeletionSize(String[] strs) {
        int deletions = 0;
        int rowCount = strs.length;
        int colCount = strs[0].length();
        for (int col = 0; col < colCount; col++) {
            for (int row = 1; row < rowCount; row++) {
                if (strs[row].charAt(col) < strs[row - 1].charAt(col)) {
                    deletions++; 
                    break;      
                }
            }
        }
        return deletions;
    }
}