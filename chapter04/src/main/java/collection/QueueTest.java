package collection;

import java.util.LinkedList;
import java.util.Queue;

// Queue 의 경우에는 넣을때 offer, 뺄때 pool
public class QueueTest {
	public static void main(String[] args) {
		Queue<String> q = new LinkedList<>();
		
		q.offer("마이콜");
		q.offer("또치");
		q.offer("둘리");
		
		while(!q.isEmpty()) {
			String s = q.poll();
			System.out.println(s);
		}
		
		q.offer("마이콜");
		q.offer("또치");
		q.offer("둘리");
		
		System.out.println(q.poll());
		System.out.println(q.peek()); // 제일 앞에꺼 return
		System.out.println(q.poll());
	}
}
