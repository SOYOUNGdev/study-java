package classTest;

class Car {
	String brand;
	
	public Car(String brand) {
		this.brand = brand;
	}
	
	void engineStart() {
		System.out.println(this);
		System.out.println(brand + "시동 킴");	// this.brand에서 this가 생략됨
	}
}


public class ClassTest {
	public static void main(String[] args) {
		Car momCar = new Car("벤츠");
		Car dadCar = new Car("BMW");
		
		System.out.println(momCar);
		momCar.engineStart();
		System.out.println("-------------------");
		
		System.out.println(dadCar);
		dadCar.engineStart();
	}
	
}
