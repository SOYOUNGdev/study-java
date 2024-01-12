package lambdaEx;

// 두 정수를 전달받은 후 int로 리턴하는 calc추상메소드 선언 (함수형 인터페이스 제작)
@FunctionalInterface
public interface PrintResult {
	public int calc(int num1, int num2); 
}
