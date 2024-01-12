package dateTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		Date date = new Date();
		date.setYear(121);	// 1900년부터 시작점이기 때문에 전달한 정수와 더하여 년도가 설정된다.
		date.setMonth(11);	// 월은 0부터 시작한다.
		date.setDate(4);
		
		System.out.println(date);
		
		
//		Date date = new Date();
//		System.out.println(System.currentTimeMillis());
//		System.out.println(date);
		
//		Date today = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
//		System.out.println(sdf.format(today));
//		System.out.println(today);
		
//		현재 날짜를 "년/월/일 시:분:초"로 출력한다.
//		Date today = new Date();
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		System.out.println(simpleDateFormat.format(today));
//		try {
//			Date date = simpleDateFormat.parse("2002/04/20 13:55:25");
//			System.out.println(date);
//		} catch (ParseException e) {;}
//		
//		try {System.out.println(simpleDateFormat.parse("2002/04/20 13:55:25") instanceof Date);} catch (ParseException e) {;}
		
	}
	
}
