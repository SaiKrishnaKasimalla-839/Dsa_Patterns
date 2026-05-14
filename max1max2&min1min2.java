# LeetCode Revision Sheet 🚀

## Topic: Tracking Maximums & Minimums in One Traversal

---

# 1. Maximum Product of Two Elements in an Array (LeetCode 1464)

## Problem Idea

We need:

```text
(max1 - 1) * (max2 - 1)
```

So we only need:

* largest element
* second largest element

---

# Java Code with Full Dry Run Comments

```java
class Solution {

    public int maxProduct(int[] nums) {

        // max1 stores largest element
        int max1 = 0;

        // max2 stores second largest element
        int max2 = 0;

        // Traverse entire array
        for (int i = 0; i < nums.length; i++) {

            // If current number is greater than max1
            if (nums[i] > max1) {

                // Old max1 becomes second largest
                max2 = max1;

                // Current element becomes largest
                max1 = nums[i];
            }

            // If current element is not larger than max1
            // but larger than max2
            else if (nums[i] > max2) {

                // Update second largest
                max2 = nums[i];
            }
        }

        // Return required formula
        return (max1 - 1) * (max2 - 1);
    }
}
```

---

# Dry Run

## Input

```text
[3,4,5,2]
```

---

## Initial State

| Variable | Value |
| -------- | ----- |
| max1     | 0     |
| max2     | 0     |

---

## Iteration 1

### Current Element

```text
3
```

Condition:

```text
3 > 0
```

True.

So:

```text
max2 = max1 = 0
max1 = 3
```

| max1 | max2 |
| ---- | ---- |
| 3    | 0    |

---

## Iteration 2

### Current Element

```text
4
```

Condition:

```text
4 > 3
```

True.

So:

```text
max2 = 3
max1 = 4
```

| max1 | max2 |
| ---- | ---- |
| 4    | 3    |

---

## Iteration 3

### Current Element

```text
5
```

Condition:

```text
5 > 4
```

True.

So:

```text
max2 = 4
max1 = 5
```

| max1 | max2 |
| ---- | ---- |
| 5    | 4    |

---

## Iteration 4

### Current Element

```text
2
```

Condition:

```text
2 > 5
```

False.

Next condition:

```text
2 > 4
```

False.

No changes.

| max1 | max2 |
| ---- | ---- |
| 5    | 4    |

---

# Final Calculation

```text
(5 - 1) * (4 - 1)
= 4 * 3
= 12
```

---

# Complexity

| Type  | Complexity |
| ----- | ---------- |
| Time  | O(n)       |
| Space | O(1)       |

---

---

# 2. Maximum Product Difference Between Two Pairs (LeetCode 1913)

## Problem Formula

```text
(max1 * max2) - (min1 * min2)
```

We need:

* largest element
* second largest element
* smallest element
* second smallest element

---

# Java Code with Full Dry Run Comments

```java
class Solution {

    public int maxProductDifference(int[] nums) {

        // Largest number
        int max1 = 0;

        // Second largest number
        int max2 = 0;

        // Smallest number
        int min1 = Integer.MAX_VALUE;

        // Second smallest number
        int min2 = Integer.MAX_VALUE;

        // Traverse array
        for (int num : nums) {

            // -------- Largest Logic --------

            // If current element becomes largest
            if (num > max1) {

                // Old largest becomes second largest
                max2 = max1;

                // Update largest
                max1 = num;
            }

            // If current is not largest
            // but larger than second largest
            else if (num > max2) {

                // Update second largest
                max2 = num;
            }

            // -------- Smallest Logic --------

            // If current element becomes smallest
            if (num < min1) {

                // Old smallest becomes second smallest
                min2 = min1;

                // Update smallest
                min1 = num;
            }

            // If current is not smallest
            // but smaller than second smallest
            else if (num < min2) {

                // Update second smallest
                min2 = num;
            }
        }

        // Return final formula
        return (max1 * max2) - (min1 * min2);
    }
}
```

---

# Dry Run

## Input

```text
[5,6,2,7,4]
```

---

# Initial Values

| Variable | Value    |
| -------- | -------- |
| max1     | 0        |
| max2     | 0        |
| min1     | Infinity |
| min2     | Infinity |

---

# Iteration 1

### Current Element

```text
5
```

Largest update:

```text
max2 = 0
max1 = 5
```

Smallest update:

```text
min2 = Infinity
min1 = 5
```

| max1 | max2 | min1 | min2     |
| ---- | ---- | ---- | -------- |
| 5    | 0    | 5    | Infinity |

---

# Iteration 2

### Current Element

```text
6
```

Largest update:

```text
max2 = 5
max1 = 6
```

Smallest unchanged.

| max1 | max2 | min1 | min2     |
| ---- | ---- | ---- | -------- |
| 6    | 5    | 5    | Infinity |

---

# Iteration 3

### Current Element

```text
2
```

Largest unchanged.

Smallest update:

```text
min2 = 5
min1 = 2
```

| max1 | max2 | min1 | min2 |
| ---- | ---- | ---- | ---- |
| 6    | 5    | 2    | 5    |

---

# Iteration 4

### Current Element

```text
7
```

Largest update:

```text
max2 = 6
max1 = 7
```

Smallest unchanged.

| max1 | max2 | min1 | min2 |
| ---- | ---- | ---- | ---- |
| 7    | 6    | 2    | 5    |

---

# Iteration 5

### Current Element

```text
4
```

Largest unchanged.

Smallest update:

```text
4 < 5
```

So:

```text
min2 = 4
```

| max1 | max2 | min1 | min2 |
| ---- | ---- | ---- | ---- |
| 7    | 6    | 2    | 4    |

---

# Final Formula

```text
(7 * 6) - (2 * 4)
= 42 - 8
= 34
```

---

# Complexity

| Type  | Complexity |
| ----- | ---------- |
| Time  | O(n)       |
| Space | O(1)       |

---

# Important Interview Pattern Learned

## Track Extremes While Traversing

Instead of:

* sorting
* nested loops
* checking every pair

Learn:

```text
Maintain maximums and minimums dynamically
```

This pattern is very important in:

* arrays
* heaps
* greedy problems
* stock problems
* optimization questions
* leaderboard systems

---

# Related Problems for Practice

1. Third Maximum Number (LeetCode 414)
2. Largest Number At Least Twice of Others (LeetCode 747)
3. Maximum Product of Three Numbers (LeetCode 628)
4. Kth Largest Element in an Array (LeetCode 215)
5. Best Time to Buy and Sell Stock (LeetCode 121)
