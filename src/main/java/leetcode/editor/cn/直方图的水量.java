package leetcode.editor.cn;

//给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marco
//s 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针 
// 👍 168 👎 0

public class 直方图的水量{
	public static void main(String[] args) {
		Solution solution = new 直方图的水量().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
    	int ans = 0;
    	int len = height.length;
    	if(len==0 || len==1){
    		return 0;
		}
    	int[] max = new int[len];
    	max[len-1] = 0;
    	for(int i = len-2; i>=0; i--){
    		max[i] = height[i+1] > max[i+1] ? height[i+1] : max[i+1];
		}
    	max[0] = 0;
    	for(int i=1; i<len; i++){
    		int leftmax = height[i-1] > max[i-1] ? height[i-1] : max[i-1];
    		max[i] = max[i] < leftmax ? max[i] : leftmax;
    		if(max[i]>height[i]) {
				ans += max[i] - height[i];
			}
		}
    	return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}