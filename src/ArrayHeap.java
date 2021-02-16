
public class ArrayHeap <T>{
	
	protected HuffmanTreeNode<T>[] myArr;
	private final int CAPACITY = 16;
	private int count;
	
	public ArrayHeap() {
		myArr = (HuffmanTreeNode<T>[]) new Object[CAPACITY];
		count = 0;
	}
	
	protected void expandSize() {
		HuffmanTreeNode<T>[] temp = (HuffmanTreeNode<T>[]) new Object[myArr.length * 2];
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
	
	public void add(T object) {
		if (count == this.myArr.length)
			this.expandSize();
		this.myArr[count] = (HuffmanTreeNode<T>) object;
		count++;
	}

	
	public T removeMin() throws Exception {
		//set the root = null
		// move the last element to the root 
		// start heapify
		//if the left index or the right index > count, break out the loop 
		//if the parent > left or right, swap
		//update the current node index
		if (this.isEmpty())
			throw new Exception("Array is empty");
		swap(count,0);
		T temp = (T) this.myArr[count-1];
		heapifyRemove();
		count--;
		return temp;
	}
	
	public void heapifyAdd() {
		HuffmanTreeNode<T> lastNode = this.myArr[count];
		//add new node to the end of the array
		int lastNodeIndex = count;
		int parentIndex = (count - 1)/2;
		//start a loop
		//compare it to its parent
		while (parentIndex >= 0 && lastNode.compareTo(this.myArr[parentIndex])== -1) {
			swap(lastNodeIndex, parentIndex);
			lastNodeIndex = parentIndex;
			parentIndex = (lastNodeIndex - 1)/2;
		}
		// if it is greater than its parent, swap
		//recalculate newNodeIndex and parent index
		//end the loop if the index < 0  the child < parent
	}
	
	public void heapifyRemove() {
		int curr = 0;
		int left = curr*2+1;
		int right = curr*2+2;
		while(curr < count && (this.myArr[curr].compareTo(this.myArr[left]) == 1 ||
				this.myArr[curr].compareTo(this.myArr[right]) == 1 )) {
			if (this.myArr[left].compareTo(this.myArr[right]) == -1) {
				swap(curr, left);
				curr = left;
			}
			else {
				swap(curr, right);
				curr = right;
			}
			left = curr * 2 + 1 < count ? curr * 2 + 1 : 0;
			right = curr * 2 + 2 < count ? curr * 2 + 2 : 0;
		}
	}
	
	private void swap(final int index1, final int index2) {
		HuffmanTreeNode<T> temp = (HuffmanTreeNode<T>) this.myArr[index1];
		this.myArr[index1] = this.myArr[index2];
		this.myArr[index2] = temp;
	}
}
