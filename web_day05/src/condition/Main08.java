package condition;

public class Main08 {
	public static void main(String[] args) {
		/*
		 * A, B, C 등급 -> PASS 
		 * 나머지등급 -> Not-pass 
		 * switch-case문 이용
		 */

		char grade = 'B';

		switch (grade) {
		case 'A':
		case 'B':
		case 'C':
			System.out.println("Pass");
			break;
		default:
			System.out.println("Not-pass");
			break;
		}
	}
}
