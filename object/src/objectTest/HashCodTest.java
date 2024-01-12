package objectTest;

import java.util.Random;

public class HashCodTest {
	public static void main(String[] args) {
		String data1 = "ABC";
		String data2 = "ABC";
		String data3 = new String("ABC");
		String data4 = new String("ABC");
		
		Random r1 = new Random();
		Random r2 = new Random();
		
		System.out.println(r1.hashCode());
		System.out.println(r2.hashCode());
		
		System.out.println(data1.hashCode());
		System.out.println(data2.hashCode());
		System.out.println(data3.hashCode());
		System.out.println(data4.hashCode());
	}
	
}
