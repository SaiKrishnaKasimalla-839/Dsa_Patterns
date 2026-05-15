class Solution {
    public int maxProduct(int[] nums) {

        int left = 0;
        int right=nums.length-1;
        int left_product=1;
        int right_product=1;

        int maxProduct= nums[0];
//just traverse from left and right ..for left_product=currrent_element*left_product and same for right_product
//and set the maximum from them....that's it....
        for(int i=0;i<nums.length; i++) {

            left_product *= nums[left];
            right_product *= nums[right];
            maxProduct = Math.max(maxProduct,
                          Math.max(left_product, right_product));
            if(left_product == 0)
                left_product = 1;
            if(right_product == 0)
                right_product = 1;
            left++;
            right--;
        }
        return maxProduct;
    }
}