package chapter03;

public class Swaptest03 {

	public static void main(String[] args) {
		Value a = new Value(); // 이 객체는 힙영역에 만들어짐.
		Value b = new Value();
		a.val = 10;
		b.val = 20;
		
		System.out.println(a.val + ":" + b.val);
		
		swap(a, b);
		
		System.out.println(a.val + ":" + b.val);

	}
	
	public static void swap(Value p, Value q) {
		int temp = p.val;
		p.val = q.val;
		q.val = temp;
	}

}

// 이런식으로 객체를 만들어서 스왑을 하게되면 콜 바이 레퍼런스 방식으로 스왑
// 객체는 힙영역에서 활동하기 때문임.