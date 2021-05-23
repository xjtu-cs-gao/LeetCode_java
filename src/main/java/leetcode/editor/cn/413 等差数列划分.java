package leetcode.editor.cn;

//如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。 
//
// 例如，以下数列为等差数列: 
//
// 
//1, 3, 5, 7, 9
//7, 7, 7, 7
//3, -1, -5, -9 
//
// 以下数列不是等差数列。 
//
// 
//1, 1, 2, 5, 7 
//
// 
//
// 数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。 
//
// 如果满足以下条件，则称子数组(P, Q)为等差数组： 
//
// 元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。 
//
// 函数要返回数组 A 中所有为等差数组的子数组个数。 
//
// 
//
// 示例: 
//
// 
//A = [1, 2, 3, 4]
//
//返回: 3, A 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]。
// 
// Related Topics 数学 动态规划 
// 👍 240 👎 0

public class 等差数列划分{
	public static void main(String[] args) {
		Solution solution = new 等差数列划分().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
    	int len = nums.length;
    	if(len < 3)
    		return 0;
    	boolean[][] dp = new boolean[len][len];
    	int ans = 0;
    	for(int d=2; d<len; d++) {
    		for(int i=0; i+d<len; i++) {
    			int j = i + d;
    			if(d == 2) {
					if (nums[i] + nums[j] == 2 * nums[i + 1])
						dp[i][j] = true;
					else
						dp[i][j] = false;
				}
    			else{
    				if(dp[i+1][j] == true && nums[i] - nums[i+1] == nums[i+1] - nums[i+2])
    					dp[i][j] = true;
    				if(dp[i][j-1] == true && nums[j] - nums[j-1] == nums[j-1] - nums[j-2])
    					dp[i][j] = true;
				}
    			if(dp[i][j] == true)
    				ans++;
			}
		}
    	return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}