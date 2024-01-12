package condition;

public class Main05 {
	public static void main(String[] args) {
		int point = 75;
		
		/*
		 * 90점 초과, 100점 이하 -> A
		 * 80점 초과, 90점 이하 -> B
		 * 70점 초과, 80점 이하 -> C
		 * 나머지는 F
		 */
		if(point > 90 && point <= 100) {
			System.out.println('A');
		} else if(point > 80) {
			System.out.println('B');
		} else if(point > 70) {
			System.out.println('C');
		} else {
			System.out.println('D');
		}
	}

	
}
