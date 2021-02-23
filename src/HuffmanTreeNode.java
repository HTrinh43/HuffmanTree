
public class HuffmanTreeNode <T> {

	private char myChar;
	private int myFrequency;
	private  HuffmanTreeNode<T> myLeft, myRight;
	private boolean sum;
	public HuffmanTreeNode() {}
	
	public HuffmanTreeNode(final char character, final int frequency) {
		this.myChar = character;
		this.myFrequency = frequency;
		this.sum = false;
	}
	
	public HuffmanTreeNode(final int freequency) {
		this.myFrequency = freequency;
		this.myChar = ' ';
		this.sum = true;
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
	
	public char getChar() {
		return this.myChar;
	}
	@Override
	public String toString() {
		String str = !this.isSum() && this.myChar == ' ' ? "sp" : this.myChar + "";
		return str + " : " + this.myFrequency;
	}
	
	public boolean isSum() {
		return this.sum;
	}
}


