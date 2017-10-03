package medium;

import util.ListNode;

public class RemoveDuplicatesfromSortedListII82 {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode fake = new ListNode(0);
		fake.next = head;
		ListNode pre = fake;
		ListNode cur = head;
		while (cur != null) {
			while (cur.next != null && cur.val == cur.next.val) {
				cur = cur.next;
			}
			if (pre.next == cur) {
				pre = cur;
			} else {
				pre.next = cur.next;
			}
			cur = cur.next;
		}
		return fake.next;
	}
}
