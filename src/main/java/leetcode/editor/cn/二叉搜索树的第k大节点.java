package leetcode.editor.cn;

//给定一棵二叉搜索树，请找出其中第k大的节点。 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树 
// 👍 151 👎 0

public class 二叉搜索树的第k大节点{
	public static void main(String[] args) {
		Solution solution = new 二叉搜索树的第k大节点().new Solution();
		
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
	int num=-1;
	int n;
    public int kthLargest(TreeNode root, int k) {
    	n = k;
    	inorder(root);
    	return num;
    }
    public void inorder(TreeNode root){
    	if(num!=-1){
    		return;
		}
    	if(root==null){
    		return;
		}
    	inorder(root.right);
    	n--;
    	if(n==0) num=root.val;
    	inorder(root.left);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}