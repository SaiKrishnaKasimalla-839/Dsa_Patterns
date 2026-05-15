class Solution {

    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = nums[0];
        int currentMax = nums[0];
        int maxSum = nums[0];
        int currentMin = nums[0];
        int minSum = nums[0];
        for(int i=1;i<nums.length;i++) {
            totalSum+=nums[i];
            currentMax=Math.max(nums[i],
                                  currentMax+nums[i]);
            maxSum=Math.max(maxSum,currentMax);
            currentMin=Math.min(nums[i],
                                  currentMin+nums[i]);
            minSum=Math.min(minSum,currentMin);
        }
        if(maxSum<0){
            return maxSum;
        }
        return Math.max(maxSum,totalSum - minSum);
    }
}




// Maximum Sum Circular Subarray

// 👉 Answer has TWO possibilities:

// Normal maximum subarray
// Circular maximum subarray

// Circular means:

// “Take whole array and remove worst middle part.”

// So:

// Circular Max=totalSum−minSubarray

// Final answer:

// max(normalMax, totalSum−minSubarray)

// One-Line Memory Trick

// “Circular maximum = total sum minus minimum subarray.”