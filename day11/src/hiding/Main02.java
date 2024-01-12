package hiding;

class Student {
	// 은닉된 멤버변수 -> 현재 class 블록 안에서만 접근 가능
	private String name = "자바학생";
	private int age;

	// 단축키 : alt + shift + s -> r -> alt + a -> alt + r
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age >= 0) {
			this.age = age;
		} else {
			this.age = 0;
		}
	}
}

public class Main02 {
	public static void main(String[] args) {
		Student std = new Student();
		std.setAge(20);
		std.setName("Java학생");

		System.out.println("나이 : " + std.getAge());
		System.out.println("이름 : " + std.getName());

	}
}
