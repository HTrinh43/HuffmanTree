
public class HuffmanTreeNode<T> {

	public T myChar;
	public int myFrequency;
	public  HuffmanTreeNode<T> myLeft, myRight;
	
	public HuffmanTreeNode() {}
	
	public HuffmanTreeNode(final T character, final int frequency) {
		this.myChar = character;
		this.myFrequency = frequency;
	}
	
	public HuffmanTreeNode<T> getLeft() {
		return this.myLeft;
	}
	
	public void setLeft(final HuffmanTreeNode<T> left) {
		this.myLeft = left;
	}
	
	public HuffmanTreeNode<T> getRight() {
		return this.myRight;
	}
	
	public void setRight(final  HuffmanTreeNode<T> right) {
		this.myRight = right;
	}
	
	public int compareTo(final  HuffmanTreeNode<T> node) {
		return this.myFrequency < node.myFrequency ? 1 : -1;
	}
}


