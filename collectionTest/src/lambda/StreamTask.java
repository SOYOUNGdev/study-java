package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTask {
	public static void main(String[] args) {
//		1~100까지 ArrayList에 담고 출력
		ArrayList<Integer> datas = new ArrayList<Integer>();
		IntStream.rangeClosed(1, 100).forEach(datas::add);
		System.out.println(datas);
		
//		1~10까지 중 홀수만 ArrayList에 담고 출력
		ArrayList<Integer> datas2 = new ArrayList<>();
		IntStream.rangeClosed(1, 10).filter(number -> number % 2 != 0).forEach(datas2::add);
		System.out.println(datas2);
		
//		A~F까지 ArrayList에 담은 후 출력
		ArrayList<Character> chars = new ArrayList<>();
		"ABCDEF".chars().forEach(num -> chars.add((char)num));
		System.out.println(chars);
		
//		A~F까지 중 C제외하고 ArrayList에 담은 후 출력
		ArrayList<Character> chars2 = new ArrayList<>();
		IntStream.rangeClosed(0, 5).filter(num -> num != 2).forEach(num -> chars2.add((char)(num + 65)));
//		IntStream.rangeClosed(0, 4).map(num -> num > 1? 66 + num : 65 + num).forEach(num -> chars2.add((char)num));
		System.out.println(chars2);
		
//		문자열을 5개 입력받고 모두 소문자로 변경
		List<String> colors = new ArrayList<String>(Arrays.asList("BLACK", "white", "RED", "yellow", "Blue"));
		try {colors.stream().map(String::toLowerCase).forEach(System.out::println);} catch(Exception e) {;}
				
//		Apple, banana, Melon중 첫번째 문자가 대문자인 문자열 출력
		ArrayList<String> fruits = new ArrayList<String>(Arrays.asList("Apple", "banana", "Melon"));
		String result = fruits.stream().filter(fruit -> fruit.charAt(0) >= 65 && fruit.charAt(0) <= 90).collect(Collectors.joining(", "));
		System.out.println(result);
		
//		한글을 정수로 변경
		String hangle = "공일이삼사오육칠팔구";
		String data = "일공이사";
		
		data.chars().map(c -> hangle.indexOf(c)).forEach(System.out::print);
		
//		정수를 한글로 변경
		String hangle2 = "공일이삼사오육칠팔구";
		String data2 = "1024";
		
		data2.chars().map(c -> c - 48).forEach(c -> System.out.print(hangle2.charAt(c)));
		
	}
}













