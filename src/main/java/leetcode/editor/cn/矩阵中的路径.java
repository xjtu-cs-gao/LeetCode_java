package leetcode.editor.cn;

//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 深度优先搜索 
// 👍 308 👎 0

public class 矩阵中的路径{
	public static void main(String[] args) {
		Solution solution = new 矩阵中的路径().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
    	int len1 = board.length, len2 = board[0].length;
    	int len = word.length();
    	boolean[][] visited = new boolean[len1][len2];
    	StringBuilder t = new StringBuilder(len);
    	for(int i=0; i<len1;i++){
			Arrays.fill(visited[i], false);
		}
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(dfs(board, i, j, t, visited, word)) return true;
			}
		}

    	return false;
    }
    public boolean dfs(char[][] board, int x, int y, StringBuilder t, boolean[][] visited, String word){
		visited[x][y] = true;
		t.append(board[x][y]);
    	if(t.charAt(t.length()-1) != word.charAt(t.length()-1)){
			visited[x][y] = false;
			t.delete(t.length()-1, t.length());
    		return false;
		}
    	else{
    		if(t.length()==word.length()){
				t.delete(t.length()-1, t.length());
				visited[x][y] = false;
    			return true;
			}
		}
    	boolean flag1=false, flag2=false, flag3=false, flag4=false;
    	boolean flag = (x+1<board.length && visited[x+1][y] == false && dfs(board, x+1, y, t, visited, word)) || (x-1 >-1 && visited[x-1][y] == false && dfs(board, x-1, y, t, visited, word)) || (y+1<board[0].length && visited[x][y+1] == false && dfs(board, x, y+1, t, visited, word)) || (y-1 > -1 && visited[x][y-1] == false && dfs(board, x, y-1, t, visited, word));
		t.delete(t.length()-1, t.length());
		visited[x][y] = false;
		return flag;
//    	if(x+1<board.length && visited[x+1][y] == false){
//    		flag1 = dfs(board, x+1, y, t, visited, word);
//		}
//		if(x-1 >-1 && visited[x-1][y] == false){
//			flag2 = dfs(board, x-1, y, t, visited, word);
//		}
//		if(y+1<board[0].length && visited[x][y+1] == false){
//			flag3 = dfs(board, x, y+1, t, visited, word);
//		}
//		if(y-1 > -1 && visited[x][y-1] == false){
//			flag4 = dfs(board, x, y-1, t, visited, word);
//		}
//		t.delete(t.length()-1, t.length());
//		visited[x][y] = false;
//		return flag1 || flag2 || flag3 || flag4;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}