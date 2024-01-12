package objectTest;

import java.util.Random;

class Student {
	@Override
	public String toString() {
		return "학생입니다";
	}
}

public class ToStringTest {
	public static void main(String[] args) {
		Student std = new Student();
		System.out.println(std);
		
		Random r = new Random();
//		r.nextInt(10);	0 ~ 9까지의 범위
		System.out.println(r.toString());
	}
}
