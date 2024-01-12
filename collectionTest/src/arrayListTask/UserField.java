package arrayListTask;

import java.util.ArrayList;

public class UserField {
	private final static int KEY = 3;

	public ArrayList<User> members = new ArrayList<User>();

//	아이디 중복검사 메소드
	public User checkId(String id) {
		User member = null;

//		DB에 있는 회원을 전부 가져와서 하나씩 member에 담는다.
		for (int i = 0; i < members.size(); i++) {
//			각 회원의 아이디와 입력한 아이드를 비교한다.
			if (members.get(i).getId().equals(id)) {
//				일치하는 아이디가 있다면 그 회원을 member에 담는다.
				member = members.get(i);
			}
		}
//		아이디가 있으면 해당회원 객체 리턴,
//		없으면 null 리턴
		return member;
	}

//	회원가입 메소드(암호화)
//	외부에서 입력한 회원의 전체 정보를 전달받는다.
	public void join(User member) {
//		비밀번호를 암호환한 뒤 DB에 저장한다.
		member.setPassWord(encrypt(member.getPassWord()));
		members.add(member);
	}

//	로그인 메소드(암호화)
//	사용자가 입력한 아이디와 비밀번호를 전달받는다.
	public boolean login(String id, String passWord) {
//		아이디를 검사한다.
		User member = checkId(id);
//		만약 member가 null이 아니라면 DB에 존재하는 아이디이다.
		if (member != null) {
//			해당 회원의 비밀번호를 가져와서 입력한 비밀번호와 비교한다.
//			암호화된 것 끼리 비교
			if (member.getPassWord().equals(encrypt(passWord))) {
//				로그인 성공
				System.out.println("로그인 성공");
				return true;
			}
		}
//		로그인 실패
		return false;
	}

//	암호화
	public String encrypt(String passWord) {
		String encryptedPassWord = "";

		for (int i = 0; i < passWord.length(); i++) {
			encryptedPassWord += (char) (passWord.charAt(i) * KEY);
		}
		return encryptedPassWord;
	}

}
