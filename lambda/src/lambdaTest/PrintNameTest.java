package lambdaTest;

public class PrintNameTest {
	public static void printFullName(PrintName printName) {
		// 전달받은 람다식을 사용해라!
		System.out.println(printName.getName("한", "동석"));
	}
	
	public static void main(String[] args) {
		// 람다식을 매개변수로 전달해라!
		printFullName((l, f) -> (l + f));
	}
	
}
