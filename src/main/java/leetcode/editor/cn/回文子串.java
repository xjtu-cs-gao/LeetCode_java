package leetcode.editor.cn;

//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 输入："abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 输入："aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 输入的字符串长度不会超过 1000 。 
// 
// Related Topics 字符串 动态规划 
// 👍 568 👎 0

public class 回文子串{
	public static void main(String[] args) {
		Solution solution = new 回文子串().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
    	int len = s.length();
    	boolean[][] dp = new boolean[len][len];
    	for(int i=0; i<len; i++){
    		Arrays.fill(dp[i], false);
		}
    	for(int d=0; d<len; d++){
    		for(int i=0; i+d<len; i++){
    			if(d==0){
    				dp[i][i] = true;
				}
    			else if(d==1){
    				if(s.charAt(i)==s.charAt(i+d)){
    					dp[i][i+d] = true;
					}
				}
    			else{
    				if(dp[i+1][i+d-1]==true && s.charAt(i)==s.charAt(i+d)){
    					dp[i][i+d] = true;
					}
				}
			}
		}
    	int total = 0;
    	for(int i=0; i<len; i++){
    		for(int j=0; j<len; j++){
    			if(dp[i][j]){
    				total ++;
				}
			}
		}
    	return total;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}