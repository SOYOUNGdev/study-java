package hiding;

public class Member {

	private String name;
	private int age;

	// 단축키 : alt + shift + s -> o -> alt + r
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}

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
		this.age = age;
	}
}
