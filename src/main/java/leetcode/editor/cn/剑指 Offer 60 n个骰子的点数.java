package leetcode.editor.cn;

//把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。 
//
// 
//
// 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。 
//
// 
//
// 示例 1: 
//
// 输入: 1
//输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
// 
//
// 示例 2: 
//
// 输入: 2
//输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0
//.05556,0.02778] 
//
// 
//
// 限制： 
//
// 1 <= n <= 11 
// 👍 229 👎 0

public class n个骰子的点数{
	public static void main(String[] args) {
		Solution solution = new n个骰子的点数().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double[] dicesProbability(int n) {
    	int[][] p = new int[n+1][6*n+1];
    	p[0][0] = 1;
    	for(int i=1; i<=n; i++){
    		for(int j=1; j<=6; j++){
    			for(int x=i; x<=6*i; x++){
    				if(x-j>=0){
    					p[i][x] += p[i-1][x-j];
					}
				}
			}
		}
    	int sum = 0;
    	for(int x=1; x<=6*n; x++){
    		sum += p[n][x];
		}
    	double[] ans = new double[5*n+1];
    	for(int i=0; i<5*n+1; i++){
    		ans[i] = (double)p[n][i+n]/sum;
		}
    	return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}