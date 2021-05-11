package leetcode.editor.cn;

//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
// Related Topics 树 动态规划 
// 👍 1142 👎 0

public class 不同的二叉搜索树{
	public static void main(String[] args) {
		Solution solution = new 不同的二叉搜索树().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numTrees(int n) {
    	if(n==0) return 1;
    	if(n==1) return 1;
    	int[] dp = new int[n+1];
    	dp[0] = 1;
    	dp[1] = 1;
    	for(int i=2; i<=n; i++){
    		int sum = 0;
    		for(int j=0; j<i; j++){
    			sum+=dp[j]*dp[i-1-j];
			}
    		dp[i] = sum;
		}
    	return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}