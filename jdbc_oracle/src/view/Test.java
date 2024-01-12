package view;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

import dao.DBConnecter;
import dao.UserDAO;
import vo.UserVO;

public class Test {
   public static void main(String[] args) {
      UserDAO userDAO = new UserDAO();
      
//      Connection connection = DBConnecter.getConnection();
//      try {
//         connection.close();
//      } catch (SQLException e) {
//         e.printStackTrace();
//      }
      
//      아이디 중복검사
//      if(userDAO.checkId("hds1234")) {
//         System.out.println("중복된 아이디");
//      }else {
//         System.out.println("사용 가능한 아이디");
//      }
      
//      회원가입
//      UserVO userVO = new UserVO();
//      userVO.setUserId("hgd");
//      userVO.setUserPassword("3333");
//      userVO.setUserRecommenderId("hds");
//      userVO.setUserGender("M");
//      userVO.setUserPhoneNumber("01055556666");
//
//      userDAO.join(userVO);
      
//      로그인
//      System.out.println(userDAO.login("hgd", "3333"));
      
//      회원정보 수정
      UserVO userVO = userDAO.findByUserNumber(userDAO.login("hgd", "3333"));
      userVO.setUserBirthday(null);
      try {
         userDAO.update(userVO);
      } catch (ParseException e) {
      }
   }
}

