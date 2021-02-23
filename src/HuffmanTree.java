import java.util.HashMap;

public class HuffmanTree<T> {
	public PriorityQueue<HuffmanTreeNode> myQueue;
	private HuffmanTreeNode<T> root;
	private HashMap<Character, String> encodingMap = new HashMap<Character, String>();
//	private String HuffmanCode;
	
	
	
	public HuffmanTree(final String input) throws Exception {
//		this.HuffmanCode = "";
		this.myQueue = new PriorityQueue<HuffmanTreeNode>();
		this.buildAQueue(input);
		this.root = this.buildHuffmanTree();
//		this.createEncodingMap();
//		this.createHuffmanCode(input);
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
		System.out.println("Preorder");
		preorderTraversal(this.root);
		System.out.println();
		System.out.println("Inorder");
		inorderTraversal(this.root);
		System.out.println();
		
		for (char c : this.encodingMap.keySet()) {
			System.out.println(c + ": " + this.encodingMap.get(c));
		}
//		System.out.println(this.HuffmanCode);
		return "";
	}
	
	private void preorderTraversal(HuffmanTreeNode<T> node) {
		if (node!=null) {
			System.out.print(node.toString() + ", ");
			preorderTraversal(node.getLeft());
			preorderTraversal(node.getRight());

		}
	}
	
	private void inorderTraversal(HuffmanTreeNode<T> node) {
		if (node != null) {
		inorderTraversal(node.getLeft()); 
        System.out.print(node.toString() + ", "); 
        inorderTraversal(node.getRight()); 
		} 
	
	}
	
//	private void createEncodingMap() {
//		createEncoding(this.root, "");
//	}
//	
//	private void createEncoding(HuffmanTreeNode<T> node, String code) {
//		if (node != null) {
//			if (!node.isSum()){
//				this.encodingMap.put(node.getChar(), code);
//			}
//			createEncoding(node.getLeft(), code + "0"); 
//	        createEncoding(node.getRight(), code + "1"); 
//			} 
//	}
//	
//	private void createHuffmanCode(final String input) {
//		StringBuilder code = new StringBuilder();
//		for (int i = 0; i < input.length(); i++) {
//			if (this.encodingMap.containsKey(input.charAt(i))) {
//				code.append(this.encodingMap.get(input.charAt(i)));
//			}
//		}
//		this.HuffmanCode = code.toString();
//	}
	

	
//	public String getHuffmanCode() {
//		return this.HuffmanCode;
//	}
}
