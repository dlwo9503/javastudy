package chapter04;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		Set<Rect> set = new HashSet<>();
		
		Rect r1 = new Rect(10, 20);
		Rect r2 = new Rect(10, 20);
		
		set.add(r1);
		set.add(r2);
		
		for(Rect rect : set) {
			System.out.println(rect);
		}
	}

}

// HashCode를 오버라이드 안해주고 실행하게되면 중복제거가 안됨
// HashCode를 오버라이드 해주고 실행하게되면 중복제거가 되어서 같은건 한번만 나옴
