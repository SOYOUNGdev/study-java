package override;

public class AirForce extends Unit {
	// AirForce 생성자
	public AirForce(String name) {
		super(name);
	}
	
	// attack() Override
	// 부모 attack호출
	// 부대이름출력 >> 이륙
	// 부대이름출력 >> 공중공격 실행함
	@Override
	public void attack() {
		super.attack();
		System.out.println(super.getName() + ">> 이륙");
		System.out.println(super.getName() + ">> 공중공격 실행함");
	}
	
	// bombing()
	// 부대이름 출력 >> 폭격
	public void bombing() {
		System.out.println(super.getName() + ">> 폭격");
	}
}
