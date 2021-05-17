package leetcode.editor.cn;

//在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。 
//
// 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。 
//
// 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。 
//
// 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。 
//
// 
//
// 示例 1： 
// 
//
// 
//输入：root = [1,2,3,4], x = 4, y = 3
//输出：false
// 
//
// 示例 2： 
// 
//
// 
//输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
//输出：true
// 
//
// 示例 3： 
//
// 
//
// 
//输入：root = [1,2,3,null,4], x = 2, y = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点数介于 2 到 100 之间。 
// 每个节点的值都是唯一的、范围为 1 到 100 的整数。 
// 
//
// 
// Related Topics 树 广度优先搜索 
// 👍 156 👎 0

public class 二叉树的堂兄弟节点{
	public static void main(String[] args) {
		Solution solution = new 二叉树的堂兄弟节点().new Solution();
		
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
	// x 的信息
	int x;
	TreeNode xParent;
	int xDepth;
	boolean xFound = false;

	// y 的信息
	int y;
	TreeNode yParent;
	int yDepth;
	boolean yFound = false;

	public boolean isCousins(TreeNode root, int x, int y) {
		this.x = x;
		this.y = y;
		dfs(root, 0, null);
		return xDepth == yDepth && xParent != yParent;
	}

	public void dfs(TreeNode node, int depth, TreeNode parent) {
		if (node == null) {
			return;
		}

		if (node.val == x) {
			xParent = parent;
			xDepth = depth;
			xFound = true;
		} else if (node.val == y) {
			yParent = parent;
			yDepth = depth;
			yFound = true;
		}

		// 如果两个节点都找到了，就可以提前退出遍历
		// 即使不提前退出，对最坏情况下的时间复杂度也不会有影响
		if (xFound && yFound) {
			return;
		}

		dfs(node.left, depth + 1, node);

		if (xFound && yFound) {
			return;
		}

		dfs(node.right, depth + 1, node);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}