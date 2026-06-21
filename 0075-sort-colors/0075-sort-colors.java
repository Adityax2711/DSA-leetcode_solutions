class Solution {
    public void sortColors(int[] nums) {
        int low =0,i=0,high=nums.length-1;
        while(i<=high){
            if(nums[i]==0){
                int tmp=nums[i];
                nums[i]=nums[low];
                nums[low]=tmp;
                low++;
                i++;
            }else if(nums[i]==1){
                i++;
            }else{
                int tmp=nums[i];
                nums[i]=nums[high];
                nums[high]=tmp;
                high--;
            }
        }
    }
}