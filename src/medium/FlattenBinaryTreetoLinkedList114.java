package medium;

import util.TreeNode;

public class FlattenBinaryTreetoLinkedList114 {
	public void flatten(TreeNode root) {
		while (root != null) {
			if (root.left != null) {//当前节点有左子树
				if (root.right != null) {//当前节点有右子树
					TreeNode node = root.left;
					while (node.right != null) {
						node = node.right;
					}
					node.right = root.right;//右子树直接接到左子树最右侧
				}
				root.right = root.left;//左子树移到右边
				root.left = null;
			}
			root = root.right;//当前节点没有左子树了
		}
	}
}
