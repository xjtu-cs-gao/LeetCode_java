package leetcode.editor.cn;

//输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。 
//
// 
//
// 示例: 
//给定如下二叉树，以及目标和 target = 22， 
//
// 
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// 
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/ 
// Related Topics 树 深度优先搜索 
// 👍 167 👎 0

public class 二叉树中和为某一值的路径{
	public static void main(String[] args) {
		Solution solution = new 二叉树中和为某一值的路径().new Solution();
		
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
	List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
    	List<Integer> t = new ArrayList<>();
    	int sum = 0;
    	if(root!=null) {
			t.add(root.val);
			dfs(root, t, sum, target);
		}
    	return res;
    }
    public void dfs(TreeNode node, List<Integer> t, int sum, int target){
    	sum+=node.val;
    	if(node.left==null && node.right==null){
    		if(sum==target){
    			res.add(new ArrayList<>(t));
			}
    		return;
		}
    	if(node.left!=null){
    		t.add(node.left.val);
    		dfs(node.left, t, sum, target);
    		t.remove(t.size()-1);
		}
		if(node.right!=null){
			t.add(node.right.val);
			dfs(node.right, t, sum, target);
			t.remove(t.size()-1);
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}