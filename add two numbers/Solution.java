class ListNode{
	int val;
	ListNode next;
    /*constructor */
	ListNode(int x){
		this.val=x;
		this.next=null;
	}
}
public class Solution{ 
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int sum = 0;
		ListNode newHead = new ListNode(0);
		ListNode node = newHead;
		tools(l1,l2,newHead,sum);
		return newHead.next;
	}
	private boolean tools(ListNode l1,ListNode l2,ListNode head,int c){
		if(l1!=null || l2!=null){
            if(l1!=null){
				c +=l1.val;
				l1 = l1.next;
			}
			if(l2!=null){
				c +=l2.val;
				l2 = l2.next;
			}
			head.next = new ListNode(c%10);
			tools(l1,l2,head.next,c/10);
		}else{
			if(c==1){
				head.next = new ListNode(1);
			}
			return true;
		}
		return false;
	}
	public static void main(String[] args){
		ListNode result = new ListNode(0);
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(5);
		ListNode node1=l1,node2=l2;
		node1.next = new ListNode(4);
		node2.next = new ListNode(6);

		node1 = node1.next;
		node2 = node2.next;

		node1.next = new ListNode(3);
		node2.next = new ListNode(4);

	    Solution s = new Solution();
		result = s.addTwoNumbers(l1,l2);
        while(result.next!=null){
			System.out.println(result.val);
			result = result.next;
		}
		System.out.println(result.val);
	}
}
