
public class HuffmanTreeNode <T> {

	private char myChar;
	private int myFrequency;
	private  HuffmanTreeNode<T> myLeft, myRight;
	
	public HuffmanTreeNode() {}
	
	public HuffmanTreeNode(final char character, final int frequency) {
		this.myChar = character;
		this.myFrequency = frequency;
	}
	
	public HuffmanTreeNode(final int freequency) {
		this.myFrequency = freequency;
		this.myChar = ' ';
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
	
	public int getFrequency() {
		return this.myFrequency;
	}
	
	public int getChar() {
		return this.myChar;
	}
	@Override
	public String toString() {
		return this.myChar + " : " + this.myFrequency;
	}
}


