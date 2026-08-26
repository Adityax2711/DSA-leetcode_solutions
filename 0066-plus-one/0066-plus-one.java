class Solution {
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }
        int[]newDigits=new int[digits.length+1];
        newDigits[0]=1;
        return newDigits;
    }
}

// 1. Create a loop starting from i = digits.length - 1 down to i >= 0, doing i--
// 2. Check if digits[i] < 9:
//      - If true, just add 1 to digits[i] and return the digits array. We are done!
// 3. If digits[i] is NOT < 9 (meaning it's 9):
//      - Set digits[i] = 0 and let the loop continue to the next digit.
// 4. If the loop finishes completely without returning:
//      - It means all digits were 9s. Create a new array of size digits.length + 1.
//      - Set the first element of the new array to 1 and return it.