class Solution {

    public String reverseWords(String s) {

        char[] arr = s.toCharArray();

        int i = 0;

        while(i < arr.length) {

            int left = i;

            while(i < arr.length && arr[i] != ' ') {
                i++;
            }

            int right = i - 1;

            while(left < right) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
            i++;
        }

        return new String(arr);
    }
}