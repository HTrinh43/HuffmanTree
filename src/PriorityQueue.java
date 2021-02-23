
public class PriorityQueue<T> extends ArrayHeap<T> {

	public PriorityQueue() {
		super();
	}
	
	public void addElement(T object) {
		this.add(object);
	}
	
	public T removeNext() throws Exception{
		return this.removeMin();
	}
}
