import java.util.HashMap;

public class HuffmanTree<T>  {
	public PriorityQueue<HuffmanTreeNode<T>> myQueue;
	private HuffmanTreeNode<T> root;
	private HashMap<Character, String> encodingMap = new HashMap<Character, String>();
	
	public HuffmanTree(final String input) throws Exception {

		this.myQueue = new PriorityQueue<HuffmanTreeNode<T>>();
		this.buildAQueue(input);
		this.root = this.buildHuffmanTree();

	}
	
	private <T> void buildAQueue(final String input) {
		HashMap<Character,Integer> result = HuffmanFrequencyTable.frequencyTable(input);
		for (char c: result.keySet()) {
			HuffmanTreeNode newNode = new HuffmanTreeNode<T>(c,result.get(c));
			this.myQueue.addElement(newNode);
		}
	}
	
	@SuppressWarnings("unchecked")
	private <T> void buildATree() throws Exception {
		HuffmanTreeNode<T> node1 = (HuffmanTreeNode<T>) this.myQueue.removeNext();
		HuffmanTreeNode<T> node2 = (HuffmanTreeNode<T>) this.myQueue.removeNext();
		HuffmanTreeNode newNode = new HuffmanTreeNode<T>(node1.getFrequency() + node2.getFrequency());

		newNode.setLeft(node1);
		newNode.setRight(node2);
		this.myQueue.addElement(newNode);
	}
	
	@SuppressWarnings("unchecked")
	private  <T> HuffmanTreeNode<T> buildHuffmanTree() throws Exception {
		while (this.myQueue.size() > 1) {
			this.buildATree();
		}
		return (HuffmanTreeNode<T>) this.myQueue.removeNext();
	}
	
	public  HuffmanTreeNode<T> getRoot(){
		return this.root;
	}
	
	@Override
	public String toString() {
		System.out.println("Preorder");
		preorderTraversal(this.root);
		System.out.println();
		System.out.println("Inorder");
		inorderTraversal(this.root);
		System.out.println();
		
		for (final char c : this.encodingMap.keySet()) {
			System.out.println(c + ": " + this.encodingMap.get(c));
		}
		return "";
	}
	
	private void preorderTraversal(final HuffmanTreeNode<T> node) {
		if (node!=null) {
			System.out.print(node.toString() + ", ");
			preorderTraversal(node.getLeft());
			preorderTraversal(node.getRight());

		}
	}
	
	private void inorderTraversal(final HuffmanTreeNode<T> node) {
		if (node != null) {
		inorderTraversal(node.getLeft()); 
        System.out.print(node.toString() + ", "); 
        inorderTraversal(node.getRight()); 
		} 
	}
}
