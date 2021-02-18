import java.util.HashMap;

public class HuffmanTree<T> {
	public PriorityQueue<HuffmanTreeNode> myQueue;
	private HuffmanTreeNode<T> root;
	public HuffmanTree(final String input) throws Exception {
		this.myQueue = new PriorityQueue<HuffmanTreeNode>();
		this.buildAQueue(input);
		this.root = this.buildHuffmanTree();
		
	}
	
	private <T> void buildAQueue(final String input) {
		HashMap<Character,Integer> result = HuffmanFrequencyTable.frequencyTable(input);
		for (char c: result.keySet()) {
			HuffmanTreeNode<T> newNode = new HuffmanTreeNode<T>(c,result.get(c));
			this.myQueue.addElement(newNode);
		}
	}
	
	private <T> void buildATree() throws Exception {
		HuffmanTreeNode<T> node1 = this.myQueue.removeNext();
		HuffmanTreeNode<T> node2 = this.myQueue.removeNext();
		HuffmanTreeNode<T> newNode = new HuffmanTreeNode<T>(node1.getFrequency() + node2.getFrequency());

		newNode.setLeft(node1);
		newNode.setRight(node2);
		this.myQueue.addElement(newNode);
	}
	
	private  <T> HuffmanTreeNode<T> buildHuffmanTree() throws Exception {
		while (this.myQueue.size() > 1) {
			this.buildATree();
		}
		return this.myQueue.removeNext();
	}
	
	public  HuffmanTreeNode<T> getRoot(){
		return this.root;
	}
	
	public String toString() {
		preorderTraversal(this.root);
		return "";
	}
	
	private void preorderTraversal(HuffmanTreeNode<T> node) {
		if (node!=null) {
			System.out.print(node.toString() + " ");
			preorderTraversal(node.getLeft());
			preorderTraversal(node.getRight());
		}
	}
	

	public String search(final char input) {
		String result = "";
		this.search(input, root, "", result);
		return result;
	}
	
	private void search(final char input, HuffmanTreeNode node, String code, String result) {
		String temp = code;
		if (node!=null ) {
			search(input, node.getLeft(), code + "0", result);
			System.out.println(code);
			code = temp;
			search(input, node.getLeft(), code + "1", result);
			System.out.println(code);
			
			//if the character is found, set the code to the result
			if (node.getChar() ==  input) {
				result = code;
				System.out.println("found");
			}
			
		}
		
	}
}
