package easy;

import java.util.LinkedList;
import java.util.Queue;

import util.TreeNode;

public class InvertBinaryTree226 {

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		} else {
			TreeNode node = root.left;
			root.left = root.right;
			root.right = node;
			invertTree(root.left);
			invertTree(root.right);
			return root;
		}
	}

	public TreeNode invertTree2(TreeNode root) {
		if (root == null) {
			return root;
		}

		Queue<TreeNode> level = new LinkedList<>();
		level.add(root);
		while (!level.isEmpty()) {
			int size = level.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = level.poll();
				TreeNode temp = node.left;
				node.left = node.right;
				node.right = temp;
				if (node.left != null) {
					level.add(node.left);
				}

				if (node.right != null) {
					level.add(node.right);
				}
			}
		}
		
		return root;
	}
}
