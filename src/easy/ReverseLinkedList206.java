package easy;

import util.ListNode;

public class ReverseLinkedList206 {
	public ListNode reverseList(ListNode head) {
		ListNode cur = head;
		ListNode pre = null;
		while (cur != null) {
			ListNode temp = cur;
			cur = cur.next;
			temp.next = pre;
			pre = temp;
		}

		return pre;
	}

	public ListNode reverseList2(ListNode head) {
		return rvsList(head, null);
	}

	public ListNode rvsList(ListNode cur, ListNode pre) {
		if (cur == null) {
			return pre;
		} else {
			ListNode head = rvsList(cur.next, cur);
			cur.next = pre;
			return head;
		}
	}
}
