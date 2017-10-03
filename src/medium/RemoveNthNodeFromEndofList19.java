package medium;

import util.ListNode;

public class RemoveNthNodeFromEndofList19 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode fast = head;
		ListNode slow = head;
		ListNode prev = null;
		int cnt = 0;

		while (fast != null && cnt < n) {
			fast = fast.next;
			cnt++;
		}

		while (fast != null) {
			fast = fast.next;
			prev = slow;
			slow = slow.next;
		}

		if (prev != null) {
			prev.next = slow.next;
			return head;
		} else {
			return head.next;
		}
	}
}
