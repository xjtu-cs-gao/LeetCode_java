package leetcode.editor.cn;

//请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配
//是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。 
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "a*"
//输出: true
//解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3: 
//
// 输入:
//s = "ab"
//p = ".*"
//输出: true
//解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 示例 4: 
//
// 输入:
//s = "aab"
//p = "c*a*b"
//输出: true
//解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
// 
//
// 示例 5: 
//
// 输入:
//s = "mississippi"
//p = "mis*is*p*."
//输出: false 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。 
// 
//
// 注意：本题与主站 10 题相同：https://leetcode-cn.com/problems/regular-expression-matching/
// 
// Related Topics 动态规划 
// 👍 224 👎 0

public class 正则表达式匹配{
	public static void main(String[] args) {
		Solution solution = new 正则表达式匹配().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch(String s, String p) {
    	int len1 = s.length();
    	int len2 = p.length();
    	return Match(s, p, 0, 0, len1, len2);
    }
    private boolean Match(String s, String p, int i, int j, int len1, int len2) {
    	if(j == len2) {
    		if(i == len1 && j == len2)
    			return true;
    		else
    			return false;
		}
    	if(i == len1) {
			if(j+1 < len2 && p.charAt(j+1) == '*') {
				return Match(s, p, i, j+2, len1, len2);
			}
			return false;
		}
    	if(j+1 < len2 && p.charAt(j+1) == '*'){
    		if(charMatch(s.charAt(i), p.charAt(j))) {
    			return Match(s, p, i+1, j+2, len1, len2) || Match(s, p, i+1, j, len1, len2) || Match(s, p, i, j+2, len1, len2);
			}
    		else {
    			return Match(s, p, i, j+2, len1, len2);
			}
		}
    	if(charMatch(s.charAt(i), p.charAt(j)))
    		return Match(s, p, i+1, j+1, len1, len2);
    	return false;
	}
	private boolean charMatch(char a, char b){
    	if(b == '.')
    		return true;
    	if(a == b)
    		return true;
    	return false;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}