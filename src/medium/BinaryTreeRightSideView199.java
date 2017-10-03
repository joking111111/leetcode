package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import util.TreeNode;

public class BinaryTreeRightSideView199 {
	/**
	 * 广度优先遍历取每层最后一个节点
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (i == size - 1) {
					list.add(node.val);
				}
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
		}

		return list;
	}

	/**
	 * 深度遍历策略,其实就是优先遍历右子数
	 * 无法通过测试。。。
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> rightSideView2(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		rightFirst(root, 0, list);
		return list;
	}

	public void rightFirst(TreeNode node, int level, List<Integer> list) {
		if (node == null) {
			return;
		}
		if (level == list.size()) {
			list.add(node.val);
			rightFirst(node.right, level + 1, list);
			rightFirst(node.left, level + 1, list);
		}
	}
}
