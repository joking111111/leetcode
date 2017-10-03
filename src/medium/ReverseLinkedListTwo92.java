package medium;

import util.ListNode;

public class ReverseLinkedListTwo92 {

	/**
	 * 逐一取出链头元素，使用头插法构建新链表
	 * @param head
	 * @param m
	 * @param n
	 * @return
	 */
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null) {
			return head;
		}

		ListNode cur = head;
		ListNode pre = null;
		ListNode left = null, pos = null;
		int cnt = 1;
		while (cnt < m) {
			pre = cur;
			cur = cur.next;
			cnt++;
		}

		left = pre;
		pos = cur;
		while (cnt <= n) {
			ListNode temp = cur;
			cur = cur.next;
			temp.next = pre;
			pre = temp;
			cnt++;
		}

		if (left != null) {
			left.next = pre;
		} else {
			head = pre;
		}
		pos.next = cur;
		return head;
	}
}
