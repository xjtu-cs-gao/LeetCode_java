package leetcode.editor.cn;

//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。 
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
// 返回： 
//
// [3,9,20,15,7]
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
// 👍 83 👎 0

public class 从上到下打印二叉树{
	public static void main(String[] args) {
		Solution solution = new 从上到下打印二叉树().new Solution();
		
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
    public int[] levelOrder(TreeNode root) {
    	List<Integer> res = new ArrayList<>();
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	q.offer(root);
    	while(!q.isEmpty()){
    		TreeNode node = q.poll();
    		if(node==null){
    			continue;
			}
    		res.add(node.val);
    		q.offer(node.left);
    		q.offer(node.right);
		}
    	int[] ans = new int[res.size()];
    	for(int i =0; i<res.size(); i++){
    		ans[i] = res.get(i);
		}
//    	res.toArray(ans);
    	return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}