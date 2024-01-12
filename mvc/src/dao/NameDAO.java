package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collectors;

import vo.BoyVO;
import vo.GirlVO;
import vo.NameDTO;

public class NameDAO {

	public ArrayList<BoyVO> boys;
	public ArrayList<GirlVO> girls;

//	병합
//	두 개의 파일을 하나의 새로운 파일로 병합한다.
//	path1 : 기존파일 경로1
//	path2 : 기존파일 경로2
//	path3 : 병합된 내용을 출력할 경로
	public void merge(String path1, String path2, String path3) throws IOException {
		String line = null;
		String temp = "";
//		남자 정보 저장
		boys = new ArrayList<BoyVO>();
//		여자 정보 저장
		girls = new ArrayList<GirlVO>();

		BoyDAO boyDAO = new BoyDAO();
		GirlDAO girlDAO = new GirlDAO();

		BufferedReader boyReader = DBConnecter.getReader(path1);

		while ((line = boyReader.readLine()) != null) {
			temp += line + "\n";
			boys.add(boyDAO.setModel(line));
		}

		boyReader.close();

		BufferedReader girlReader = DBConnecter.getReader(path2);

		while ((line = girlReader.readLine()) != null) {
			temp += line + "\n";
			girls.add(girlDAO.setModel(line));
		}

		girlReader.close();

//		새로운 파일 생성 후 출력
		BufferedWriter bw = DBConnecter.getWriter(path3);
		bw.write(temp);
		bw.close();
	}

//		랭킹 수정
//		병합된 파일의 경로를 전달받는다.
	public void update(String path) throws IOException {
//		남자 여자 동일한 부모타입은 오브젝트. 두 객체를 동시에 담을것임.(인구수를 비교하여 내림차순으로 담기위함) 
		ArrayList<Object> datas = new ArrayList<>();
		
//		Collections의 sort()로 정렬 편하게 하기 위해서 ArrayList사용
//		populations는 전체 정보 중 인구 수만 담아줄 ArrayList
		ArrayList<Integer> populations = new ArrayList<>();
		
		HashSet<Integer> populationSet = null;
		
		int ranking = 1;
		String temp = "";
		int count = 0;
		
//		ArrayList n개(boys&girls)를 하나로 합친다
		datas.addAll(boys);
		datas.addAll(girls);
		
		boys.stream().map(v -> v.getPopulation()).forEach(populations::add);
		girls.stream().map(v -> v.getPopulation()).forEach(populations::add);
		
//		populations 중복제거
//		populations를 hashset에 담아서 중복제거 한 뒤,
//		다시 arrayList타입으로 바꿔서 populations에 저장
		populationSet = new HashSet(populations);
		populations = new ArrayList<Integer>(populationSet);
		
//		내림차순 정렬
//		Collections.sort(populations);
//		List -> ArrayList로 다운캐스팅
		populations = (ArrayList<Integer>)populations.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		3
//		인수 하나씩 순서대로 population에 담기
		for(Integer population : populations) {
//			다음 population으로 넘어가면 count는 초기화되어야함
			count = 0;
//			모든 정보(남자 + 여자)를 하나씩 vo에 담아준다.
			for(Object vo : datas) {
//				다운 캐스팅(BoyVO에 있는 getPopulation() 사용하기위해)
				if(vo instanceof BoyVO) {
					BoyVO boyVO = (BoyVO) vo;
//					이미 내림차순으로 정렬된 남자아이의 인구 수를 전체 정보에서 비교한다.
					if(boyVO.getPopulation() == population) {
//						해당 인구를 가진 객체를 찾았다면
						NameDTO result = new NameDTO();
						
//						NameDTO에 넣어준다.
						result.setName(boyVO.getName());
//						getRanking()하면 안됨. 여기서 사용하는 재정렬된 ranking사용
						result.setRanking(ranking);
						result.setPopulation(boyVO.getPopulation());
						result.setGender("M");
						
//						해당 결과를 temp에 누적해준다.
						temp += result;
//						남자와 여자 둘다 동일한 인구수일경우 count가 1증가
						count++;
					}
				}
				
				if(vo instanceof GirlVO) {
					GirlVO girlVO = (GirlVO) vo;
					if(girlVO.getPopulation() == population) {
						NameDTO result = new NameDTO();
						
						result.setName(girlVO.getName());
						result.setRanking(ranking);
						result.setPopulation(girlVO.getPopulation());
						result.setGender("G");
						
						temp += result;
						count++;
					}
				}
			}
//			공동 인구 수가 존재하면,
//			공동 인구 수만큼을 다음 랭킹에 반영한다.
			if(count > 1) {ranking += (count-1);}
			ranking ++;
		}
		BufferedWriter bw = DBConnecter.getWriter(path);
		bw.write(temp);
		bw.close();
	}

}
























