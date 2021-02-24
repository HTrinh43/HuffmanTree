
public class ArrayHeap <T>{
	
	protected HuffmanTreeNode<T>[] myArr;
	private final int CAPACITY = 16;
	private int count;
	private int ROOT = 0;
	
	@SuppressWarnings("unchecked")
	public ArrayHeap() {
//		myArr = (HuffmanTreeNode[]) new Object[CAPACITY];
		myArr = new HuffmanTreeNode[CAPACITY];
		count = 0;
	}
	
	protected void expandSize() {
		@SuppressWarnings("unchecked")
		HuffmanTreeNode<T>[] temp = new HuffmanTreeNode[myArr.length * 2];
		for (int i = 0; i < myArr.length; i++) {
			temp[i] = myArr[i];
		}
		myArr = temp;
	}
	
	//true if the arr is empty
	public boolean isEmpty() {
		return count == 0;
	}
	
	//return size of the heap
	public int size() {
		return count;
	}
	
	public void add(HuffmanTreeNode<T> newNode) {
		if (count == this.myArr.length)
			this.expandSize();
		this.myArr[count] = (HuffmanTreeNode<T>) newNode;
		this.heapifyAdd();
		count++;
	}

	
	@SuppressWarnings("unchecked")
	public T removeMin() throws Exception {
		//set the root = null
		// move the last element to the root 
		// start heapify
		//if the left index or the right index > count, break out the loop 
		//if the parent > left or right, swap
		//update the current node index
		if (this.isEmpty())
			throw new Exception("Array is empty");
		HuffmanTreeNode<T> temp = this.myArr[0];
		this.myArr[ROOT] = this.myArr[count-1];
		count--;
		heapifyRemove();

		return (T) temp;
	}
	
	public void heapifyAdd() {
		HuffmanTreeNode<T> lastNode = this.myArr[count];
		//add new node to the end of the array
		int lastNodeIndex = count; 
		int parentIndex = (count - 1)/2;
		//start a loop
		//compare it to its parent
		while (lastNode.compareTo(this.myArr[parentIndex])== 1) {
			
			swap(lastNodeIndex, parentIndex);
			lastNodeIndex = parentIndex;

			parentIndex = (lastNodeIndex - 1)/2;
			lastNode = this.myArr[lastNodeIndex];

		}
		// if it is greater than its parent, swap
		//recalculate newNodeIndex and parent index
		//end the loop if the index < 0  the child < parent
	}
	
	public void heapifyRemove() {
		int curr = ROOT;
		int left = curr*2+1;
		int right = curr*2+2;
		while( !(curr >= count/2 && curr <= count) &&
			 (this.myArr[curr].compareTo(this.myArr[left]) == -1 ||
			  this.myArr[curr].compareTo(this.myArr[right]) == -1 )) {
			
			if (this.myArr[left].compareTo(this.myArr[right]) == -1) {
				swap(curr, right);
				curr = right;
			}
			else {
				swap(curr, left);
				curr = left;
			}
			left = curr * 2 + 1; 
			right = curr * 2 + 2; 
		}
	}
	
	protected void sort() {
		int n = this.myArr.length;
		
	}
	
	private void swap(final int index1, final int index2) {
		final HuffmanTreeNode<T> temp = (HuffmanTreeNode<T>) this.myArr[index1];
		this.myArr[index1] = this.myArr[index2];
		this.myArr[index2] = temp;
	}
	
	
	public void printArray() {
		for (int i = 0; i < this.count; i++) {
			System.out.print(this.myArr[i].toString() + " | ");
		}
		System.out.println();
	}
}
