package array;

public class Main02 {
	public static void main(String[] args) {
		// 배열의 생성
		int[] dooly;
		dooly = new int[3];
		dooly[0] = 75;
		dooly[1] = 82;
		dooly[2] = 91;
		
		// 배열의 선언과 크기 지정 및 값의 할당에 대한 개별 처리
		int[] douneo = new int[3];
		douneo[0] = 88;
		douneo[1] = 64;
		douneo[2] = 50;
		
		// 배열 생성의 일괄처리
		int[] ddochy = new int[] {100, 100, 90};
		
		// 배열의 활용
		int sum1 = 0, sum2 = 0, sum3 = 0;
		
		// for문을 사용해서 배열 요소의 값에 대한 합계
		// dooly
		for(int i = 0; i < dooly.length; i++) {
			sum1 += dooly[i];
		}
		System.out.println("둘리의 총합 : " + sum1);
		
		// douneo
		for(int i = 0; i < douneo.length; i++) {
			sum2 += douneo[i];
		}
		System.out.println("도우너의 총합 : " + sum2);
		
		// ddochy
		for(int i = 0; i < ddochy.length; i++) {
			sum3 += ddochy[i];
		}
		System.out.println("또치의 총합 : " + sum3);
		
		// 배열의 전체 길이로 나누어, 평균 출력
		System.out.println("dooly : " + sum1 / dooly.length);
		System.out.println("douneo : " + sum2 / douneo.length);
		System.out.println("ddochy : " + sum3 / ddochy.length);
	}
}
