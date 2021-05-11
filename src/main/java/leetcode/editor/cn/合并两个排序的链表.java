package leetcode.editor.cn;

//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
// Related Topics 分治算法 
// 👍 104 👎 0

public class 合并两个排序的链表{
	public static void main(String[] args) {
		Solution solution = new 合并两个排序的链表().new Solution();
		
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode index1 = l1, index2 = l2;
    	if(l1 == null){
    		return l2;
		}else if(l2 == null){
    		return l1;
		}
    	ListNode head;
    	if(index1.val<index2.val){
    		head = index1;
    		index1 = index1.next;
		}else{
    		head = index2;
    		index2 = index2.next;
		}
    	ListNode pre = head;
    	while(index1!=null && index2!=null){
    		if(index1.val<index2.val){
    			pre.next = index1;
    			pre = index1;
    			index1 = index1.next;
			}else{
    			pre.next = index2;
    			pre = index2;
    			index2 = index2.next;
			}
		}
    	if(index1!=null){
    		pre.next = index1;
		}else{
    		pre.next = index2;
		}
    	return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
