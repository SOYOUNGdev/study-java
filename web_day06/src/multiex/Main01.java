package multiex;

public class Main01 {
	public static void main(String[] args) {
		int point = 75;
		
		/*
		 * 77점 초과 	: C+ 등급
		 * 74점 미만 	: C- 등급
		 * 그 외 		: C0 등급
		 */
		if(point > 70 && point <= 80) {
//			System.out.println("C등급입니다.");
			if(point > 77) {
				System.out.println("C+ 등급입니다");
			} else if(point < 74) {
				System.out.println("C- 등급입니다");
			} else {
				System.out.println("C0 등급입니다");
			}
		}
	}
}
