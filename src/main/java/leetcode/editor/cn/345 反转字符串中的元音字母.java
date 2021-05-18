package leetcode.editor.cn;


//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 
//
// 示例 1： 
//
// 输入："hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 输入："leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 元音字母不包含字母 "y" 。 
// 
// Related Topics 双指针 字符串 
// 👍 151 👎 0

public class 反转字符串中的元音字母{
	public static void main(String[] args) {
		Solution solution = new 反转字符串中的元音字母().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	private final static HashSet<Character> vowels = new HashSet<>(
			Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
	);
    public String reverseVowels(String s) {
    	if(s==null) return null;
    	int i=0, j=s.length()-1;
    	char[] result = new char[s.length];
    	while(i<=j){
    		char ci = s.charAt(i);
    		char cj = s.charAt(j);
    		if(!vowels.contains(ci)){
    			result[i++] = ci;
			}else if(!vowels.contains(cj)){
    			result[j--] = cj;
			}else{
    			result[i++] = cj;
    			result[j--] = ci;
			}
		}
    	return new String(result);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}