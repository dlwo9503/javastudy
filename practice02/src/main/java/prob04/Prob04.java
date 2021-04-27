package prob04;
public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse( "Hello World" );
		printCharArray( c1 );
		
		char[] c2 = reverse( "Java Programming!" );
		printCharArray( c2 );
	}
	
	public static char[] reverse(String str) {
		char[] strArr = str.toCharArray();
		char[] strArr2 = new char[str.length()];
		for (int i = 0; i < strArr2.length; i++) {
			strArr2[i] = strArr[strArr.length - i - 1];
		}
		return strArr2;
	}

	public static void printCharArray(char[] array){
		/* 코드를 완성합니다 */
		System.out.println( array );
	}
}