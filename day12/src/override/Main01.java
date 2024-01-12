package override;

class Hello {
	public Hello(String meet) {
		System.out.println(meet);
	}
	public void say() {
		System.out.println("Hello");
	}
}

class English extends Hello { 
	public English(String meet) {
		super(meet);
	}
	
	@Override
	public void say() {
		super.say();
		System.out.println("en_hello");
	}
}

class Korean extends Hello {
	public Korean(String meet) {
		super(meet);
	}
	public void say() {
		System.out.println("안녕하세요");
	}
}

public class Main01 {
	public static void main(String[] args) {
		English en = new English("nice to meet you");
		// 자식클래스에 구현된 메서드가 없기 때문에
		// 부모클래스에 정의된 메서드를 찾아가게 된다.
		en.say();
		Korean ko = new Korean("nice to meet you");
		// 자식클래스가 부모와 같은 이름의 메서드를 정의하고 있기 때문에
		// 부모클래스가 정의하고 있는 say() 메서드가 가려지게 된다
		ko.say();
		
//		Hello hello = new Hello();
//		hello.say();
		
	}
	
}
