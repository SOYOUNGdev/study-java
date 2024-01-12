package fileTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest2 {
	public static void main(String[] args) throws IOException {
//		갈치, 대구, 돔, 고등어
		String[] fishes = {"갈치", "대구", "돔", "고등어"};
		BufferedWriter bw = new BufferedWriter(new FileWriter("fish.txt")); 
		
		for(String fish : fishes) {
			bw.write(fish + "\n");
		}
		bw.close();
		
//		수정(대구 -> 개복치)
//		BufferedReader br = new BufferedReader(new FileReader("fish.txt"));
//		String line = null;
//		String temp = "";
//		
//		while((line = br.readLine()) != null) {
//			if(line.equals("대구")) {
//				temp += "개복치\n";
//				continue;
//			}
//			temp += line + "\n";
//		}
//		br.close();
//		
//		BufferedWriter bw2 = new BufferedWriter(new FileWriter("fish.txt"));
//		bw2.write(temp);
//		bw2.close();
		
//		개복치 삭제
		BufferedReader br = new BufferedReader(new FileReader("fish.txt"));
		String line = null;
		String temp = "";
		
		while((line = br.readLine()) != null) {
			if(line.equals("대구")) {
				continue;
			}
			temp += line + "\n";
		}
		br.close();
		
		BufferedWriter bw2 = new BufferedWriter(new FileWriter("fish.txt"));
		bw2.write(temp);
		bw2.close();
	}
}
