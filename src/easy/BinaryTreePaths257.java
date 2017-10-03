package easy;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

public class BinaryTreePaths257 {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> list = new ArrayList<>();
		if (root == null) {
			return list;
		}

		getPaths(root, list, "");
		return list;
	}

	private void getPaths(TreeNode root, List<String> list, String cur) {
		if (!cur.isEmpty()) {
			cur += "->";
		}
		cur += String.valueOf(root.val);

		if (root.left == null && root.right == null) {
			list.add(cur);
			return;
		}

		if (root.left != null) {
			getPaths(root.left, list, cur);
		}

		if (root.right != null) {
			getPaths(root.right, list, cur);
		}
	}
}
