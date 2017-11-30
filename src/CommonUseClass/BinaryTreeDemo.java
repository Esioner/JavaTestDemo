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
		System.out.println("����֮��Ľ��");
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
			// ȷ���Ƿ�������������������
			if (newNode.data.compareTo(this.data) < 0) {
				// ����������
				if (this.left == null) {//�ж��������Ƿ���ڣ�������ֱ�Ӹ�ֵ������ݹ�
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
