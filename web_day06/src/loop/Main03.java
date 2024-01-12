package loop;

public class Main03 {
	public static void main(String[] args) {
		// while문으로 1+2+..+100 합
		
		int sum =  0, sum2 = 0;
		
		int i = 1;
		while(i <= 100) {
			sum += i;
			i++;
		}
		System.out.println(sum);
		
		int j = 1;
		while(j <= 100) {
			j++;
			sum2 += j;
		}
		System.out.println(sum2);
	}
}
