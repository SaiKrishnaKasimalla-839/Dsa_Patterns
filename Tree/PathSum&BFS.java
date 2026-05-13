🌳 Today's LeetCode Tree Revision Notes

Problems Solved Today:

Binary Tree Level Order Traversal
Path Sum
🌳 1. Binary Tree Level Order Traversal
📌 Problem Statement

Traverse tree:

✅ Level by Level

using:

BFS (Breadth First Search)
🌳 Example Tree
        3
       / \
      9  20
         / \
        15  7
✅ Output
[[3],[9,20],[15,7]]
🧠 Main Logic

We use:

✅ Queue
✅ BFS Traversal

Queue works like:

FIFO

First In First Out.

🌟 Core Idea

At every level:

Store current queue size
Process exactly those many nodes
Add children into queue
Store one level in answer
✅ Correct Code
import java.util.*;

class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {

        // final answer
        List<List<Integer>> li = new ArrayList<>();

        // edge case
        if(root == null){
            return li;
        }

        // queue for bfs
        Queue<TreeNode> queue = new LinkedList<>();

        // add root node
        queue.offer(root);

        // bfs traversal
        while(!queue.isEmpty()){

            // current level size
            int size = queue.size();

            // store one level
            List<Integer> level = new ArrayList<>();

            // process current level nodes
            for(int i = 0; i < size; i++){

                // remove node
                TreeNode current = queue.poll();

                // store node value
                level.add(current.val);

                // add left child
                if(current.left != null){
                    queue.offer(current.left);
                }

                // add right child
                if(current.right != null){
                    queue.offer(current.right);
                }
            }

            // add current level into result
            li.add(level);
        }

        return li;
    }
}
🔥 Dry Run — Every Line

Tree:

        3
       / \
      9  20
         / \
        15  7
STEP 1

Queue:

[3]
STEP 2
size = queue.size();

Current:

size = 1

Means:

👉 Current level has 1 node.

STEP 3

Remove node:

TreeNode current = queue.poll();

Removed:

3

Store:

level.add(current.val);

Level becomes:

[3]
STEP 4

Add children:

9 , 20

Queue becomes:

[9,20]

Result:

[[3]]
STEP 5

Now:

size = 2

Means:

👉 Current level has 2 nodes.

STEP 6

Remove:

9

Store:

[9]

No children.

STEP 7

Remove:

20

Store:

[9,20]

Add children:

15 , 7

Queue:

[15,7]

Result:

[[3],[9,20]]
STEP 8

Remove:

15

Store:

[15]
STEP 9

Remove:

7

Store:

[15,7]

Queue becomes empty.

Final Result:

[[3],[9,20],[15,7]]
⏱️ Time Complexity
O(n)

Every node visited once.

🌳 2. Path Sum
📌 Problem Statement

Check whether tree has:

Root → Leaf path

whose sum equals:

targetSum
🌳 Example Tree
        5
       / \
      4   8
     /   / \
    11  13  4
   /  \       \
  7    2       1

Target:

22
✅ Valid Path
5 → 4 → 11 → 2

Sum:

22
🧠 Main Logic

At every node:

Subtract current node value from target

Then recursively move:

left subtree
right subtree

At leaf node:

target == node value

means:

✅ Valid path exists.

✅ Correct Code
class Solution {

    public boolean hasPathSum(TreeNode root, int targetSum) {

        // tree empty
        if(root == null){
            return false;
        }

        // leaf node check
        if(root.left == null && root.right == null){

            return targetSum == root.val;
        }

        // remaining target
        int remaining = targetSum - root.val;

        // recursively check left or right subtree
        return hasPathSum(root.left, remaining) ||
               hasPathSum(root.right, remaining);
    }
}
🔥 Dry Run — Every Line

Target:

22
STEP 1

Current node:

5
STEP 2

Check:

if(root == null)

Current:

root = 5

So continue.

STEP 3

Check leaf node:

if(root.left == null && root.right == null)

Current:

5 has children

So continue.

STEP 4

Subtract:

remaining = targetSum - root.val;

Calculation:

22 - 5 = 17

Remaining target:

17
STEP 5

Recursive call:

hasPathSum(root.left,17)

Current node:

4
STEP 6

Subtract:

17 - 4 = 13

Remaining:

13
STEP 7

Move left:

Current node:

11

Subtract:

13 - 11 = 2

Remaining:

2
STEP 8

Move left:

Current node:

7

Leaf node.

Check:

2 == 7 → false

No valid path.

STEP 9

Backtrack.

Move right child of 11.

Current node:

2

Leaf node.

Check:

2 == 2 → true

✅ Valid Path Found.

🌳 Valid Path
5 → 4 → 11 → 2

Sum:

22
⏱️ Time Complexity
O(n)

Every node visited once.

🎯 Concepts Learned Today

✅ BFS
✅ Queue
✅ Level Order Traversal
✅ DFS
✅ Recursion
✅ Root-to-Leaf Traversal
✅ Tree Traversal
✅ Recursive Subtraction

🚀 Quick Revision Shortcut
Level Order Traversal
Queue + BFS + Level Processing
Path Sum
Subtract node value while moving down tree

At leaf:

target == node value

means:

✅ Path exists.

🧠 Memory Tricks
Level Order Traversal

Think:

Queue = Waiting Line

Nodes process level-by-level 🌳

Path Sum

Think:

Target keeps reducing while moving downward

If target becomes exact at leaf:

✅ Valid Path Found 🌳