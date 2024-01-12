package arrayListTest;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTest {

	public static void main(String[] args) {
//		<?> : 제네릭(이름이 없는)
//		임시로 타입을 선언하여 임시 타입으로 설계한다.
//		따로 다운 캐스팅을 할 필요가 없다.
//		지정할 타입에 제한을 둘 수 있다.
		ArrayList<Integer> datas = new ArrayList<>();

		datas.add(10);
		datas.add(20);
		datas.add(40);
		datas.add(50);
		datas.add(90);
		datas.add(80);
		datas.add(70);
		datas.add(60);
		System.out.println(datas.size());

//		for (int i = 0; i < datas.size(); i++) {
//			System.out.println(datas.get(i));
//		}

//		빠른 for문, 향상된 for문, forEach,..
//		for(int data : datas) {	// auto unboxing(Integer -> int)
//			System.out.println(data);
//		}

		System.out.println(datas.toString());
//		주소를 직접전달하여 sort메소드에서 정렬이 되었기 때문에
//		전달한 datas의 값들이 정렬된 값으로 변경되어 있다.
		Collections.sort(datas); // ArrayList 정렬(datas는 객체(=할당된 필드의 주소값 지님)이므로 주소값 전달.)
		System.out.println(datas);

		Collections.reverse(datas);
		System.out.println(datas);

		Collections.shuffle(datas);
		System.out.println(datas);

		System.out.println("--------------------------------------------------");

		// 추가(삽입)
//		50뒤에 500 삽입
//		단, 50이 있을때에만 삽입한다.
		if (datas.contains(50)) {
			datas.add(datas.indexOf(50) + 1, 500);
			System.out.println(datas);
		}

//		for (int i = 0; i < datas.size(); i++) {
//			if (datas.get(i) == 50) {
//				datas.add(i + 1, 500);
//			}
//		}
//		System.out.println("삽입 >> " + datas);

		// 수정
//		90을 9로 수정
		if (datas.contains(90)) {
			try {
				System.out.println(datas.set(datas.indexOf(90), 9) + "이 9로 변경되었습니다");
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(datas);
			}
		}

//		for (int i = 0; i < datas.size(); i++) {
//			if (datas.get(i) == 90) {
//				datas.set(i, 9);
//			}
//		}
//		System.out.println("수정 >> " + datas);

		// 삭제
//		80삭제
////		1. 인덱스로 삭제
//		if(datas.contains(80)) {
//			System.out.println(datas.remove(datas.indexOf(80)) + "삭제됨");
//			System.out.println(datas);
//		}
		
////		2. 값으로 삭제
//		if(datas.remove(Integer.valueOf(80))) {
//			System.out.println("삭제 성공");
//			System.out.println(datas);
//		}
		
//		for (int i = 0; i < datas.size(); i++) {
//			if (datas.get(i) == 80) {
////		1. 인덱스로 삭제
//				datas.remove(i);
////		2. 값으로 삭제
//				datas.remove(datas.get(i));
//			}
//		}
//		System.out.println("삭제 >> " + datas);
	}
}
