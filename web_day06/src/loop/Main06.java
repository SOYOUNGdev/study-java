package loop;

public class Main06 {
	public static void main(String[] args) {
		//구구단 7단
		int i = 1;
		int j = 0;
		
		do {
			j = 7 * i;
			System.out.println(j);
			i++;
		} while(i <= 9);
	}
}
