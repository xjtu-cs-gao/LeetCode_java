package leetcode.editor.cn;

//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例: 
//
// s = "abaccdeff"
//返回 "b"
//
//s = "" 
//返回 " "
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 哈希表 
// 👍 81 👎 0

public class 第一个只出现一次的字符{
	public static void main(String[] args) {
		Solution solution = new 第一个只出现一次的字符().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char firstUniqChar(String s) {
    	int[] cnts = new int[128];
    	for(int i=0; i<s.length(); i++){
    		cnts[s.charAt(i)]++;
		}
    	for(int i=0; i<s.length(); i++){
    		if(cnts[s.charAt(i)]==1){
    			return s.charAt(i);
			}
		}
    	return ' ';
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
