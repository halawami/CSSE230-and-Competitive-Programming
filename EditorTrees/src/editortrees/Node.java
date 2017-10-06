package editortrees;

// A node in a height-balanced binary tree with rank.
// Except for the NULL_NODE (if you choose to use one), one node cannot
// belong to two different trees.

public class Node {

	enum Code {
		SAME, LEFT, RIGHT;
		// Used in the displayer and debug string
		public String toString() {
			switch (this) {
			case LEFT:
				return "/";
			case SAME:
				return "=";
			case RIGHT:
				return "\\";
			default:
				throw new IllegalStateException();
			}
		}
	}

	// The fields would normally be private, but for the purposes of this class,
	// we want to be able to test the results of the algorithms in addition to
	// the
	// "publicly visible" effects

	char element;
	Node left, right; // subtrees
	int rank; // inorder position of this node within its own subtree.
	Code balance = Code.SAME;
	// Node parent; // You may want this field.
	boolean rightDivergence; // if this node is to the right of it's parent
	int rotationCount;
	// Feel free to add other fields that you find useful

	// You will probably want to add several other methods

	// For the following methods, you should fill in the details so that they
	// work correctly

	public Node() {
		this.element = Character.MIN_VALUE;
		this.left = EditTree.Null_Node;
		this.right = EditTree.Null_Node;
	}

	public Node(int rank) {
		this.element = Character.MIN_VALUE;
		this.rank = rank;
		this.left = EditTree.Null_Node;
		this.right = EditTree.Null_Node;
	}

	public Node(char element) {
		this.element = element;
		this.left = EditTree.Null_Node;
		this.right = EditTree.Null_Node;
	}

	public Node(char element, int pos) {
		this.element = element;
		this.left = EditTree.Null_Node;
		this.right = EditTree.Null_Node;
	}

	public Node rotSL(Node parent) {
		EditTree.rotationCounter++;
		Node newParent = parent.right;
		newParent.balance = Code.SAME;
		parent.balance = Code.SAME;
		newParent.rank += (parent.rank + 1);
		parent.right = newParent.left;
		newParent.left = parent;
		System.out.println("SL");
		return newParent;
	}

	public Node rotDL(Node parent) {
		System.out.println("DL");
		return rotSL(rotSR(parent));
	}

	public Node rotSR(Node parent) {
		EditTree.rotationCounter++;
		Node newParent = parent.left;
		newParent.balance = Code.SAME;
		parent.balance = Code.SAME;
		parent.rank -= (newParent.rank + 1);
		parent.left = newParent.right;
		newParent.right = parent;
		System.out.println("SR");
		return newParent;
	}

	public Node rotDR(Node parent) {
		System.out.println("DR");
		return rotSR(rotSL(parent));
	}

	public Info add(char add) {
		if (this == EditTree.Null_Node) {
			return new Info(new Node(add), Code.RIGHT);
		}

		Info i = this.right.add(add);
		this.right = i.node;
		if (i.dir == Code.SAME) {
			return new Info(this, Code.SAME);
		}

		switch (this.balance) {
		case LEFT:
			this.balance = Code.SAME;
			return new Info(this, Code.SAME);
		case SAME:
			this.balance = Code.RIGHT;
			return new Info(this, Code.RIGHT);
		case RIGHT:
			if (i.dir == Code.RIGHT) {
				return new Info(rotSL(this), Code.SAME);
			} else if (i.dir == Code.LEFT) {
				return new Info(rotDL(this), Code.SAME);
			}
		default:
			throw new IllegalStateException();
		}
	}

	public Info addAt(char ch, int pos, Code dir) {
		if (this == EditTree.Null_Node) {
			if (pos == 0) {
				return new Info(new Node(ch), dir);
			}
			throw new IndexOutOfBoundsException();
		}
		Info i;

		if (this.rank < pos) {
			i = this.right.addAt(ch, pos - this.rank - 1, Code.RIGHT);
			this.right = i.node;
		} else {
			this.rank++;
			i = this.left.addAt(ch, pos, Code.LEFT);
			this.left = i.node;
		}

		return this.rotateChecks(i);
	}

	public Info rotateChecks(Info i) {
		if (i.dir == Code.SAME) {
			return new Info(this, Code.SAME);
		}

		else if (i.dir == Code.RIGHT) {
			switch (this.balance) {
			case LEFT:
				this.balance = Code.SAME;
				return new Info(this, Code.SAME);
			case SAME:
				this.balance = Code.RIGHT;
				return new Info(this, Code.RIGHT);
			case RIGHT:
				if (i.dir == Code.RIGHT) {
					return new Info(rotSL(this), Code.SAME);
				} else if (i.dir == Code.LEFT) {
					return new Info(rotDL(this), Code.SAME);
				}
			default:
				throw new IllegalStateException();
			}
		}

		else if (i.dir == Code.LEFT) {
			switch (this.balance) {
			case LEFT:
				if (i.dir == Code.LEFT) {
					return new Info(rotSR(this), Code.SAME);
				} else if (i.dir == Code.RIGHT) {
					return new Info(rotDR(this), Code.SAME);
				}
			case SAME:
				this.balance = Code.LEFT;
				return new Info(this, Code.LEFT);
			case RIGHT:
				this.balance = Code.SAME;
				return new Info(this, Code.SAME);
			default:
				throw new IllegalStateException();
			}
		}
		throw new IllegalStateException();
	}

	public Node get(int pos) {
		if (this == EditTree.Null_Node) {
			throw new IndexOutOfBoundsException();
		}
		if (this.rank < pos) {
			this.right = this.right.get(pos);
		} else {
			this.left = this.left.get(pos);
		}
		return this;
	}

	public int height() {
		if (this == EditTree.Null_Node) {
			return -1;
		}
		return 1 + Math.max(this.left.height(), this.right.height());
	}

	public int size() {
		return -1;
	}

	public void toDebugString(StringBuilder addTo) {
		if (this == EditTree.Null_Node) {
			return;
		}

		addTo.append(this.element);
		addTo.append(this.rank);
		addTo.append(this.balance.toString());
		addTo.append(", ");

		this.left.toDebugString(addTo);

		this.right.toDebugString(addTo);
	}

	public void toString(StringBuilder addTo) {
		if (this == EditTree.Null_Node) {
			return;
		}
		this.left.toString(addTo);
		if (this.element == Character.MIN_VALUE) {

		} else {
			addTo.append(this.element);
		}
		this.right.toString(addTo);
		return;
	}

}