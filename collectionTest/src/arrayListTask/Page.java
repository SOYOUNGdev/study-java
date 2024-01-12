package arrayListTask;

public class Page {
	public static void main(String[] args) {
		User member = new User();
		UserField memberField = new UserField();
		
		member.setId("isy1234");
		member.setPassWord("1234");
		member.setName("임소영");
		member.setPhoneNum("01012341234");
		
		if(memberField.checkId(member.getId()) == null) {
			memberField.join(member);
			System.out.println("회원가입 성공");
		}
		
		if(memberField.login("isy1234", "1234")) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
		}
		
		memberField.members.forEach(System.out::println);
	}
	
}
