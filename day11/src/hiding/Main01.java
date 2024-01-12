package hiding;

class User { 
	public String name = "사용자";
	private int age = 20;
}

public class Main01 {
	public static void main(String[] args) {
		User user = new User();
		
		// public이므로 접근 가능
		System.out.println(user.name);
		// private이므로 접근 불가능
//		System.out.println(user.age);
		
	}
}
