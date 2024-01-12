package condition;

public class Main07 {
	public static void main(String[] args) {
		String grade = "B";

		/*
		 * A : 91~100점 사이 
		 * B : 81~90점 사이 
		 * C : 71~80점 사이 
		 * 나머지 : 70점 이하
		 */

		switch (grade) {
		case "A":
			System.out.println("91~100점 사이");
//			break;
		case "B":
			System.out.println("81~90점 사이");
//			break;
		case "C":
			System.out.println("71~80점 사이");
		default:
			System.out.println("70점 이하");
//			break;
		}
	}
}
