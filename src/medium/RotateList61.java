package medium;

import util.ListNode;

public class RotateList61 {

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || k == 0) {
			return head;
		}

		ListNode fast = head;
		ListNode slow = head;
		ListNode newHead = null;
		int cnt = 0;
		while (fast != null && cnt < k) {
			fast = fast.next;
			cnt++;
		}

		if (fast == null) {
			k = k % cnt;
			cnt = 0;
			fast = head;
			while (fast != null && cnt < k) {
				fast = fast.next;
				cnt++;
			}
		}

		while (fast != null) {
			if (fast.next == null) {
				ListNode temp = slow;
				fast.next = head;
				newHead = slow.next;
				temp.next = null;
				break;
			}

			fast = fast.next;
			slow = slow.next;
		}

		return newHead;
	}
}
