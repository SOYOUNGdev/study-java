package method;

public class Main03 {

	public static void main(String[] args) {
		plus(10, 20);
//		plus(10, 30);
//		plus(10, 40);
//		plus(10, 50);
		minus(10, 20);
//		minus(10, 30);
//		minus(10, 40);
//		minus(10, 50);
		multiplication(10, 20);
		division(10, 0);
		division(10, 2);
	}
	
	public static void plus(int x, int y) {
		System.out.println("plus : " + (x + y));
	}
	
	public static void minus(int x, int y) {
		int result = x - y;
		System.out.println("minus : " + result);
	}
	
	public static void multiplication(int x, int y) {
		int result = x * y;
		System.out.println("multiplication : " + result);
	}
	
	public static void division(double x, double y) {
		if(y == 0) {
			System.out.println("값을 수정해주세요");
		}else { 
		double result = x / y;
		System.out.println("division : " + result);
		}
	}
}
