package synchronizedTest;

public class CU {
	public static void main(String[] args) {
//		엄마와 아들이 동일한 자원(ATM클래스의 run메소드)에 접근(하나의 자원을 공유)
		ATM atm = new ATM();
		
		Thread mom = new Thread(atm, "엄마");
		Thread son = new Thread(atm, "아들");
		
		mom.start();
		son.start();
		
	}
}
