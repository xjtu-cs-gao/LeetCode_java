package leetcode.editor.cn;

//最初在一个记事本上只有一个字符 'A'。你每次可以对这个记事本进行两种操作： 
//
// 
// Copy All (复制全部) : 你可以复制这个记事本中的所有字符(部分的复制是不允许的)。 
// Paste (粘贴) : 你可以粘贴你上一次复制的字符。 
// 
//
// 给定一个数字 n 。你需要使用最少的操作次数，在记事本中打印出恰好 n 个 'A'。输出能够打印出 n 个 'A' 的最少操作次数。 
//
// 示例 1: 
//
// 
//输入: 3
//输出: 3
//解释:
//最初, 我们只有一个字符 'A'。
//第 1 步, 我们使用 Copy All 操作。
//第 2 步, 我们使用 Paste 操作来获得 'AA'。
//第 3 步, 我们使用 Paste 操作来获得 'AAA'。
// 
//
// 说明: 
//
// 
// n 的取值范围是 [1, 1000] 。 
// 
// Related Topics 动态规划 
// 👍 283 👎 0

public class 只有两个键的键盘{
	public static void main(String[] args) {
		Solution solution = new 只有两个键的键盘().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSteps(int n) {
    	if(n == 1) return 0;
    	int[][] dp = new int[n+1][n+1];
    	for(int[] dp1 : dp) {
    		Arrays.fill(dp1, 1000);
		}
    	dp[1][1] = 1;
    	for(int i = 1; i<=n; i++){
    		for(int j = i; j<=n; j++){
    			if(j==i && i!=1) {
//    				dp[i][j] = i;
    				for(int x = 1; x<j; x++){
    					dp[i][j] = Math.min(dp[i][j], dp[x][j] + 1);
					}
				}else{
    				if(j-i>=i){
    					dp[i][j] = Math.min(dp[i][j], dp[i][j-i]+1);
					}
				}
			}
		}
    	int ans = 1000;
    	for(int i=1; i<=n; i++){
    		ans = Math.min(ans, dp[i][n]);
		}
    	return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}