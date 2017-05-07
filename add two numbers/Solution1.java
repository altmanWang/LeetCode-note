/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int sum = 0;
		ListNode newHead = new ListNode(0);
		ListNode node = newHead;

        while(l1!=null || l2!=null){
			if (l1 != null){
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null){
				sum += l2.val;
				l2 = l2.next;
			}
			node.next = new ListNode(sum%10);
			node = node.next;
			sum = sum /10;
		}
		if (sum==1){
			node.next = new ListNode(1);
		}
		return newHead.next;
    }
}
