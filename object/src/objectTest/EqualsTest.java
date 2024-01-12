package objectTest;

import java.util.Random;

public class EqualsTest {
	public static void main(String[] args) {
		// 값이 constant pool에 할당되면 주소가 생긴다.
		// 그 값의 주소가 연산 시 먼저 사용된다.
		String data1 = "ABC";	// constant pool이라는 상수저장공간에 주소값 할당되어 저장
		String data2 = "ABC";	// 같은 문자열 -> 주소값 공유
		
		// 필드의 주소가 연산 시 먼저 사용된다.
		String data3 = new String("ABC");	// 새로운 필드생성
		String data4 = new String("ABC");	// 새로운 필드생성
		
		System.out.println(data1 == data2);	// 주소값비교(공유하고있음->true)
		System.out.println(data1.equals(data2));	// 주소값비교
		
		System.out.println(data3 == data4);	// 주소값비교(서로 다른 필드 -> false)
		System.out.println(data3.equals(data4));	// 문자열값 비교
		
//		Random r1 = new Random();
//		Random r2 = new Random();
//		
//		System.out.println(r1);
//		System.out.println(r2);
//		
//		System.out.println(r1 == r2);
//		System.out.println(r1.equals(r2));
//		
//		r1 = r2;
//		
//		System.out.println(r1 == r2);
//		System.out.println(r1.equals(r2));
		
	}
	
}
