/**
 * @Auther: Administrator
 * @Date: 2019/12/18 09:27
 * @Description: 二叉树遍历,保证节点和左节点,右节点值相同就可以
 */
public class problem965 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(1);
        TreeNode root3 = new TreeNode(1);
        TreeNode root4 = new TreeNode(1);
        TreeNode root5 = new TreeNode(1);
        root1.left=root3;
        root1.right=root4;
        root2.right=root5;
        root.left=root1;
        root.right=root2;
        System.out.println(new Solution().isUnivalTree(root));
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = false;
        boolean right = false;
        if (root.left != null && root.left.val != root.val) {
            left = false;
        } else {
            left = true;
        }
        if (root.right != null && root.right.val != root.val) {
            right = false;
        } else {
            right = true;
        }
        if (left && right) {
            return isUnivalTree(root.left) && isUnivalTree(root.right);
        } else {
            return false;
        }
    }
}