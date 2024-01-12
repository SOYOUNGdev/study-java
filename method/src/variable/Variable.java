package variable;

// static은 컴파일러가 가장 먼저 메모리에 할당해준다.
// 생성자로 할당되지 않기 때문에 new를 하더라도 이전 값을 그대로 기억하고 있다.
// 객체가 수만개라도 static필드는 딱 한개만 메모리에 할당된다.
// 따라서 모든 객체가 공유해야하는 필드에 static을 붙여서 사용한다.

public class Variable {
	public int data = 10;
	public static int data_s = 10;
	
	public void increaseData() {
		data++;
		System.out.println(data);
	}
	
	public static void increaseData_s() {
		data_s++;
		System.out.println(data_s);
	}
}
