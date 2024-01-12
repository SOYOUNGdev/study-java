package override;

class Hi {
	 public void say() {
		 System.out.println("Hi");
	 }
}

class Korean2 extends Hi { 
	public void say() {
		// 원본 기능에 대한 수정이 발생할 경우, 부모클래스와
		// 자식클래스를 모두 수정해야 하기 때문에
		// 소스코드의 유지보수 효율성이 떨어지게 된다.
//		System.out.println("Hi");
		
		// super키워드를 사용햐여 부모의 메서드를 
		// 호출한 뒤에 추가적인 기능을 정의하고 있으므로
		// 부모의 원본 메서드에대한 기능확장 효과가 있다.
		super.say();
		System.out.println("안녕하세요");
	}
	
	public void sayHello() {
		super.say();
		this.say();
	}
}



public class Main02 {
	public static void main(String[] args) {
		Korean2 ko = new Korean2();
		ko.say();
		
		
//		ko.sayHello();
//		System.out.println("---------------");
		
	}
	
}
