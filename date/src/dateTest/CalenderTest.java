package dateTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalenderTest {
	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();
		System.out.println(today);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(simpleDateFormat.format(today.getTime()));
		
		today.set(2021, 11, 4);		//월은 0부터 시작한다.
		today.set(Calendar.DATE, 20);
		
		System.out.println(simpleDateFormat.format(today.getTime()));
		
		System.out.println(today.get(Calendar.MONTH) + 1);
	}
	
}
