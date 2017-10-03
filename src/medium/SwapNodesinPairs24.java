package medium;

import util.ListNode;

public class SwapNodesinPairs24 {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode cur = head, pre = null;
		head = cur.next;
		while (cur != null && cur.next != null) {
			ListNode nxt = cur.next;
			cur.next = nxt.next;
			nxt.next = cur;
			if (pre != null) {
				pre.next = nxt;
			}
			pre = cur;
			cur = cur.next;
		}
		return head;
	}

	public static void main(String[] args) {

	}
}
