package object;

class Student {
	String name = "자바학생";
	int age = 20;
}

public class Main01 {
	public static void main(String[] args) {
		// 객체의 선언과 할당 분리
		Student std;
		std = new Student();
		
		System.out.println(std.age);
		System.out.println(std.name);
		System.out.println("------------------------------------");
		
		// 객체 안에 포함된 변수의 값을 다른 변수에 복사
		String studentName = std.name;
		System.out.println(studentName);
		
		std.name = "jsp학생";
		System.out.println(std.name);
		
		
		
		// 객체의 생성(일괄지정)
		Student std2 = new Student();
		System.out.println(std2.name);
		System.out.println("----------------------------------");
		
		std2.name = "db학생";
		System.out.println(std.name);
		System.out.println(std2.name);
		
	}
	
	
}


