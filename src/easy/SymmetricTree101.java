package easy;

import java.util.Stack;

import util.TreeNode;

public class SymmetricTree101 {
	
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}

		return check(root.left, root.right);
	}

	public boolean check(TreeNode l, TreeNode r) {
		if (l == null && r == null) {
			return true;
		} else if (l == null || r == null || l.val != r.val) {
			return false;
		} else {
			return check(l.left, r.right) && check(l.right, r.left);
		}
	}
	
	public boolean isSymmetric2(TreeNode root) {
		Stack<TreeNode> lStack = new Stack<>();
		Stack<TreeNode> rStack = new Stack<>();
		TreeNode l = root;
		TreeNode r = root;

		while ((l != null && r != null) || (!lStack.isEmpty() && !rStack.isEmpty())) {
			while (l != null && r != null) {
				if (l.val != r.val) {
					return false;
				}
				lStack.push(l);
				rStack.push(r);
				l = l.left;
				r = r.right;
			}

			if (l != null || r != null) {
				return false;
			}
			l = lStack.pop().right;
			r = rStack.pop().left;
		}

		return true;
	}
}
