package practice4;

public class ArrayStack implements Stack {
	public static final int SIZE = 10;
	private Object [] arr;
	private int top;
	//CONSTRUCTOR
	public ArrayStack() {
		arr = new Object[SIZE];
		top = 0;
	}
	public void push(Object item) {
		if(top ==arr.length) {
			grow_stack();
			}
		arr[top++] = item;
	}

	@Override
	public Object pop() {
		if(empty())
		return null;
		else
			return arr[--top];
	}
	@Override
	public Object peek() {
		if(empty())
		return null;
	return arr[top-1];
	}

	@Override
	public boolean empty() {
		if(top==0) {
			return true;
		}
		return false;
	}
 private void grow_stack() {
	 Object[] new_arr = new Object[arr.length*2];
	 System.arraycopy(arr,0, new_arr, 0, arr.length);
	 arr = new_arr;
 }
}
