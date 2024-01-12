package method;

public class Main01 {
	public static void main(String[] args) {
		System.out.println(plus(1, 2));
		System.out.println(minus(5, 4));
		System.out.println("-------------");
		
		int result = plus(10, 20);
		System.out.println(result);
		System.out.println("-------------");
		// 메서드간의 상호호출
		System.out.println(f(10, 20));
		
	}
	
	public static int plus(int x, int y) {
		int result = x + y;
		return result;
	}
	
	public static int minus(int x, int y) {
		return x - y;
	}
	
	public static int f(int x, int y) {
		return plus(x, y);
	}
}
