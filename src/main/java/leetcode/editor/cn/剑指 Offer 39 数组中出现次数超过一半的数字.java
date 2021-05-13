package leetcode.editor.cn;

//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 
//
// 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/ 
//
// 
// Related Topics 位运算 分治算法 
// 👍 150 👎 0

public class 数组中出现次数超过一半的数字{
	public static void main(String[] args) {
		Solution solution = new 数组中出现次数超过一半的数字().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
    	int major = 0;
    	int time = 0;
    	for(int num : nums) {
    		if(num==major){
    			time+=1;
			}
    		else{
    			if(time==0){
    				major = num;
    				time = 1;
				}else{
    				time--;
				}
			}
		}
    	return major;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}