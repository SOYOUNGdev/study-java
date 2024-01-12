package extend;

public class QNAArticle extends Article {
	private String answer;	// 답변

//	public QNAArticle() {
//		
//	}
	
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public String toString() {
		return "질문/답변[글번호 = " + getNum() + ", 제목 = " + getTitle() + ", 답변 = " + getAnswer() + "]";
	}
	
}
