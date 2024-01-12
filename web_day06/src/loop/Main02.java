package loop;

public class Main02 {
	public static void main(String[] args) {
		/*
		 * 구구단 7단
		 * 7 * 1 = 7
		 * 7 * 2 = 14
		 * ...
		 * 7 * 9 = 63
		 * for문을 사용해서 구구단 7단의 결과만 출력하기
		 */
		
		// 결과값을 담을 변수
		int result = 0;
		
		for(int i = 0; i < 9; i++) {
			result = 7 * (i + 1);
			System.out.println("7 * " + (i + 1) + " = " + result);
		}
	}
}
