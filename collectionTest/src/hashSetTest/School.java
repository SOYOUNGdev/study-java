package hashSetTest;

import java.util.HashSet;

public class School {
	public static void main(String[] args) {
		HashSet<Student> stdSet = new HashSet<>();
		stdSet.add(new Student(1,"한동석"));
		stdSet.add(new Student(1,"한동석"));
		
//		equals에서 비교한 필드를 haseCode()에서 리탄함으로써 재정의해야함.
		System.out.println(stdSet.size());
		
		Student std = new Student(1, "한동석");
		System.out.println(std.equals(new Student(1,"한동석")));
	}
}
