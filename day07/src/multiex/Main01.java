package multiex;

public class Main01 {
	public static void main(String[] args) {
		// 1~100까지의 홀수들의 합
		// 1+3+5..+99
		int sum = 0;
		int i = 0;

		while (true) {
			i++;

			// 짝수를 제거
			if (i % 2 == 0) {
				continue;
			}
			if(i > 100) {
				break;
			}
			sum += i;
		}
		System.out.println(sum);
	}
}
