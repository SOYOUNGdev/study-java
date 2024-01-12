package extend;

public class FileArticle extends Article {
	private String fileName;	// 파일이름
	
//	public FileArticle() {
//		
//	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String toString() {
		return "자료실 [번호 = " + getNum() + ", 제목 = " + getTitle() + ", 첨부파일 = " + getFileName() + "]";
	}
	
}
