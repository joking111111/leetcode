package easy;

import java.util.LinkedList;
import java.util.Queue;

import util.TreeNode;

public class MinimumDepthofBinaryTree111 {
	
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		} else if (root.left != null && root.right != null) {
			return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
		} else {
			return minDepth(root.left) + minDepth(root.right) + 1;
		}
	}

	public int minDepth2(TreeNode root) {
		if (root == null) {
			return 0;
		}

		Queue<TreeNode> level = new LinkedList<>();
		int depth = 0;
		level.add(root);
		while (!level.isEmpty()) {
			depth++;
			int size = level.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = level.poll();
				if (node.left == null && node.right == null) {
					return depth;
				} else {
					if (node.left != null) {
						level.add(node.left);
					}

					if (node.right != null) {
						level.add(node.right);
					}
				}
			}
		}
		return depth;
	}
}
