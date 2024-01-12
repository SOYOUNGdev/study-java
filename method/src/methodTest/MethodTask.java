package methodTest;

import java.util.Scanner;

public class MethodTask {
// 1. 메소드 명을 정한다.
// 2. 매개변수를 생각한다.
// 3. 실행할 문장을 작성한다.
// 4. 리턴값을 작성한다.
	
	
// 문자열을 입력받고 원하는 문자의 개수를 구해주는 메소드
	public static int getCount(String str,char c) {
		int count = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == c) {
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 입력 >> ");
		String str = sc.nextLine();
		System.out.print("원하는 문자 입력 >> " );
		char c = (char)sc.nextInt();		
		System.out.println(getCount(str, c));
	}
}
