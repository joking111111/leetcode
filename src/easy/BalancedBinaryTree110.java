package easy;

import util.TreeNode;

public class BalancedBinaryTree110 {
	public int depth(TreeNode node) {
		if (node == null) {
			return 0;
		}

		int ldep = depth(node.left);
		if (ldep == -1) {
			return -1;
		}

		int rdep = depth(node.right);
		if (rdep == -1) {
			return -1;
		}

		if (Math.abs(ldep - rdep) > 1) {
			return -1;
		}

		return Math.max(ldep, rdep) + 1;
	}

	public boolean isBalanced(TreeNode root) {
		return depth(root) != -1;
	}
}
