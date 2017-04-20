import com.sun.org.apache.regexp.internal.RE;

import java.util.HashMap;

/**
 * Created by altman on 18/04/2017.
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
public class Solution {
    static TreeNode setupTree(){
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node11 = new TreeNode(11);

        root.left = node2;
        root.right = node3;

        node2.left = node4;
        node2.right = node5;

        node4.left = node7;
        node4.right = node8;

        node3.left = node11;
        node3.right = node6;

        node6.left = node9;
        node9.right = node10;
        return root;
    }
    static void Preorder(TreeNode root){
        if(root == null)
            return;
        System.out.println(root.val);
        Preorder(root.left);
        Preorder(root.right);
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0)
            return null;
        HashMap<Integer,Integer> val2index = new HashMap<Integer, Integer>();
        for(int i =0; i < inorder.length; i++){
            val2index.put(inorder[i],i);
        }
        TreeNode root = buildTree(val2index,
                inorder,
                postorder,
                0,
                postorder.length-1,
                0,
                postorder.length-1);
        return root;
    }
    public TreeNode buildTree(HashMap<Integer,Integer> val2index,
                          int[] inorder,
                          int[] postorder,
                          int in_start,
                          int in_end,
                          int post_start,
                          int post_end){
        TreeNode node = new TreeNode(postorder[post_end]);

        int index = val2index.get(node.val);

        if(post_start  <= post_start  + (index-in_start)-1){
            node.left = buildTree(
                    val2index,
                    inorder,
                    postorder,
                    in_start,
                    index-1,
                    post_start,
                    post_start  + (index-in_start)-1
            );
        }
        if(post_start + (index-in_start) <= post_end - 1){
            node.right = buildTree(
                    val2index,
                    inorder,
                    postorder,
                    index + 1,
                    in_end,
                    post_start + (index-in_start),
                    post_end - 1
            );
        }
        return node;
    }

    public static void main(String[] args){
        //int[] inorder = {7,4,8,2,5,1,11,3,9,10,6};
        //int[] postorder = {7,8,4,5,2,11,10,9,6,3,1};
        int[] inorder = {};
        int[] postorder = {};
        Solution solution = new Solution();
        TreeNode root = solution.buildTree(inorder, postorder);
        Preorder(root);
    }

}
