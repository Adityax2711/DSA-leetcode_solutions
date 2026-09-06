 class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        
        // Loop through every cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If the first letter matches, start the search from here
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false; // Word not found anywhere
    }

    private boolean dfs(char[][] board, int i, int j, int index, String word) {
        // Base case: If we have matched all characters in the word
        if (index == word.length()) {
            return true;
        }
        
        // Check out of bounds OR if the current character doesn't match
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }
        
        // Temporarily mark the current cell as visited so we don't use it again
        char temp = board[i][j];
        board[i][j] = '*'; 
        
        // Recursively check all 4 directions (Up, Down, Left, Right)
        boolean found = dfs(board, i + 1, j, index + 1, word) || 
                        dfs(board, i - 1, j, index + 1, word) || 
                        dfs(board, i, j + 1, index + 1, word) || 
                        dfs(board, i, j - 1, index + 1, word);
                        
        // Backtrack: Restore the original character so other paths can use it
        board[i][j] = temp;
        
        return found;
    }
}