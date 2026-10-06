class Solution {
    public int searchInsert(int[] nums, int target) {
        int left=0;
        int right = nums.length - 1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;
    }
}

//logic 
//create a solution and a public classs insert 
//create left value start with left start with zero 
// then go for the right and subtract the nums lenght
//also use the while condition and use the left left+(right-left)/2;
////use conditional statements and see if mid  value is equal the target 
//return tthe mid value is else is nums is greater the target 
//then left will add the mid+1
//else right mid-1;
//then correct it and return the left part 