package leetcode.editor.cn;

//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 128 👎 0

public class 从尾到头打印链表{
	public static void main(String[] args) {
		Solution solution = new 从尾到头打印链表().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
    	int len = 0;
    	ListNode now = head;
    	while(now != null){
    		len++;
    		now = now.next;
		}
    	int[] res = new int[len--];
    	now = head;
    	while(now != null){
    		res[len--] = now.val;
    		now = now.next;
		}
    	return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}