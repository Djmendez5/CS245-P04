package practice4;

public class ArrayQueue implements Queue {
 int head;
 int tail;
 public static final int SIZE = 10;
 private Object [] arr;

 public ArrayQueue() {
	 arr = new Object[SIZE];
	 head =0;
	 tail =0;
 }
 
 @Override
	public Object dequeue() {
		if(empty()) {
		return null;
	}
 Object item =  arr[head];
 head++;
 if(head ==arr.length) {
	 head =0;
 }
 return item;
 }
	@Override
	public void enqueue(Object item) {
		if(full()) {
			grow_queue();
		}
		arr[tail++]= item;
		if(tail == arr.length) {
			tail=0;
		}
	}

	@Override
	public boolean empty() {
		if(head==tail) {
		return true;
		}
		else {
			return false;
		}
		}
	private boolean full() {
		if((tail+1) % arr.length==head)
			return true;
		else
			return false;
	}
private void grow_queue() {
	Object[] new_arr = new Object[arr.length*2];
	if(tail<head) {
	System.arraycopy(arr, head, new_arr, 0, arr.length-head);
	System.arraycopy(arr, tail, new_arr, 0, head-tail);
	head = 0;
	tail = arr.length -1;
	arr= new_arr;
	}
	else {
		System.arraycopy(arr, 0, new_arr, 0, arr.length);
	arr = new_arr;
	}
}

}