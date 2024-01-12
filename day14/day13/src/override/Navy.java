package override;

public class Navy extends Unit {
	// Navy 생성자
	public Navy(String name) {
		super(name);
	}
	
	// attack() Override
	// 부모 attack 호출
	// 부대이름출력 >> 어뢰 발사
	// 부대이름출력 >> 지상 상륙
	@Override
	public void attack() {
		super.attack();
		System.out.println(super.getName() + ">> 어뢰 발사");
		System.out.println(super.getName() + ">> 지상 상륙");
	}
	
	// nucleus()
	// 부대이름출력 >> 핵미사일
	public void nucleus() {
		System.out.println(super.getName() + ">> 핵미사일");
	}
	
}
