class Solution {

    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i+=2*k){
            int left=i;
            int right=Math.min(i+k-1,arr.length-1);
            while(left<right){
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return new String(arr);
    }
}




//Why we Use int right=Math.min(i+k-1,arr.length-1);


// Dangerous Situation

// Suppose:

// s = "abc"
// k = 4

// Indexes:

// 0 1 2
// a b c

// Now:

// right = i + k - 1

// would become:

// 0 + 4 - 1 = 3

// BUT:

// last valid index = 2

// Index 3 does not exist.

// This causes:

// ArrayIndexOutOfBoundsException

// So we use:

// Math.min(3, 2)

// Result:

// right = 2

// Now reverse safely from:

// 0 to 2

// which is:

// a b c

// After reverse:

// c b a
// Simple Meaning of This Line
// right = Math.min(i + k - 1, arr.length - 1)

// means:

// "Take the smaller valid index."

// Either:

// normal ending index (i+k-1)
// OR
// last array index (arr.length-1)

// So program never goes outside array boundary.
