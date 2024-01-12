package multiex;

import java.util.Scanner;

public class Main02 {
	public static void main(String[] args) {
		/*
		 * 문1. 1부터 100까지 홀수와 짝수의 합을 각각 구하여라 단, continue, break 사용금지. 반복문 1개만
		 */
		int sum1 = 0, sum2 = 0;

		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				sum2 += i;
			}else {
				sum1 += i;
			}
		}
		System.out.println("홀수 합 : " + sum1 + ", 짝수 합: " + sum2);

		/*
		 * 문2. 만약 3000원 이상의 돈을 가지고 있으면 택시를 타고 그렇지 않으면 걸어가라
		 */
		int money1 = 0;
		if (money1 >= 3000) {
			System.out.println("택시를 타라");
		}
		System.out.println("걸어가라");

		/*
		 * 문3. 만약 3000원 이상의 돈이 있거나, 카드가 있다면 택시를 타고, 그렇지 않으면 걸어가라
		 */
		int money2 = 3000;
		boolean card = false;

		if (money2 >= 3000 || card) {
			System.out.println("택시를 타라");
		}else {
			System.out.println("걸어가라");
		}

		/*
		 * 문4. 특정 정수값 a,b,c의 최대값을 구하여라 a=10, b=20, c=9
		 */
		int a = 10, b = 20, c = 9, max = 0;

		max = a;

		if (max > b || max > c) {
			if (b > c) {
				max = b;
			}else {
				max = c;
			}
		}
		System.out.println("최댓값: " + max);

		/*
		 * 문5. 숫자가 3이면 "안녕"이 3줄, 숫자가 2이면 "안녕"이 2줄, 1이면 "안녕"이 한줄, 
		 * 그 외에는 "잘가" 가 출력되도록 프로그램을 만들어라
		 */
		Scanner sc = new Scanner(System.in);
		int num = 0;
		System.out.print("숫자 입력 >> ");
		num = sc.nextInt();

		switch (num) {
		case 3:
			System.out.println("안녕");
		case 2:
			System.out.println("안녕");
		case 1:
			System.out.println("안녕");
			break;
		default:
			System.out.println("잘가");
		}

	}
}
