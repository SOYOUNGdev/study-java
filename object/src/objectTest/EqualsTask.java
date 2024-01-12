package objectTest;

class Employee {
	private int number;
	private String name;

	public Employee() {;}

	public Employee(int number, String name) {
		super();
		this.number = number;
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof Employee) {
			Employee em = (Employee) obj;
			if (number == em.number) {
				return true;
			}
		}
		return false;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

public class EqualsTask {
	public static void main(String[] args) {
		Employee john = new Employee(1, "john");
//		같은 사원번호를 가지고 있다면 true가 나오게 하기!
		System.out.println(john.equals(new Employee(1, "john")));
	}
}
