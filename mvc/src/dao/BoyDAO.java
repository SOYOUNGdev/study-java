package dao;

import vo.BoyVO;

public class BoyDAO {
	
//	외부에서 전체 정보를 문자열로 받아온다
	public BoyVO setModel(String line) {
//		받아온 전체 정보를 공통된 구분점인 \t를 사용하여 분리해준다.
		String[] datas = line.split("\t");
		BoyVO boyVO = new BoyVO();
		
//		각 정보를 객체에 저장하고
//		datas의 0번째 인덱스-> 이름,
//		1번째 인덱스->순위,
//		2번째 인덱스에-> 인구 수 
		boyVO.setName(datas[0]);
//		boyVO.setRanking(Integer.valueOf(datas[1]));
		boyVO.setRanking(Integer.parseInt(datas[1]));
		boyVO.setPopulation(Integer.valueOf(removeComma(datas[2])));
		
//		받아온 객체를 리턴한다.
		return boyVO;
	}
	
	public String removeComma(String data) {
//		인구수의 ,를 빈문자열로 대체-> 즉 쉼표 없애기
		return data.replaceAll(",", "");
	}
}
