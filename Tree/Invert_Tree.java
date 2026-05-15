// # Invert Binary Tree 🌳

// # LeetCode 226

// ---

// # Problem Statement

// Given the root of a binary tree:

// 👉 Invert the tree.

// Means:

// ```text
// Swap left and right child of every node.
// ```

// ---

// # Example

// ## Original Tree

// ```text
//         4
//       /   \
//      2     7
//     / \   / \
//    1   3 6   9
// ```

// ---

// # Inverted Tree

// ```text
//         4
//       /   \
//      7     2
//     / \   / \
//    9   6 3   1
// ```

// ---

// # Main Logic 🌟

// For every node:

// ```text
// Swap left and right
// ```

// Then recursively invert:

// ```text
// left subtree
// right subtree
// ```

// ---

// # Recursive Thinking 🌳

// Always think:

// ```text
// Current Node
// Swap
// Go Left
// Go Right
// ```

// ---

// # Correct Code ✅

//java

  //Definition for a binary tree node.
  public class TreeNode {
      int val;
     TreeNode left;
     TreeNode right;
    TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
       this.right = right;
    }
  }
 

class Solution {

    public TreeNode invertTree(TreeNode root) {

        // Base condition
        if(root == null){
            return null;
        }

        // Swap left and right
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Invert left subtree
        invertTree(root.left);

        // Invert right subtree
        invertTree(root.right);

        return root;
    }
}
// ```

// ---

// ---

// # Dry Run 🌳

// # Input Tree

// ```text
//         4
//       /   \
//      2     7
//     / \   / \
//    1   3 6   9
// ```

// ---

// # Step 1 → Root Node = 4

// ```java
// TreeNode temp = root.left;
// ```

// ```text
// temp = 2
// ```

// ---

// ```java
// root.left = root.right;
// ```

// ```text
// 4.left = 7
// ```

// Tree becomes:

// ```text
//         4
//       /   \
//      7     7
// ```

// ---

// ```java
// root.right = temp;
// ```

// ```text
// 4.right = 2
// ```

// Now:

// ```text
//         4
//       /   \
//      7     2
// ```

// ---

// # Step 2 → Recursive Call Left

// ```java
// invertTree(root.left)
// ```

// Current Node:

// ```text
// 7
// ```

// ---

// # Swap Children of 7

// Before:

// ```text
//      7
//     / \
//    6   9
// ```

// After Swap:

// ```text
//      7
//     / \
//    9   6
// ```

// ---

// # Step 3 → Recursive Call Right

// ```java
// invertTree(root.right)
// ```

// Current Node:

// ```text
// 2
// ```

// ---

// # Swap Children of 2

// Before:

// ```text
//      2
//     / \
//    1   3
// ```

// After:

// ```text
//      2
//     / \
//    3   1
// ```

// ---

// # Final Tree 🌟

// ```text
//         4
//       /   \
//      7     2
//     / \   / \
//    9   6 3   1
// ```

// ---

// ---

// # Line-by-Line Explanation 🚀

// # Base Condition

// ```java
// if(root == null){
//     return null;
// }
// ```

// Meaning:

// ```text
// If node does not exist,
// stop recursion.
// ```

// ---

// # Store Left Child

// ```java
// TreeNode temp = root.left;
// ```

// Meaning:

// ```text
// Temporarily save left node.
// ```

// ---

// # Move Right to Left

// ```java
// root.left = root.right;
// ```

// Meaning:

// ```text
// Put right child on left side.
// ```

// ---

// # Move Left to Right

// ```java
// root.right = temp;
// ```

// Meaning:

// ```text
// Put original left child on right side.
// ```

// ---

// # Recursive Left

// ```java
// invertTree(root.left);
// ```

// Meaning:

// ```text
// Invert left subtree.
// ```

// ---

// # Recursive Right

// ```java
// invertTree(root.right);
// ```

// Meaning:

// ```text
// Invert right subtree.
// ```

// ---

// # Return Root

// ```java
// return root;
// ```

// Meaning:

// ```text
// Return final inverted tree.
// ```

// ---

// ---

// # Visualization 🌳

// # Before Inversion

// ```text
//         4
//       /   \
//      2     7
// ```

// ---

// # After Inversion

// ```text
//         4
//       /   \
//      7     2
// ```

// ---

// ---

// # Time Complexity ⏱️

// ```text
// O(n)
// ```

// because:

// ```text
// Every node visited once.
// ```

// ---

// # Space Complexity

// ```text
// O(h)
// ```

// where:

// ```text
// h = height of tree
// ```

// because recursion stack is used.

// ---

// ---

// # Important Interview Notes 🔥

// ## Tree Problems Mostly Use:

// ✅ Recursion
// ✅ DFS
// ✅ Base Condition

// ---

// # Main Pattern

// ```text
// Process Current Node
// Go Left
// Go Right
// ```

// ---

// # Invert Tree Pattern

// ```text
// Swap
// Recursive Left
// Recursive Right
// ```

// ---

// ---

// # Common Mistakes ❌

// ## Mistake 1

// ```java
// root.left = root.right;
// root.left = root.right;
// ```

// Wrong.

// Because original left child is lost.

// ---

// # Correct

// ```java
// TreeNode temp = root.left;
// root.left = root.right;
// root.right = temp;
// ```

// ---

// # Mistake 2

// Not returning root.

// Correct:

// ```java
// return root;
// ```

// ---

// # Mistake 3

// Missing base condition.

// Correct:

// ```java
// if(root == null)
// ```

// ---

// ---

// # Memory Trick 🧠

// ## Invert Tree

// ```text
// Save Left
// Move Right → Left
// Move Left → Right
// Repeat Recursively
// ```

// ---

// # Easy Formula 🌟

// ```text
// Swap + DFS
// ```

// That is the entire problem.
