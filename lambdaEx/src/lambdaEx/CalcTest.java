package lambdaEx;

import java.util.Scanner;

public class CalcTest {

	public static PrintResult getResult(String oper) {
		// 두 정수의 덧셈, 뺄셈을 구해주는 함수형 인터페이스를 리턴하는 static 메소드(람다식리턴)
		PrintResult pr = null;
		switch (oper) {
		case "+":
			pr = ((num1, num2) -> (num1 + num2));
			break;
		case "-":
			pr = ((num1, num2) -> (num1 - num2));
			break;
		}
		return pr;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] nums = null;
		String[] opers = null;

//		main메소드에 getOpers를 람다식으로 구현
		WholeCalc wc = (input) -> {
			String temp = "";
			for (int i = 0; i < input.length(); i++) {
				char c = input.charAt(i);
				if (c == 43 || c == 45) {
					temp += c;
				}
			}
			return temp.split("");
		};

		int num1 = 0, num2 = 0, result = 0;
		System.out.print("입력 >> ");
		String input = sc.nextLine();

		nums = input.split(" \\+ | \\- |\\-");
		opers = wc.getOpers(input);
		num1 = Integer.parseInt(nums[0].equals("") ? (opers[0] + nums[1]) : nums[0]);
		for (int i = 0; i < opers.length; i++) {
//			첫수가 음수일 때 오류 해결
			if (i == 0 && num1 < 0) {
				continue;
			}
			num2 = Integer.parseInt(nums[i + 1]);
			num1 = getResult(opers[i]).calc(num1, num2);
		}
		result = num1;
		System.out.println("출력 >> " + result);
	}

}
