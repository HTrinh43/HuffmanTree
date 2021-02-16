
public class PriorityQueue<T> extends ArrayHeap<T> {
	private int front;
	private int rear;
	public PriorityQueue() {
		super();
		front = 0;
		rear = 0;
	}
	
	public void addElement(T object) {
		this.add(object);
		front++;
	}
	
//	public <T> removeNext(){
//		
//	}
	

}
