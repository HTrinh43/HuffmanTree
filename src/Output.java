import java.util.HashMap;

public class Output <T>{
	
	public String decoding(final HuffmanTreeNode<T> root, String input) {
		StringBuilder result = new StringBuilder();
		final int length = input.length();
		
		HuffmanTreeNode<T> current = root;
		for (int i = 0; i < length; i++) {			
			current = input.charAt(i) == '0' ? current.getLeft() : current.getRight();
			if (!current.isSum()) {
				result.append(current.getChar());
				current = root;
			}
		}
		return result.toString();
	}
		
	private void createEncodingMap(HuffmanTreeNode<T> node, String code, HashMap<Character, String> encodingMap) {
		if (node != null) {
			if (!node.isSum()){
				encodingMap.put(node.getChar(), code);
			}
			createEncodingMap(node.getLeft(), code + "0",encodingMap); 
			createEncodingMap(node.getRight(), code + "1",encodingMap); 
			} 
	}
	
	public String encoding(final String input, HuffmanTreeNode<T> node, HashMap<Character, String> encodingMap) throws Exception {		
		createEncodingMap(node, "",encodingMap);
		StringBuilder code = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			if (encodingMap.containsKey(input.charAt(i))) {
				code.append(encodingMap.get(input.charAt(i)));
			}
		}
		return code.toString();
	}
	
	
	public void printoutput(final String str) throws Exception {
		/**
		 * Print the output to console
		 * @param str: the String will be encoded
		 
		 */
		HuffmanTree<T> tree = new HuffmanTree<T>(str);
		HuffmanTreeNode<T> root = tree.getRoot();
		final HashMap<Character,Integer> frequencyTable = HuffmanFrequencyTable.frequencyTable(str);
		final HashMap<Character, String> encodingMap = new HashMap<Character, String>();
		final String huffmanCode = this.encoding(str, root, encodingMap);
		final String decodingCode = this.decoding(root, huffmanCode);
		double ratio = ((double)str.length()*8) /(double)huffmanCode.length()* 100;
//		double ratio = (double)HuffmanCode.length()/((double)str.length()*8) * 100;
		
		System.out.println("% java Tester " + str);
		System.out.println("===============================");
		System.out.println("char \tfrequency \tcode");
		System.out.println("-------------------------------");
		for (char c : frequencyTable.keySet()) {
			String letter = c == ' ' ? "space" : String.valueOf(c);
			System.out.print(letter);
			System.out.print("\t");
			System.out.print(frequencyTable.get(c));
			System.out.print("\t");
			System.out.print(encodingMap.get(c));
			System.out.println();
		}
		System.out.println("===============================");
		System.out.println("Encoded bit stream:");
		System.out.println(huffmanCode);
		System.out.println();
		System.out.println("Total number of bits without Huffman coding (8-bits per character): " + str.length()*8);
		System.out.println("Total number of bits with Huffman coding: " + huffmanCode.length());
		
		System.out.println("Compression Ratio: " + Math.round(ratio) + "%");
		System.out.println("Decoded String: " + decodingCode);
		
	}

}
