package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.UserVO;

public class UserDAO {
   
   public Connection connection; //연결 객체
   public PreparedStatement preparedStatement; //쿼리 객체
   public ResultSet resultSet; //결과 객체
   
//   아이디 중복검사
//   입력받은 아이디를 전달받는다.
   public boolean checkId(String userId) {
//      DB에서 USER_ID로 조회
      String query = "SELECT COUNT(USER_ID) FROM TBL_USER WHERE USER_ID = ?";
      boolean check = false;
      try {
         connection = DBConnecter.getConnection();
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setString(1, userId);
         resultSet = preparedStatement.executeQuery();
         
         resultSet.next(); //결과 테이블 행 1개 가져오기
         
//         조회한 개수가 1이면 중복된 아이디
         check = resultSet.getInt(1) == 1;
         
      } catch (SQLException e) {
         System.out.println("checkId() SQL문 오류");
         e.printStackTrace();
      } finally {
         try {
            if(resultSet != null) {
               resultSet.close();
            }
            if(preparedStatement != null) {
               preparedStatement.close();
            }
            if(connection != null) {
               connection.close();
            }
         } catch (SQLException e) {
//            닫다가 오류나면 프로세스 종료!
            throw new RuntimeException(e.getMessage());
         }
      }
      return check;
   }
   
//   회원가입
//   외부에서 회원가입 시 입력한 전체 정보를 전달받음
   public void join(UserVO userVO) {
      String query = "INSERT INTO TBL_USER(USER_NUMBER, USER_NAME, USER_PASSWORD, USER_PHONE_NUMBER, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH_DAY, USER_GENDER, USER_RECOMMENDER_ID, USER_JOB, USER_ID) "
            + "VALUES(SEQ_USER.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
      try {
         connection = DBConnecter.getConnection();
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setString(1, userVO.getUserName());
         preparedStatement.setString(2, userVO.getUserPassword());
         preparedStatement.setString(3, userVO.getUserPhoneNumber());
         preparedStatement.setString(4, userVO.getUserNickname());
         preparedStatement.setString(5, userVO.getUserEmail());
         preparedStatement.setString(6, userVO.getUserAddress());
         preparedStatement.setString(7, userVO.getUserBirthday());
         preparedStatement.setString(8, userVO.getUserGender());
         preparedStatement.setString(9, userVO.getUserRecommenderId());
         preparedStatement.setString(10, userVO.getUserJob());
         preparedStatement.setString(11, userVO.getUserId());
         
         preparedStatement.executeUpdate();
         
      } catch (SQLException e) {
         System.out.println("join() SQL문 오류");
         e.printStackTrace();
      } finally {
         try {
            if(preparedStatement != null) {
               preparedStatement.close();
            }
            if(connection != null) {
               connection.close();
            }
         } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
         }
      }
   }
   
//   로그인
//   외부에서 입력한 아이디와 패스워드 전달받음
   public int login(String userId, String userPassword) {
      String query = "SELECT USER_NUMBER FROM TBL_USER WHERE USER_ID = ? AND USER_PASSWORD = ?";
      int userNumber = 0;
      try {
         connection = DBConnecter.getConnection();
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setString(1, userId);
         preparedStatement.setString(2, userPassword);
         resultSet = preparedStatement.executeQuery();
         
//         DB에서 조회된 행이 있다면
         if(resultSet.next()) {
//            로그인 된 회원 번호 가져오기
            userNumber = resultSet.getInt(1);
         }
         
      } catch (SQLException e) {
         System.out.println("login() SQL 오류");
         e.printStackTrace();
      } finally {
         try {
            if(resultSet != null) {
               resultSet.close();
            }
            if(preparedStatement != null) {
               preparedStatement.close();
            }
            if(connection != null) {
               connection.close();
            }
         } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
         }
      }
      return userNumber;
   }
   
//   회원탈퇴
//   회원번호를 전달받는다.
   public void delete(int userNumber) {
      String query = "DELETE FROM TBL_USER WHERE USER_NUMBER = ?";
      try {
         connection = DBConnecter.getConnection();
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setInt(1, userNumber);
         preparedStatement.executeUpdate();
      } catch (SQLException e) {
         System.out.println("delete() SQL문 오류");
         e.printStackTrace();
      } finally {
         try {
            if(preparedStatement != null) {
               preparedStatement.close();
            }
            if(connection != null) {
               connection.close();
            }
         } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
         }
      }
   }
//   아이디 찾기
//   외부에서 핸드폰 번호를 받아온다.
   public String findIdByUserPhoneNumber(String userPhoneNumber) {
      String query = "SELECT USER_ID FROM TBL_USER WHERE USER_PHONE_NUMBER = ?";
      String userId = null;
      try {
         connection = DBConnecter.getConnection();
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setString(1, userPhoneNumber);
         resultSet = preparedStatement.executeQuery();
         
//         유효한 핸드폰 번호라면
         if(resultSet.next()) {
//            아이디를 가져온다.
            userId = resultSet.getString(1);
         }
         
         
      } catch (SQLException e) {
         System.out.println("findIdByUserPhoneNumber() SQL문 오류");
         e.printStackTrace();
      } finally {
         try {
            if(resultSet != null) {
               resultSet.close();
            }
            if(preparedStatement != null) {
               preparedStatement.close();
            }
            if(connection != null) {
               connection.close();
            }
         } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
         }
      }
      
      return userId;
   }
//   비밀번호 변경
//   아이디랑 새로운 비밀번호를 전달받는다.
   public void updateUserPassword(String userId, String userPassword) {
//      아이디로 조회하여 기존 비밀번호를 새로운 비밀번호로 변경한다.
      String query = "UPDATE TBL_USER SET USER_PASSWORD = ? WHERE USER_ID = ?";
      try {
         connection = DBConnecter.getConnection();
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setString(1, userPassword);
         preparedStatement.setString(2, userId);
         preparedStatement.executeUpdate();
         
      } catch (SQLException e) {
         System.out.println("updateUserPassword() SQL 오류");
         e.printStackTrace();
      } finally {
         try {
            if(preparedStatement != null) {
               preparedStatement.close();
            }
            if(connection != null) {
               connection.close();
            }
         } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
         }
      }
   }
   
//   회원정보 수정
//   수정완료된 전체 정보를 전달받는다.
   public void update(UserVO userVO){
      String query = "UPDATE TBL_USER "
            + "SET USER_NAME = ?, USER_PASSWORD = ?, USER_PHONE_NUMBER = ?, USER_NICKNAME = ?, USER_EMAIL = ?, USER_ADDRESS = ?, "
//            TO_DATE()를 사용하지 않았을 때 format관련 오류 발생 시 TO_DATE()로 알맞는 형식을 작성해준다.
//            DBMS의 DATE 타입에 문자열 또는 NULL을 넣기 위해서는 TO_DATE()함수를 사용하여 넣어준다. 
            + "USER_BIRTH_DAY = TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS'), USER_GENDER = ?, USER_JOB = ? "
            + "WHERE USER_NUMBER = ?";
      try {
         connection = DBConnecter.getConnection();
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setString(1, userVO.getUserName());
         preparedStatement.setString(2, userVO.getUserPassword());
         preparedStatement.setString(3, userVO.getUserPhoneNumber());
         preparedStatement.setString(4, userVO.getUserNickname());
         preparedStatement.setString(5, userVO.getUserEmail());
         preparedStatement.setString(6, userVO.getUserAddress());
         preparedStatement.setString(7, userVO.getUserBirthday());
         preparedStatement.setString(8, userVO.getUserGender());
         preparedStatement.setString(9, userVO.getUserJob());
         preparedStatement.setInt(10, userVO.getUserNumber());
         preparedStatement.executeUpdate();
         
      } catch (SQLException e) {
         System.out.println("update() SQL문 오류");
         e.printStackTrace();
      } finally {
         try {
            if(preparedStatement != null) {
               preparedStatement.close();
            }
            if(connection != null) {
               connection.close();
            }
         } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
         }
      }
   }
//   회원정보 조회
   public UserVO findByUserNumber(int userNumber) {
      String query = "SELECT USER_NUMBER, USER_NAME, USER_PASSWORD, USER_PHONE_NUMBER, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH_DAY, USER_GENDER, USER_RECOMMENDER_ID, USER_JOB, USER_ID FROM TBL_USER "
            + "WHERE USER_NUMBER = ?";
      UserVO userVO = null;
      try {
         connection = DBConnecter.getConnection();
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setInt(1, userNumber);
         resultSet = preparedStatement.executeQuery();
         
         if(resultSet.next()) {
//            조회된 결과가 있을 때에만 객체화를 진행해준다.
            userVO = new UserVO();
            
            userVO.setUserNumber(resultSet.getInt(1));
            userVO.setUserName(resultSet.getString(2));
            userVO.setUserPassword(resultSet.getString(3));
            userVO.setUserPhoneNumber(resultSet.getString(4));
            userVO.setUserNickname(resultSet.getString(5));
            userVO.setUserEmail(resultSet.getString(6));
            userVO.setUserAddress(resultSet.getString(7));
            userVO.setUserBirthday(resultSet.getString(8));
            userVO.setUserGender(resultSet.getString(9));
            userVO.setUserRecommenderId(resultSet.getString(10));
            userVO.setUserJob(resultSet.getString(11));
            userVO.setUserId(resultSet.getString(12));
         }
         
         
      } catch (SQLException e) {
         System.out.println("findByUserNumber() SQL 오류");
         e.printStackTrace();
         
      } finally {
         try {
            if(resultSet != null) {
               resultSet.close();
            }
            if(preparedStatement != null) {
               preparedStatement.close();
            }
            if(connection != null) {
               connection.close();
            }
         } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
         }
      }
      return userVO;
   }
//   추천수
//   로그인된 회원의 아이디를 전달받는다.
   public int getRecommenderCount(String userId) {
//      회원을 추천한 사람들의 수를 센다.
      String query = "SELECT COUNT(USER_RECOMMENDER_ID) FROM TBL_USER "
            + "WHERE USER_RECOMMENDER_ID = ?";
      int recommenderCount = 0;
      try {
         connection = DBConnecter.getConnection();
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setString(1, userId);
         resultSet = preparedStatement.executeQuery();
         
         resultSet.next();
         recommenderCount = resultSet.getInt(1);
         
      } catch (SQLException e) {
         System.out.println("getRecommenderCount() SQL문 오류");
         e.printStackTrace();
      } finally {
         try {
            if(resultSet != null) {
               resultSet.close();
            }
            if(preparedStatement != null) {
               preparedStatement.close();
            }
            if(connection != null) {
               connection.close();
            }
         } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
         }
      }
      return recommenderCount;
   }
   
//   나를 추천한 사람
   public ArrayList<UserVO> getRecommendedUsers(String userId) {
      String query = "SELECT USER_NUMBER, USER_NAME, USER_PASSWORD, USER_PHONE_NUMBER, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH_DAY, USER_GENDER, USER_RECOMMENDER_ID, USER_JOB, USER_ID FROM TBL_USER "
            + "WHERE USER_RECOMMENDER_ID = ?";
      ArrayList<UserVO> users = new ArrayList<UserVO>();
      try {
         connection = DBConnecter.getConnection();
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setString(1, userId);
         resultSet = preparedStatement.executeQuery();
         
//         몇 명이 추천했을 지 알 수 없기 때문에 더 이상 결과가 없을 때 까지 하나씩 행을 가져온다.
         while(resultSet.next()) {
            UserVO userVO = new UserVO();
            
//            각 행의 전체 정보를 userVO 객체에 담아준다.
            userVO.setUserNumber(resultSet.getInt(1));
            userVO.setUserName(resultSet.getString(2));
            userVO.setUserPassword(resultSet.getString(3));
            userVO.setUserPhoneNumber(resultSet.getString(4));
            userVO.setUserNickname(resultSet.getString(5));
            userVO.setUserEmail(resultSet.getString(6));
            userVO.setUserAddress(resultSet.getString(7));
            userVO.setUserBirthday(resultSet.getString(8));
            userVO.setUserGender(resultSet.getString(9));
            userVO.setUserRecommenderId(resultSet.getString(10));
            userVO.setUserJob(resultSet.getString(11));
            userVO.setUserId(resultSet.getString(12));
            
//            전체 정보가 담긴 Model 객체를 ArrayList 자료구조에 순서대로 담아준다.
            users.add(userVO);
         }
         
      } catch (SQLException e) {
         System.out.println("getRecommenderCount() SQL문 오류");
         e.printStackTrace();
      } finally {
         try {
            if(resultSet != null) {
               resultSet.close();
            }
            if(preparedStatement != null) {
               preparedStatement.close();
            }
            if(connection != null) {
               connection.close();
            }
         } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
         }
      }
      return users;
   }
   
//   내가 추천한 사람
//   로그인 된 아이디를 전달받는다.
   public UserVO getRecommender(String userId) {
//      (2)추천한 사람의 아이디로 전체 정보를 조회한다.
      String query = "SELECT USER_NUMBER, USER_NAME, USER_PASSWORD, USER_PHONE_NUMBER, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH_DAY, USER_GENDER, USER_RECOMMENDER_ID, USER_JOB, USER_ID FROM TBL_USER "
            + "WHERE USER_ID = "
            + "("
//            ▲(1)회원의 아이디로 추천한 사람의 아이디를 조회한다. 만약 NULL일 경우 빈 문자열로 처리한다.
            + "SELECT NVL(USER_RECOMMENDER_ID, \'\') FROM TBL_USER "
            + "WHERE USER_ID = ?"
            + ")";
      UserVO userVO = null;
      
      try {
         connection = DBConnecter.getConnection();
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setString(1, userId);
         resultSet = preparedStatement.executeQuery();
         
         if(resultSet.next()) {
            userVO = new UserVO();
            
            userVO.setUserNumber(resultSet.getInt(1));
            userVO.setUserName(resultSet.getString(2));
            userVO.setUserPassword(resultSet.getString(3));
            userVO.setUserPhoneNumber(resultSet.getString(4));
            userVO.setUserNickname(resultSet.getString(5));
            userVO.setUserEmail(resultSet.getString(6));
            userVO.setUserAddress(resultSet.getString(7));
            userVO.setUserBirthday(resultSet.getString(8));
            userVO.setUserGender(resultSet.getString(9));
            userVO.setUserRecommenderId(resultSet.getString(10));
            userVO.setUserJob(resultSet.getString(11));
            userVO.setUserId(resultSet.getString(12));
         }
         
      } catch (SQLException e) {
         System.out.println("getRecommenderCount() SQL문 오류");
         e.printStackTrace();
      } finally {
         try {
            if(resultSet != null) {
               resultSet.close();
            }
            if(preparedStatement != null) {
               preparedStatement.close();
            }
            if(connection != null) {
               connection.close();
            }
         } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
         }
      }
      return userVO;
   }
}


