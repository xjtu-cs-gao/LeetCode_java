package leetcode.editor.cn;

//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 字符串 动态规划 
// 👍 1290 👎 0

public class 最长有效括号{
	public static void main(String[] args) {
		Solution solution = new 最长有效括号().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
    	int len = s.length();
    	Deque<Integer> stack = new LinkedList<Integer>();
    	boolean[] isValid = new boolean[len];
    	Arrays.fill(isValid, false);
    	for(int i=0; i<len; i++){
    		if(s.charAt(i)=='('){
    			stack.push(i);
			}
    		else{
    			if(!stack.isEmpty()){
    				isValid[stack.pop()] = true;
    				isValid[i] = true;
				}
			}
		}
    	int max = 0;
    	int now = 0;
    	for(int i=0; i<len; i++){
    		if(isValid[i]){
    			now += 1;
    			max = Math.max(now, max);
			}
    		else {
    			now = 0;
			}
		}
    	return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}