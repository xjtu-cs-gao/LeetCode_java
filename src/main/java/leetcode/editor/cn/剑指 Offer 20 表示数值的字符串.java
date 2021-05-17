package leetcode.editor.cn;

//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。 
//
// 数值（按顺序）可以分成以下几个部分： 
//
// 
// 若干空格 
// 一个 小数 或者 整数 
// （可选）一个 'e' 或 'E' ，后面跟着一个 整数 
// 若干空格 
// 
//
// 小数（按顺序）可以分成以下几个部分： 
//
// 
// （可选）一个符号字符（'+' 或 '-'） 
// 下述格式之一：
// 
// 至少一位数字，后面跟着一个点 '.' 
// 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字 
// 一个点 '.' ，后面跟着至少一位数字 
// 
// 
// 
//
// 整数（按顺序）可以分成以下几个部分： 
//
// 
// （可选）一个符号字符（'+' 或 '-'） 
// 至少一位数字 
// 
//
// 部分数值列举如下： 
//
// 
// ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"] 
// 
//
// 部分非数值列举如下： 
//
// 
// ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"] 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "0"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "e"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：s = "."
//输出：false 
//
// 示例 4： 
//
// 
//输入：s = "    .1  "
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，空格 ' ' 或者点 '.' 。 
// 
// Related Topics 数学 
// 👍 189 👎 0

public class 表示数值的字符串{
	public static void main(String[] args) {
		Solution solution = new 表示数值的字符串().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	private int index = 0;//全局索引
	private boolean scanUnsignedInteger(String str) {
		//是否包含无符号数
		int before = index;
		while(str.charAt(index) >= '0' && str.charAt(index) <= '9')
			index++;
		return index > before;
	}
	private boolean scanInteger(String str) {
		//是否包含有符号数
		if(str.charAt(index) == '+' || str.charAt(index) == '-')
			index++;
		return scanUnsignedInteger(str);
	}
	public boolean isNumber(String s) {
		//空字符串
		if(s == null || s.length() == 0)
			return false;
		//添加结束标志
		s = s + '|';
		//跳过首部的空格
		while(s.charAt(index) == ' ')
			index++;
		boolean numeric = scanInteger(s); //是否包含整数部分
		if(s.charAt(index) == '.') {
			index++;
			//有小数点，处理小数部分
			//小数点两边只要有一边有数字就可以，所以用||，
			//注意scanUnsignedInteger要在前面，否则不会进
			numeric = scanUnsignedInteger(s) || numeric;
		}
		if((s.charAt(index) == 'E' || s.charAt(index) == 'e')) {
			index++;
			//指数部分
			//e或E的两边都要有数字，所以用&&
			numeric = numeric && scanInteger(s);
		}
		//跳过尾部空格
		while(s.charAt(index) == ' ')
			index++;
		return numeric && s.charAt(index) == '|' ;
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}