package leetcode.editor.cn;

//给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[
//i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。 
//
// 
//
// 示例: 
//
// 
//输入: [1,2,3,4,5]
//输出: [120,60,40,30,24] 
//
// 
//
// 提示： 
//
// 
// 所有元素乘积之和不会溢出 32 位整数 
// a.length <= 100000 
// 
// 👍 112 👎 0

public class 构建乘积数组{
	public static void main(String[] args) {
		Solution solution = new 构建乘积数组().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] constructArr(int[] a) {
    	int len = a.length;
    	if(len==0){
    		return new int[0];
		}
    	int[] leftPro = new int[len];
    	leftPro[0] = a[0];
    	int[] rightPro = new int[len];
    	rightPro[len-1] = a[len-1];
    	for(int i=1; i<len; i++){
    		leftPro[i] = leftPro[i-1]*a[i];
		}
    	for(int i=len-2;i>=0;i--){
    		rightPro[i] = rightPro[i+1]*a[i];
		}
    	int[] ans = new int[len];
    	if(len==1){
    		ans[0] = 1;
    		return ans;
		}
    	ans[0] = rightPro[1];
    	ans[len-1] = leftPro[len-2];
    	for(int i=1; i<len-1; i++){
    		ans[i] = leftPro[i-1] * rightPro[i+1];
		}
    	return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}