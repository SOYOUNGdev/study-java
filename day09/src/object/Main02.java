package object;

class Charactor {
	// 일반적으로는 멤버변수는 선언만 한다.
	String name;
	String job;
	
}


public class Main02 {
	public static void main(String[] args) {
		Charactor d = new Charactor();
		d.name = "둘리";
		d.job = "학생";
		
		Charactor h = new Charactor();
		h.name = "희동";
		h.job = "직장인";
		
		System.out.println("이름 : " + d.name + ", 나이 : " + d.job);
		System.out.println("이름 : " + h.name + ", 나이 : " + h.job);
	}
}
