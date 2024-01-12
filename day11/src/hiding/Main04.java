package hiding;

public class Main04 {
	public static void main(String[] args) {
		// 객체
//		Article article = new Article(1, "bad blood", "엘리자베스의 가짜 성공", "존 캐리루", 1000, "2019-04-01");
		Article article = new Article(1, "테스트게시물", "JavaBeans테스트", "자바학생", 100, "2022-07-26");

		// 각각 데이터를 출력
		System.out.println("글 번호 : " + article.getSeq());
		System.out.println("글 제목 : " + article.getSubject());
		System.out.println("글 냐용 : " + article.getContent());
		System.out.println("작성자 : " + article.getWriter());
		System.out.println("조회수 : " + article.getHit());
		System.out.println("작성일시 : " + article.getRegDate());
	}

}
