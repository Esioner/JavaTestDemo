package CommonUseClass;

public class BinaryTreeDemo {

	public static void main(String[] args) {
		BinaryTree bTree = new BinaryTree();
		bTree.add(8);
		bTree.add(3);
		bTree.add(3);
		bTree.add(10);
		bTree.add(9);
		bTree.add(1);
		bTree.add(5);
		bTree.add(5);
		bTree.add(6);
		bTree.add(4);
		System.out.println("排序之后的结果");
		bTree.print();
	}

}

class BinaryTree {
	private Node root;

	public void add(Comparable data) {
		Node newNode = new Node();
		newNode.data = data;
		if (root == null) {
			root = newNode;
		} else {
			root.addNode(newNode);
		}
	}

	public void print() {
		this.root.printNode();
	}

	class Node {
		private Comparable data;
		private Node left;
		private Node right;

		public void addNode(Node newNode) {
			// 确定是放在左子树还是右子树
			if (newNode.data.compareTo(this.data) < 0) {
				// 放在左子树
				if (this.left == null) {//判断左子树是否存在，不存在直接赋值，否则递归
					this.left = newNode;
				} else {
					this.left.addNode(newNode);
				}
			}
			if (newNode.data.compareTo(this.data) >= 0) {
				if (this.right == null) {
					this.right = newNode;
				} else {
					this.right.addNode(newNode);
				}
			}
		}

		public void printNode() {
			if (this.left != null) {
				this.left.printNode();
			}
			System.out.print(this.data + "\t");
			if (this.right != null) {
				this.right.printNode();
			}
		}
	}
}
