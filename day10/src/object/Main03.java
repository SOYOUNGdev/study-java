package object;

/*
 * Calc2 클래스를 생성해서
 * -plus(), minus(), times(), divide()
 * -param1, param2, return
 * 
 * Main03클래스 Cacl2클래스로 객체생성 후, 각각 메서드 호출 결과 출력
 */

class Calc2 {
	int plus(int param1, int param2) {
		return param1 + param2;
	}
	
	int minus(int param1, int param2) {
			return param1 - param2;
	}
	
	int times(int param1, int param2) {
		return param1 * param2;
	}
	
	double divide(int param1, int param2) {
		double result = 0.0;
		if(param2 != 0) {
			result = (double)param1 / param2;
		}
		return result;
	}
	
	int f(int x, int y) {
		if(x < y) {
			return x + y;
		}else {
			return x - y;
		}
	}
}

public class Main03 {
	public static void main(String[] args) {
		Calc2 c = new Calc2();
		
		System.out.println("100 + 5 = " + c.plus(100, 5));
		System.out.println("100 - 5 = " + c.minus(100, 5));
		System.out.println("100 * 5 = " + c.times(100, 5));
		System.out.println("100 / 5 = " + c.divide(100, 5));
	}
}
