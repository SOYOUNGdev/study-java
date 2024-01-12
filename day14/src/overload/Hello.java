package overload;

public class Hello {
	public Hello(String msg) {
		System.out.println(msg);
	}
	
	public Hello() {
		this("Hello", 3);
	}
	
	public Hello(String msg2, int num) {
		for(int i = 0; i < num; i++) {
		System.out.println(msg2);
		}
	}
	
}
