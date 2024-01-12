package extend;

public class Main01 {
	public static void main(String[] args) {
		CalcParent parent = new CalcParent();
		System.out.println(parent.plus(10, 20));
		System.out.println(parent.minus(100,50));
		
		System.out.println("----------------------");
		
		CalcChild child = new CalcChild();
		System.out.println(child.plus(100, 50));
		System.out.println(child.minus(100, 50));
		System.out.println(child.times(10, 20));
		System.out.println(child.divide(200, 100));
		
	}
	
}
