class Solution {
    public String removeDuplicates(String s) {
        StringBuilder stack = new StringBuilder();
        for (char c : s.toCharArray()) {
            int currentLength=stack.length();
            if(currentLength >0&& stack.charAt(currentLength-1)==c){
                stack.deleteCharAt(currentLength-1);
            }else{
                stack.append(c);
            }
        }
        return stack.toString();
    }
}