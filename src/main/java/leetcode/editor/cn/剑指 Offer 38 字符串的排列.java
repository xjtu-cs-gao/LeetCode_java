package leetcode.editor.cn;

//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 回溯算法 
// 👍 265 👎 0

public class 字符串的排列{
	public static void main(String[] args) {
		Solution solution = new 字符串的排列().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	ArrayList<String> ret = new ArrayList<>();
    public String[] permutation(String s) {
    	if(s.length() == 0){
    		return ret.toArray(new String[s.length()]);
		}
    	char[] chars = s.toCharArray();
    	Arrays.sort(chars);
    	backtrace(chars, new boolean[chars.length], new StringBuilder());
    	return ret.toArray(new String[s.length()]);
    }
    public void backtrace(char[] chars, boolean[] isUsed, StringBuilder s){
    	if(s.length() == chars.length){
    		ret.add(s.toString());
    		return;
		}
    	for(int i = 0; i < chars.length; i++){
    		if(isUsed[i])
    			continue;
    		if(i-1>=0 && chars[i] == chars[i-1] && isUsed[i-1]==false)
    			continue;
    		isUsed[i] = true;
    		s.append(chars[i]);
    		backtrace(chars, isUsed, s);
    		s.deleteCharAt(s.length()-1);
    		isUsed[i] = false;
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}