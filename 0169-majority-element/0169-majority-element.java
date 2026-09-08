class Solution {
    public int majorityElement(int[] nums) {
        int student =0;
        int count=0;
        for(int num : nums){
            if(count==0){
                student=num;
            }
            count+=(num==student) ?1:-1;
        }
        return student ;
    }
}