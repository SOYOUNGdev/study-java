package loop;

public class Main04 {
	public static void main(String[] args) {
		/*
		 * 구구단 7단
		 * 7 * 1 = 7
		 * 7 * 2 = 14
		 * ...
		 * 7 * 9 = 63
		 * while문을 사용해서 구구단 7단의 결과만 출력하기
		 */
		
		int result = 0;
		
		int i = 0;
		while(i < 9) {
			i++;
			result = 7 * i;
			System.out.println("7 * " + i + " = " + result);
		}
	}
}
