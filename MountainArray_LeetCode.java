# 🚀 Today's LeetCode Revision Notes

Problems Solved Today:

1. ["Valid Mountain Array","LeetCode problem"]
2. ["Peak Index in a Mountain Array","LeetCode problem"]
3. ["Find Peak Element","LeetCode problem"]

---

# ⛰️ 1. Valid Mountain Array

---

# 📌 Problem Statement

Check whether array forms a valid mountain.

A mountain array:

✅ First increases

✅ Reaches peak

✅ Then decreases

---

# 🌄 Example

```text
[1,3,5,7,4,2]
```

Visualization:

```text
        7
      /   \
    5       4
  3           2
1
```

---

# ✅ Code

```java
class Solution {

    public boolean validMountainArray(int[] arr) {

        int n = arr.length;

        if(n < 3){
            return false;
        }

        int i = 0;

        // climbing
        while(i < n - 1 && arr[i] < arr[i + 1]){
            i++;
        }

        // peak check
        if(i == 0 || i == n - 1){
            return false;
        }

        // descending
        while(i < n - 1 && arr[i] > arr[i + 1]){
            i++;
        }

        return i == n - 1;
    }
}

---

# 🔥 Dry Run — Every Line

Array:

```text
[1,3,5,7,4,2]
```

---

# STEP 1

```java
int n = arr.length;
```

Stores:

```text
n = 6
```

---

# STEP 2

```java
if(n < 3)
```

Mountain needs:

```text
minimum 3 elements
```

Here:

```text
6 < 3 → false
```

Continue.

---

# STEP 3

```java
int i = 0;
```

Starting pointer.

Current:

```text
i = 0
```

---

# STEP 4 — Climbing

```java
while(arr[i] < arr[i+1])
```

Check:

```text
1 < 3 → true
```

Move:

```java
i++;
```

Now:

```text
i = 1
```

Again:

```text
3 < 5 → true
```

Move:

```text
i = 2
```

Again:

```text
5 < 7 → true
```

Move:

```text
i = 3
```

Again:

```text
7 < 4 → false
```

Loop stops.

Peak:

```text
7
```

---

# STEP 5 — Peak Check

```java
if(i == 0 || i == n-1)
```

Why?

Peak cannot be:

* first element
* last element

Here:

```text
i = 3
```

So:

```text
false
```

Continue.

---

# STEP 6 — Descending

```java
while(arr[i] > arr[i+1])
```

Check:

```text
7 > 4 → true
```

Move:

```java
i++;
```

Now:

```text
i = 4
```

Again:

```text
4 > 2 → true
```

Move:

```text
i = 5
```

Loop stops.

---

# STEP 7

```java
return i == n-1;
```

Check:

```text
5 == 5 → true
```

✅ Valid Mountain Array.

---

# ⏱️ Time Complexity

```text
O(n)
```

---

# ⛰️ 2. Peak Index in a Mountain Array

---

# 📌 Goal

Find peak element index.

---

# 🌄 Example

```text
[1,3,5,7,4,2]
```

Peak:

```text
7
```

Index:

```text
3
```

---

# ✅ Code

```java
class Solution {

    public int peakIndexInMountainArray(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while(left < right){

            int mid = left + (right - left) / 2;

            if(arr[mid] < arr[mid + 1]){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }

        return left;
    }
}
```

---

# 🔥 Dry Run

Array:

```text
[1,3,5,7,4,2]
```

---

# STEP 1

```java
left = 0
right = 5
```

---

# STEP 2

```java
mid = (0 + 5)/2
```

```text
mid = 2
```

Current:

```text
arr[2] = 5
arr[3] = 7
```

Check:

```text
5 < 7 → true
```

Means:

👉 Still climbing mountain ⛰️

Move right:

```java
left = mid + 1;
```

Now:

```text
left = 3
```

---

# STEP 3

Now:

```text
left = 3
right = 5
```

Find mid:

```text
mid = 4
```

Current:

```text
arr[4] = 4
arr[5] = 2
```

Check:

```text
4 < 2 → false
```

Means:

👉 Descending side ⬇️

Move left:

```java
right = mid;
```

Now:

```text
right = 4
```

---

# STEP 4

Now:

```text
left = 3
right = 4
```

Find mid:

```text
mid = 3
```

Current:

```text
arr[3] = 7
arr[4] = 4
```

Check:

```text
7 < 4 → false
```

Move:

```java
right = mid;
```

Now:

```text
right = 3
```

---

# STEP 5

Now:

```text
left = 3
right = 3
```

Loop stops.

Return:

```java
return left;
```

Answer:

```text
3
```

---

# ⏱️ Time Complexity

```text
O(log n)
```

---

# ⛰️ 3. Find Peak Element

---

# 📌 Goal

Find any peak element.

Peak means:

```text
nums[i] > nums[i-1]
AND
nums[i] > nums[i+1]
```

---

# 🌄 Example

```text
[1,2,1,3,5,6,4]
```

Possible peaks:

```text
2 or 6
```

---

# ✅ Code

//java

class Solution {

    public int findPeakElement(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while(left < right){

            int mid = left + (right - left) / 2;

            if(nums[mid] < nums[mid + 1]){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }

        return left;
    }
}


---

# 🔥 Main Logic

If:

```text
nums[mid] < nums[mid+1]
```

👉 Peak exists RIGHT side.

If:

```text
nums[mid] > nums[mid+1]
```

👉 Peak exists LEFT including mid.

---

# ⏱️ Time Complexity

```text
O(log n)
```
