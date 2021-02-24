
public class PriorityQueue<T> extends ArrayHeap<T> {
/**
 * Priority queue class extends from ArrayHeap class
 */
	public PriorityQueue() {
		super();
	}
	
	public void addElement(HuffmanTreeNode<T> newNode) {
		/**
		 * add element to Priority Queue
		 * pram newNode: new node
		 */
		this.add(newNode);
	}
	
	public T removeNext() throws Exception{
		return this.removeMin();
	}
}
