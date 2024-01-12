package castingTest;

class Car {
	
	void engineStart() {
		System.out.println("열쇠 또는 버튼으로 시동 킴");
	}
	
}

class SuperCar extends Car {
	@Override
	void engineStart() {
		System.out.println("음성으로 시동 킴");
	}
	
	void openRoof() {
		System.out.println("지붕 염");
	}
	
}

public class CastingTest {
	public static void main(String[] args) {
//		오류
//		SuperCar brokenFerrari = (SuperCar)new Car();
		
		Car matiz = new Car();
		SuperCar ferrari = new SuperCar();
//		up casting
		Car noOptionFerrari = new SuperCar();
		
//		down casting
		SuperCar fullOptionFerrari = (SuperCar)noOptionFerrari;
//		fullOptionFerrari.openRoof();
		
		System.out.println(matiz instanceof Car);					// true
		System.out.println(matiz instanceof SuperCar);				// false
		System.out.println(noOptionFerrari instanceof Car);			// true
		System.out.println(noOptionFerrari instanceof SuperCar);	// true
		System.out.println(fullOptionFerrari instanceof Car);		// true
		System.out.println(fullOptionFerrari instanceof SuperCar);	// true
		
		
	}
	
}
