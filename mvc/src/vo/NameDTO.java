package vo;

import java.util.Collections;

public class NameDTO {
	private String name;
	private int ranking;
	private int population;
	private String gender;
	
	public NameDTO() {;}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	
//	comma넣기!
//	population뒤집고 3의 배수일때만 comma로 연결! 그 다음 다시 뒤집기
	@Override
	public String toString() {
		String str = null;
//		기존 인구수를 문자열로 변환
		String data = String.valueOf(population);
		String populationWithComma = "";
		
		for (int i = 0; i < data.length(); i++) {
//			i가 3의 배수일 경우 ,를 연결해준다.
			if(i % 3 == 0 && i != 0) {
				populationWithComma = "," + populationWithComma;
			}
//			기존 인구수를 일의 자리 수부터 하나씩 검사하여 콤마를 넣어준다.
//			예) 12345
//			1 : 5
//			2 : 45
//			3 : ,345
//			4 : 2,345
//			5 : 12,345
			populationWithComma = data.charAt(data.length() - i - 1) + populationWithComma;
		}
		
		str = name + "\t" + ranking + "\t" + populationWithComma + "\t" + gender + "\n";
		return str;
	}
}
