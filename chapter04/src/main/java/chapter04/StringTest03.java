package chapter04;

public class StringTest03 {

	public static void main(String[] args) {
		String s = "aBcABCabcabC";
		
		System.out.println(s.length());
		System.out.println(s.charAt(2)); // 문자 뽑아오기
		System.out.println(s.indexOf("abc")); // 문자 찾기, 위치 리턴해줌, 탐
		System.out.println(s.indexOf("abc", 3)); // 탐색위치 지정, 3 인덱스부터 탐색함
		System.out.println(s.indexOf("abc", 7)); // 탐색위치 지정, 7 인덱스부터 탐색함, 못찾으면 -1 리턴함
		System.out.println(s.substring(3)); // 문자열 뽑아오기
		System.out.println(s.substring(3, 5)); // 끝을 지정하면 5-1 번째 인덱스까지 탐
		
		String s2 = "     ab    cd    ";
		String s3 = "efg,hijk,lmn,opqr";
		
		String s4 = s2.concat(s3);
		System.out.println(s4);
		
		System.out.println("----" + s2.trim() + "----"); // trim은 스페이스 공백 제거 (앞이랑 뒤만 지움)
		System.out.println("----" + s2.replaceAll(" ", "") + "----"); // " " -> "" 로 모두 변환시켜라
		
		// regular expression (정규표현식 사용 예)
		String p = "123456789";
		if(p.matches("\\d+")) { // 양수만 표시한 정규표현식 1 ~ 무한, matches를 이용해서 검증
			int price = Integer.parseInt(p); // String -> int
			System.out.println(price);
		} else {
			System.out.println("유효한 금액이 아닙니다.");
		}
		
		String[] tokens1 = s3.split(","); // 문자열을 () 기준으로 잘라서 token에 넣음
		for (String token : tokens1) {
			System.out.println(token);
		}
		
		String[] tokens2 = s3.split(" ");
		for (String token : tokens2) {
			System.out.println(token);
		}
		
		StringBuffer sb = new StringBuffer(""); // 버퍼 사이즈를 잡을 수 있음 ex) (1000), "" : 기본사이즈
		sb.append("Hello ");
		sb.append("World ");
		sb.append("Java ");
		sb.append(1.8);
		
		String s5 = sb.toString(); // sb를 String로 변환
		System.out.println(s5);
		
//		String s6 = "Hello " + "World " + "Java " + 1.8;
		String s6 = new StringBuffer("Hello ").append("World ")
				.append("Java ").append("1.8").toString(); // 이렇게 연달아 메소드를 뭍이는걸 메소드 체인이라고 함
		System.out.println(s6);
		
		// 주의: 문자열 + 연산을 하지 말아야 할 때
//		String s7 = "";
//		for (int i = 0; i < 100000; i++) {
//			s7 += i;
////			s7 = new StringBuffer(s7).append(i).toString();
//		}
		
		// 위 코드와는 다르게 new를 한번만 하기 때문에 오래 안걸림
		StringBuffer sb3 = new StringBuffer("");
		for (int i = 0; i < 1000000; i++) {
			sb3.append(i);
		}
		String s7 = sb3.toString();
		System.out.println(s7.length());
	}

}
