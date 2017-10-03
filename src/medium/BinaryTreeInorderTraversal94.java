package medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;

public class BinaryTreeInorderTraversal94 {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();
		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				list.add(root.val);
				root = root.right;
			}
		}

		return list;
	}
}
