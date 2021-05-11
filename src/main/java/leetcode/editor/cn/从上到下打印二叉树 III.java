package leetcode.editor.cn;

//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
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
//  [20,9],
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
// Related Topics 树 广度优先搜索 
// 👍 94 👎 0

public class 从上到下打印二叉树 III{
	public static void main(String[] args) {
		Solution solution = new 从上到下打印二叉树 III().new Solution();
		
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
    	Deque<TreeNode> deque = new LinkedList<>();
    	List<List<Integer>> res = new ArrayList<>();
    	if(root!=null){
    		deque.add(root);
		}
    	while(!deque.isEmpty()){
    		List<Integer> tmp = new ArrayList<>();
    		for(int i=deque.size(); i>0; i--){
    			TreeNode node = deque.pollFirst();
    			tmp.add(node.val);
    			if(node.left!=null){
    				deque.addLast(node.left);
				}
    			if(node.right!=null){
					deque.addLast(node.right);
				}
			}
    		res.add(tmp);
    		if(deque.isEmpty()) break;
			tmp = new ArrayList<>();
			for(int i=deque.size(); i>0; i--){
				TreeNode node = deque.pollLast();
				tmp.add(node.val);
				if(node.right!=null){
					deque.addFirst(node.right);
				}
				if(node.left!=null){
					deque.addFirst(node.left);
				}
			}
			res.add(tmp);
		}
    	return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}