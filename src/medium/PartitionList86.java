package medium;

import util.ListNode;

public class PartitionList86 {
	public ListNode partition(ListNode head, int x) {
		ListNode cur = head;
		ListNode lPre = null;
		ListNode rPre = null;
		ListNode rHead = null;
		while (cur != null) {
			if (cur.val < x) {
				lPre = cur;
			} else {
				if (lPre == null) {
					head = cur.next;
				} else {
					lPre.next = cur.next;
				}
				if (rPre == null) {
					rHead = cur;
				} else {
					rPre.next = cur;
				}

				rPre = cur;
			}

			cur = cur.next;
		}

		if (lPre != null) {
			lPre.next = rHead;
		} else {
			head = rHead;
		}

		if (rPre != null) {
			rPre.next = null;
		}

		return head;
	}
}
