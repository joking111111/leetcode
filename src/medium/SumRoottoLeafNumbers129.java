package medium;

import util.TreeNode;

public class SumRoottoLeafNumbers129 {
	public int sum(TreeNode root, int num) {
		if (root == null) {
			return 0;
		}
		int cur = num * 10 + root.val;
		if (root.left == null && root.right == null) {
			return cur;
		} else {
			return sum(root.left, cur) + sum(root.right, cur);
		}
	}

	public int sumNumbers(TreeNode root) {
		return sum(root, 0);
	}
}
