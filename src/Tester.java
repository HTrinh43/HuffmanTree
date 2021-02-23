import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Tester<T> {
	
	String myString;
//	private HashMap<Character, String> encodingMap = new HashMap<Character, String>();
//	private HuffmanTree<T> tree;
	@BeforeEach
	public void setUp() throws Exception {
		myString = "Eerie eyes seen near lake.";
//		this.tree = new HuffmanTree(myString);
//		myString = "eeyjjjj";
	}

	
	
	@Test void testHuffmanTree() throws Exception {
		this.writeToFile(this.myString);
	}
	
	public String decoding(final HuffmanTreeNode<T> root, String input) {
		StringBuilder result = new StringBuilder();
		final int length = input.length();
		
		HuffmanTreeNode<T> current = root;
		for (int i = 0; i < length; i++) {
			if (input.charAt(i) == '0') {
				current = current.getLeft();
			}
			else {
				current = current.getRight();
			}
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
//		HashMap<Character, String> encodingMap = new HashMap<Character, String>();
//		HuffmanTree<T> tree = new HuffmanTree(input); 
		
		createEncodingMap(node, "",encodingMap);
		
		StringBuilder code = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			if (encodingMap.containsKey(input.charAt(i))) {
				code.append(encodingMap.get(input.charAt(i)));
			}
		}
		return code.toString();
	}
	
	
	public void writeToFile(final String str) throws Exception {
		/**
		 * Write the result to a file
		 * @param list: name of the file that will be written
		 
		 */
		HuffmanTree<T> tree = new HuffmanTree(str);
		HashMap<Character,Integer> frequencyTable = HuffmanFrequencyTable.frequencyTable(str);
		HashMap<Character, String> encodingMap = new HashMap<Character, String>();
		String HuffmanCode = this.encoding(str, tree.getRoot(), encodingMap);
		String decodingCode = this.decoding(tree.getRoot(), str);
		double ratio = (double)HuffmanCode.length()/((double)str.length()*8) * 100;
		
		System.out.println("% java Tester " + str);
		System.out.println("===============================");
		System.out.println("char \t frequency \t code");
		for (char c : frequencyTable.keySet()) {
			System.out.print(c);
			System.out.print("\t");
			System.out.print(frequencyTable.get(c));
			System.out.print("\t");
			System.out.print(encodingMap.get(c));
			System.out.println();
		}
		System.out.println("===============================");
		System.out.println("Encoded bit stream:");
		System.out.println(HuffmanCode);
		System.out.println();
		System.out.println("Total number of bits without Huffman coding (8-bits per character): " + str.length()*8);
		System.out.println("Total number of bits with Huffman coding: " + HuffmanCode.length());
		
		System.out.println("Compression Ratio: " + Math.round(ratio) + "%");
		System.out.println("Decoded String: " + str);
		
//		final String filepath = System.getProperty("user.dir") +"/output/table" + ".txt";
//		try {
//		      File myFile = new File(filepath);
//		      if (myFile.createNewFile()) {
//		        System.out.println("File created: " + myFile.getName());
//		      } 
//		      
//		      BufferedWriter myWriter = new BufferedWriter(new FileWriter(filepath, true));
////		      for (int i = 0; i < list.size(); i++) {
////		    	  myWriter.write((String)list.get(i));
////		    	  myWriter.newLine();
////		      }
//		      myWriter.close();
//		    } catch (IOException e) {
//		      e.printStackTrace();
//		    }
	}
}
