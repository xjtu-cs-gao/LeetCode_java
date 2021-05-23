package leetcode.editor.cn;

//给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。 
//
// 
//
// 示例： 
//
// 输入: "sea", "eat"
//输出: 2
//解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
// 
//
// 
//
// 提示： 
//
// 
// 给定单词的长度不超过500。 
// 给定单词中的字符只含有小写字母。 
// 
// Related Topics 字符串 
// 👍 196 👎 0

public class 两个字符串的删除操作{
	public static void main(String[] args) {
		Solution solution = new 两个字符串的删除操作().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int minDistance(String s1, String s2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {
				if (i == 0 || j == 0)
					dp[i][j] = i + j;
				else if (s1.charAt(i - 1) == s2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else
					dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		return dp[s1.length()][s2.length()];
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}