import java.util.HashMap;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Tester<T> {
	
	String myString;
	
	@BeforeEach
	public void setUp() {
//		myString = "Eerie eyes seen near lake.";
		myString = "eeyjjjj";
	}

	@Test
	public void testHuffmanFrequencyTable() {
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		map.put('E',1);
		map.put('y',1);
		map.put('i',1);
		map.put('k',1);
		map.put('l',1);
		map.put('.',1);
		map.put('r',2);
		map.put(' ',4);
		map.put('a',2);
		map.put('s',2);
		map.put('n',2);
		map.put('e',8);
		
		HashMap<Character,Integer> result = HuffmanFrequencyTable.frequencyTable(myString);
//		assert(map.equals(result));
	}
	
	@Test 
	public void testArrayHeapAdd() {
		HashMap<Character,Integer> result = HuffmanFrequencyTable.frequencyTable(myString);
		ArrayHeap<HuffmanTreeNode<T>> myArr = new ArrayHeap<HuffmanTreeNode<T>>();
		for (char c : result.keySet()) {
			HuffmanTreeNode<T> newNode = new HuffmanTreeNode<T>(c,result.get(c));
			myArr.add(newNode);
		}
//		myArr.printArray();
	}
	
	@Test 
	public void testArrayHeapRemove() throws Exception {
		HashMap<Character,Integer> result = HuffmanFrequencyTable.frequencyTable(myString);
		ArrayHeap<HuffmanTreeNode<T>> myArr = new ArrayHeap<HuffmanTreeNode<T>>();
		for (char c : result.keySet()) {
			HuffmanTreeNode<T> newNode = new HuffmanTreeNode<T>(c,result.get(c));
			myArr.add(newNode);
		}
		myArr.removeMin();
		myArr.removeMin();
//		myArr.printArray();
	}
	
	
	@Test void testHuffmanTree() throws Exception {
		HuffmanTree tree = new HuffmanTree(myString);
		tree.toString();
		PriorityQueue queue = tree.myQueue;
		queue.printArray();
//		System.out.println(tree.search('E'));
//		System.out.println('E' == 'E');
	}
}
