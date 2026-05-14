
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> li=new ArrayList<>();
        rightView(root,0,li);
        return li;
    }

    public void rightView(TreeNode root,int level,List<Integer> li){
        if(root==null){
            return;
        }
        //is used to store the first visible node at that level into the final answer list.(already visited this level where you go to left tree side.....)
        if(level==li.size()){
            li.add(root.val);
        }
        rightView(root.right,level+1,li);
        rightView(root.left,level+1,li);
    }
}