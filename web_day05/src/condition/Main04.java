package condition;

public class Main04 {
	public static void main(String[] args) {
		boolean is_korean = true;
		
		if(is_korean == true) {
			System.out.println("한국사람입니다");
		}
		// 값 자체를 조건에 넣는경우
		if(is_korean) {
			System.out.println("한국사람입니다");
		}
		
		// true -> !true : false
		// !is_korean-> !true -> false
		if(!is_korean) {
			System.out.println("한국사람이 아닙니다");
		}
	}
}
