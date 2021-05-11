package leetcode.editor.cn;

//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 859 👎 0

public class 二叉树的层序遍历{
	public static void main(String[] args) {
		Solution solution = new 二叉树的层序遍历().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> ans = new ArrayList<>();
    	Queue<TreeNode> queue = new LinkedList<>();
    	if(root==null){
    		return ans;
		}
    	queue.offer(root);
    	while(!queue.isEmpty()){
			List<Integer> res = new ArrayList<>();
			int len = queue.size();
    		for(int i=0; i<len; i++) {
    			TreeNode node = queue.poll();
    			res.add(node.val);
    			if(node.left!=null){
    				queue.offer(node.left);
				}
    			if(node.right!=null){
    				queue.offer(node.right);
				}
			}
    		ans.add(res);
		}
    	return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}