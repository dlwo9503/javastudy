package prob5;

public class MyStack {
	private String[] data;
	private int top = -1;
	
	public MyStack(int size) {
		data = new String[size];
	}
	
	public void push(String data) {
		if(data.length() == top) {
//			resize(); 이런 메소드를 만들어야 함, 보통 2배정도?, 리사이징하는게 중
		}
		top++;
	}
	
	public String pop() throws MyStackException {
		
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub 이거도 구
		return false;
	}
}