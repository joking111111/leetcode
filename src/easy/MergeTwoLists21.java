package easy;

import util.ListNode;

public class MergeTwoLists21 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = null;
		ListNode prev = null;
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		}

		while (l1 != null && l2 != null) {
			if (l1.val > l2.val) {
				if (head == null) {
					head = l2;
				}
				if (prev != null) {
					prev.next = l2;
					prev = l2;
				} else {
					prev = l2;
				}
				l2 = l2.next;
			} else {
				if (head == null) {
					head = l1;
				}
				if (prev != null) {
					prev.next = l1;
					prev = l1;
				} else {
					prev = l1;
				}
				l1 = l1.next;
			}
		}
		if (l1 != null) {
			prev.next = l1;
		}
		if (l2 != null) {
			prev.next = l2;
		}
		return head;
	}
}
