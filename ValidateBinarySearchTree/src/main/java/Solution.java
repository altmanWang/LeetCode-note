import java.util.LinkedList;

/**
 * Created by altman on 17/04/2017.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MAX_VALUE, Long.MIN_VALUE );
    }
    public boolean isValidBST (TreeNode node, long max, long min){
        if(node == null)
            return true;
        if(node.val >= max || node.val <= min)
            return false;
        return isValidBST(node.left, node.val, min) && isValidBST(node.right, max, node.val);
    }

    public boolean isValidBST1(TreeNode root) {

        if(root == null)
            return true;
        return isValidBST1(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    public boolean isValidBST1 (TreeNode node, long max, long min){
        if(node == null)
            return true;
        if(node.val <= min || node.val >= max){
            return false;
        }

        if(node.left != null){
            if(node.left.val >= node.val)
                return false;
        }
        if(node.right != null){
            if(node.right.val <= node.val)
                return false;
        }
        return isValidBST1(node.left, node.val , min) && isValidBST1(node.right, max, node.val);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        //root.right = new TreeNode(3);

        Solution solution = new Solution();
        System.out.println(solution.isValidBST1(root));

    }
}
