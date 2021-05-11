package leetcode.editor.cn;

//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 递归 
// 👍 423 👎 0

public class 重建二叉树{
	public static void main(String[] args) {
		Solution solution = new 重建二叉树().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	return build(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }
    public TreeNode build(int[] preorder, int[] inorder, int preleft, int preright, int inleft, int inright){
    	if(preleft>=preright || inleft>=inright){
    		return null;
		}
    	int mid;
    	for(mid = inleft; mid < inright; mid++){
    		if(inorder[mid]==preorder[preleft]){
    			break;
			}
		}
    	TreeNode root = new TreeNode(preorder[preleft]);
    	root.left = build(preorder, inorder, preleft+1, preleft+mid-inleft+1, inleft, mid);
    	root.right = build(preorder, inorder, preleft+mid-inleft+1, preright, mid+1, inright);
    	return root;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}