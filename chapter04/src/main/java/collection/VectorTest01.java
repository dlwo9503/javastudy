package collection;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest01 {

	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();
		
		v.addElement("둘리");
		v.addElement("마이콜");
		v.addElement("또치");
		
		// 순회1, 예전 방식
		int count = v.size();
		for (int i = 0; i < count; i++) {
			String s = v.elementAt(i);
			System.out.println(s);
		}
		// 삭제
		v.removeElementAt(2);
		
		// 순회2
		Enumeration<String> e = v.elements();
		while(e.hasMoreElements()) { // 인자가 있는동안 반복
			String s = e.nextElement();
			System.out.println(s);
		}
	}

}
