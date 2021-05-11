package leetcode.editor.cn;

//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-tra
//versal/ 
// Related Topics 树 广度优先搜索 
// 👍 102 👎 0

public class 从上到下打印二叉树 II{
	public static void main(String[] args) {
		Solution solution = new 从上到下打印二叉树 II().new Solution();
		
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
    public List<List<Integer>> levelOrder(TreeNode root) {
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	List<List<Integer>> res = new ArrayList<>();
    	if(root!=null){
    		q.add(root);
		}
    	while(!q.isEmpty()){
    		List<Integer> tmp = new ArrayList<>();
    		for(int i=q.size()-1;i>=0;i--){
    			TreeNode node = q.poll();
    			tmp.add(node.val);
    			if(node.left!=null) q.add(node.left);
    			if(node.right!=null) q.add(node.right);
			}
    		res.add(tmp);
		}
    	return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}