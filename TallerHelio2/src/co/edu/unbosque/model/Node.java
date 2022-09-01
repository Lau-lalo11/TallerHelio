package co.edu.unbosque.model;



public class Node {
	 Long key;
     Node left, right;

     public Node()
     {
      
     }
     
     public Node(Long item)
     {
         key = item;
         left = right = null;
     }

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
     
     
}
