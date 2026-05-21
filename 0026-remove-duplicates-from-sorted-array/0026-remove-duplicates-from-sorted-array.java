class Solution {
    public int removeDuplicates(int[] nums) {
        List<Integer>uniqueList=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(!uniqueList.contains(nums [i])){
                uniqueList.add(nums[i]);
            }
        }
        for(int i=0;i<uniqueList.size(); i++){
            nums[i] = uniqueList.get(i);
        }
        return uniqueList.size();
    }
}