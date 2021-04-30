package chapter04;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance(); // 달력은 new로 생성이 안됨
		printDate(cal);
		
		cal.set(Calendar.YEAR, 2021);
		cal.set(Calendar.MONTH, 11); // -> 12 (month - 1)
		cal.set(Calendar.DATE, 25);
		printDate(cal); // 변경된 날짜 출력
		
		cal.set(2010, 10, 10);
		cal.add(Calendar.DATE, 1000);
		printDate(cal);
	}

	private static void printDate(Calendar cal) {
		final String[] DAYS = {"일", "월", "화", "수", "목", "금", "토"};
		// 년
		int year = cal.get(Calendar.YEAR);
		
		// 월
		int month = cal.get(Calendar.MONTH);
		
		// 일
		int date = cal.get(Calendar.DATE);
		
		// 요일 [1(일) ~ 7(토)]
		int day = cal.get(Calendar.DAY_OF_WEEK);
		
		// 시
		int hour = cal.get(Calendar.HOUR);
		
		// 분
		int minute = cal.get(Calendar.MINUTE);
		
		// 초
		int second = cal.get(Calendar.SECOND);
		
		System.out.printf("%04d년%02d월%02d일%s요일 %02d:%02d:%02d\n", year, month + 1, date, DAYS[day - 1], hour, minute, second);
	}

}
