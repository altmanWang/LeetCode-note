/**
 * Created by altman on 22/04/2017.
 */

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
public class Solution {
    static void Preorder(TreeNode root){
        if(root == null)
            return;
        System.out.println(root.val);
        Preorder(root.left);
        Preorder(root.right);
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = sortedArrayToBST(nums,0,nums.length-1);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums, int start, int end){
        if(start > end)
            return null;

        int index = (int)(end-start)/2+start;
        System.out.println(start+" "+end+" "+index);

        TreeNode node = new TreeNode(nums[index]);
        node.left = sortedArrayToBST(nums, start, index-1);
        node.right = sortedArrayToBST(nums, index+1, end);
        return node;
    }
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};
        Solution solution = new Solution();
        solution.sortedArrayToBST(nums);
    }
}
