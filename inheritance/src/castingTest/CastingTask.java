package castingTest;

import java.util.Scanner;

public class CastingTask {

//	넷플릭스
//	애니메이션, 영화, 드라마 클래스
//	사용자가 선택한 영상이 애니메이션이라면 "자막 지원" 기능을 사용하고
//	영화라면 "4D"기능을 사용하고
//	드라마라면 "굿즈" 기능을 사용한다.

	public void check(Video video) {
		if (video instanceof Film) {
			Film film = (Film) video;
			film.playFlim();

		} else if (video instanceof Drama) {
			Drama drama = (Drama) video;
			drama.sellGoods();

		} else if (video instanceof Animation) {
			Animation ani = (Animation) video;
			ani.printSubtitle();
		}
	}

	public static void main(String[] args) {
		CastingTask ct = new CastingTask();
		
		// 자식은 부모타입! Video로 업캐스팅하기 전에 넣기-> 파라미터에 전달되면 업캐스팅된다.
		// Video drama = new Drama(); 
		// ct.check(drama)라고해도 출력값은 같지만 먼저 업캐스팅해버린것.
		// 따라서 중간과정을 생략할 수 있는 용기가 필요하다.(*자식은 부모타입, 본인타입 둘다 가진다*) 
		ct.check(new Drama());
		ct.check(new Animation());
		ct.check(new Film());
	}

}
