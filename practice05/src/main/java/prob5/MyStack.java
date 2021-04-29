package prob5;

import prob5.MyStackException;

public class MyStack{
	private String[] data;
	private int top = -1;

	public MyStack(int size) {
		data = new String[size];
	}

	public void resize(int size) {
		String[] resizeData = new String[size];
		for (int i = 0; i < top + 1; i++) {
			resizeData[i] = data[i];
		}
		data = resizeData;
	}

	public void push(String data2) {
//		resize(); 이런 메소드를 만들어야 함, 보통 2배정도?, 리사이징하는게 중요
		if (data.length == top + 1) {
			resize(2 * data.length); // 2배로 늘림
		}
		data[++top] = data2;
	}

	public String pop() throws MyStackException {
		if (top == -1) {
			throw new MyStackException();
		}
		String s = data[top];
		top--;
		return s;
	}

	public boolean isEmpty() {
		if (top == -1) {
			return true;
		} else {
			return false;
		}
	}
}