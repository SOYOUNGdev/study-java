package hashSetTest;

public class Student {
	private int number;
	private String name;
	
	public Student() {;}

	public Student(int number, String name) {
		super();
		this.number = number;
		this.name = name;
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

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		
		if(obj instanceof Student) {
			Student std = (Student) obj;
			if(std.number == this.number) {
				return true;
			}
		}
		return false;
	}
	
//	hashCode()를 사용하는 자료구조에서는
//	정확한 비교를 위해 equals()를 재정의했다면 반드시 hashCode()도 재정의해야한다.
	@Override
	public int hashCode() {
		return this.number;
	}
}
