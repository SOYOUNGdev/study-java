package exceptionTest;

import java.util.Scanner;

public class ExceptionTask {
	public static void main(String[] args) {
//		5개의 정수만 입력받기
//		- 무한 입력 상태로 구현
//		- q입력시 나가기
//		- 5개의 정수는 배열에 담기
//		- if문은 딱 한번만 사용하기

		Scanner sc = new Scanner(System.in);
		String in = null;
		int i = 0;
		int[] nums = new int[5];
		// alt shift z -> 아래화살표 엔터
		while (true) {
			System.out.print("정수입력(q입력시 종료) >> ");
			in = sc.next();
			if (in.equals("q")) {
				System.out.println("종료");
				break;
			}
			try {
				nums[i] = Integer.parseInt(in);
				i++;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("이미 5개의 정수가 입력되어있습니다.");
				for(int j = 0; j < nums.length; j++) {
					System.out.print(nums[j] + " ");
				}
				System.out.println();
			} catch (NumberFormatException e) {
				System.out.println("제대로 입력하세요. 입력하기 전에 생각이란 걸 해봤나요?");
				i--;
			}
		}
	}
}
