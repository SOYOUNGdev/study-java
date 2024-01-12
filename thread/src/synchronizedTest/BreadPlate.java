package synchronizedTest;

public class BreadPlate {
	private static BreadPlate breadPlate;
	
	public int breadCount;
	public int eatCount;
	
	private BreadPlate() {;}	//breadPlate 생성자를 외부에서 사용못하도록
	
//	static은 한번만 메모리에 할당! 생성자 하나만 만들어서 getInstance()메서드를 통해 자원주소 공유
//	싱글톤 패턴
//	무조건 객체가 단 한 개만 있어야 할 때의 설계방법
	public static BreadPlate getInstance() {
//		첫번째 객체 생성시
		if(breadPlate == null) {
			breadPlate = new BreadPlate();
		}
		return breadPlate;
	}

	public synchronized void makeBread() {
		if (breadCount > 9) {
			System.out.println("빵이 가득 찼습니다.");
			try {wait();} catch(InterruptedException e){;}
		}
		breadCount++;
		System.out.println("빵을 1개 만들었습니다. 총 : " + breadCount + "개");
	}

	public synchronized void eatBread() {
		if(eatCount == 20) {
			System.out.println("빵이 다 떨어졌습니다");
		}else if(breadCount < 1) {
			System.out.println("🍪🍩🍪🍩🍪🍩🍪🍩빵을 만들고 있어요!!");
		}else {
			breadCount--;
			eatCount++;
			System.out.println("빵을 1개 먹었습니다. 총: " + breadCount + "개");
			notify();
		}
	}
}
