class Solution {
    public int maxAbsoluteSum(int[] nums){
        int currentMax=nums[0];
        int maxSum=nums[0];
        int currentMin=nums[0];
        int minSum=nums[0];
        for(int i=1;i<nums.length;i++){
            currentMax=Math.max(nums[i],
                                  currentMax+nums[i]);

            maxSum=Math.max(maxSum,currentMax);
            currentMin=Math.min(nums[i],
                                  currentMin+nums[i]);
            minSum=Math.min(minSum,currentMin);
        }
        return Math.max(maxSum,Math.abs(minSum));
    }
}




// Maximum Absolute Sum

// 👉 Run:

// Maximum Kadane
// Minimum Kadane

// because:

// absolute value cares about both
// large positive and large negative

// Final answer:

// max(maxSum, ∣minSum∣)

// One-Line Memory Trick

// “Find subarray farthest from zero.”

// So track:

// biggest positive sum
// biggest negative sum

// using:

// max Kadane
// min Kadane.