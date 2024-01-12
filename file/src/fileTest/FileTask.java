package fileTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTask {
	public static void main(String[] args) throws IOException {
//		현재 경로에 food.txt파일을 생성하고,
//		파일 내용은 족발, 보쌈, 짜장면, 탕수육 네 가지 음식으로 작성한다.
//		각 음식은 줄바꿈 후 다음 음식을 넣도록한다.
//		반복문을 사용하여 데이터를 출력한다.
//		BufferedWriter bw = new BufferedWriter(new FileWriter("food.txt", true));
//		String[] food  = {"족발", "보쌈", "짜장면", "탕수육"};
//		
//		for (int i = 0; i < food.length; i++) {
//			bw.write(food[i]);
//			bw.newLine();
//		}
//		bw.close();	

//		출력 후 파일에 작성된 내용을 콘솔에 출력한다.
		try {
			BufferedReader br = new BufferedReader(new FileReader("food.txt"));
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
//			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("해당 경로의 파일을 찾을 수 없습니다.");
		}

		File file = new File("food.txt");
		if (file.exists()) {
			System.out.println(file.delete()); // br.close()해야만 삭제되서 true가 뜬다
		}
	}

}
