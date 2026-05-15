class Solution {
    public int maxSubArray(int[] nums){
        int currentSum=nums[0];
        int maxSum=nums[0];
        for(int i=1;i<nums.length;i++){
            //If Negative  Comes Currrent_Sum Is Updated and choose which  is maximum from nums[i] && currentSum+nums[i] 
            currentSum=Math.max(nums[i],currentSum+nums[i]);
            maxSum=Math.max(maxSum,currentSum);
        }
        return maxSum;
    }
}