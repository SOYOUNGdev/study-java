package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.CustomerVO;

public class CustomerDAO {
   
   public static final int DELETED_USER_CODE = -1; //탈퇴 회원
   public static final int RESTORED_USER_CODE = 0; //복구된 회원(일반 회원)
   public static final int DUPLICATED_ID_CODE = 1; //중복된 아이디
   public static final int ENABLED_ID_CODE = 2; //사용가능한 아이디
   
   public Connection connection;
   public PreparedStatement preparedStatement;
   public ResultSet resultSet;
   
//   아이디 중복검사
   public int checkId(String customerId) {
      String query = "select customer_status from tbl_customer where customer_id = ?";
      int status = ENABLED_ID_CODE;
      try {
         connection = DBConnecter.getConnection();
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setString(1, customerId);
         resultSet = preparedStatement.executeQuery();
         
         if(resultSet.next()) {
            status = resultSet.getInt(1) == DELETED_USER_CODE ? DELETED_USER_CODE : DUPLICATED_ID_CODE;
         }
         
      } catch (SQLException e) {
         System.out.println("checkId() SQL 오류");
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
            e.printStackTrace();
         }
      }
      
      return status; 
   }
   
//   회원가입(핸드폰 번호 1개당 회원탈퇴 계정과 합쳐서 3번의 회원가입 가능)
   public boolean join(CustomerVO customerVO) {
      
      if(selectCount(customerVO.getCustomerPhoneNumber()) > 2) {return false;}
      
      String query = "insert into tbl_customer " 
            + "(customer_id, customer_password, customer_name, customer_age, customer_phone_number, customer_status, customer_birth) "
            + "values(?, ?, ?, ?, ?, ?, ?)";
      
      try {
         connection = DBConnecter.getConnection();
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setString(1, customerVO.getCustomerId());
         preparedStatement.setString(2, customerVO.getCustomerPassword());
         preparedStatement.setString(3, customerVO.getCustomerName());
         preparedStatement.setInt(4, customerVO.getCustomerAge());
         preparedStatement.setString(5, customerVO.getCustomerPhoneNumber());
         preparedStatement.setInt(6, customerVO.getCustomerStatus());
         preparedStatement.setString(7, customerVO.getCustomerBirth());
         
         preparedStatement.executeUpdate();
         
      } catch (SQLException e) {
         System.out.println("join() SQL 오류");
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
            e.printStackTrace();
         }
      }
      
      return false; 
   }
//   로그인
   public int login(String customerId, String customerPassword) { 
      String query = "select customer_number, customer_status from tbl_customer where customer_id = ? and customer_password = ?";
      int customerNumber = 0;
      try {
         connection = DBConnecter.getConnection();
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setString(1, customerId);
         preparedStatement.setString(2, customerPassword);
         resultSet = preparedStatement.executeQuery();
         
         if(resultSet.next()) {
            //회원 탈퇴된 회원 번호든, 일반 회원 번호든 customerNumber에 들어간다.
            customerNumber = resultSet.getInt(1);
            
            if(resultSet.getInt(2) == DELETED_USER_CODE) {
               customerNumber = DELETED_USER_CODE;
            }
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
            e.printStackTrace();
         }
      }
      return customerNumber; 
   }
//   아이디 찾기
   public ArrayList<String> findIdByCustomerPhoneNumber (String customerPhoneNumber) {
      String query = "select customer_id from tbl_customer where customer_phone_number = ?";
      ArrayList<String> customerIds = new ArrayList<String>();
      try {
         connection = DBConnecter.getConnection();
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setString(1, customerPhoneNumber);
         resultSet = preparedStatement.executeQuery();
         
         while(resultSet.next()) {
            customerIds.add(resultSet.getString(1));
         }
         
      } catch (SQLException e) {
         System.out.println("findIdByCustomerPhoneNumber() SQL 오류");
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
            e.printStackTrace();
         }
      }
      
      return customerIds; 
   }
//   회원정보 전체 수정
   public void update(CustomerVO customerVO) {
      String query = "update tbl_customer "
            + "set customer_name = ?, customer_id = ?, customer_password = ?, customer_age = ?, customer_phone_number = ?, customer_birth = ?"
            + "where customer_number = ?";
      try {
         connection = DBConnecter.getConnection();
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setString(1, customerVO.getCustomerName());
         preparedStatement.setString(2, customerVO.getCustomerId());
         preparedStatement.setString(3, customerVO.getCustomerPassword());
         preparedStatement.setInt(4, customerVO.getCustomerAge());
         preparedStatement.setString(5, customerVO.getCustomerPhoneNumber());
         preparedStatement.setString(6, customerVO.getCustomerBirth() == null ? "10000101" : customerVO.getCustomerBirth());
         preparedStatement.setInt(7, customerVO.getCustomerNumber());
         
         preparedStatement.executeUpdate();
         
      } catch (SQLException e) {
         System.out.println("update() SQL 오류");
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
            e.printStackTrace();
         }
      }
   }
   
//   회원 1명 전체 정보 조회
   public CustomerVO findCustomerById(int customerNumber) {
      String query = " select customer_id, customer_password, customer_name, customer_age, customer_phone_number, customer_status, customer_birth from tbl_customer "
            + "where customer_number = ?";
      CustomerVO customerVO = null;
      
      try {
         connection = DBConnecter.getConnection();
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setInt(1, customerNumber);
         resultSet = preparedStatement.executeQuery();
         
         if(resultSet.next()) {
            customerVO = new CustomerVO();
            
            customerVO.setCustomerNumber(customerNumber);
            customerVO.setCustomerId(resultSet.getString(1));
            customerVO.setCustomerPassword(resultSet.getString(2));
            customerVO.setCustomerName(resultSet.getString(3));
            customerVO.setCustomerAge(resultSet.getInt(4));
            customerVO.setCustomerPhoneNumber(resultSet.getString(5));
            customerVO.setCustomerStatus(resultSet.getInt(6));
            customerVO.setCustomerBirth(resultSet.getString(7));
         }
         
      } catch (SQLException e) {
         System.out.println("findCustomerById() SQL 오류");
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
            e.printStackTrace();
         }
      }
      
      return customerVO; 
   }
//   회원탈퇴
   public void delete(int customerNumber) {
      String query = "update tbl_customer set customer_status = ? where customer_number = ?";
      
      try {
         connection = DBConnecter.getConnection();
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setInt(1, DELETED_USER_CODE);
         preparedStatement.setInt(2, customerNumber);
         preparedStatement.executeUpdate();
         
      } catch (SQLException e) {
         System.out.println("delete() SQL 오류");
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
            e.printStackTrace();
         }
      }
   }
//   회원탈퇴 복구
   public void restore(int customerNumber) {
      String query = "update tbl_customer set customer_status = ? where customer_number = ?";
      
      try {
         connection = DBConnecter.getConnection();
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setInt(1, RESTORED_USER_CODE);
         preparedStatement.setInt(2, customerNumber);
         preparedStatement.executeUpdate();
         
      } catch (SQLException e) {
         System.out.println("restore() SQL 오류");
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
            e.printStackTrace();
         }
      }
   }
//   핸드폰 번호로 가입한 전체 회원 정보 조회
   public ArrayList<CustomerVO> findCustomersByCustomerPhoneNumber(String customerPhoneNumber){ 
      String query = "select customer_id, customer_number, customer_status from tbl_customer where customer_phone_number = ?";
      ArrayList<CustomerVO> customers = new ArrayList<CustomerVO>();
      CustomerVO customerVO = null;
      
      try {
         connection = DBConnecter.getConnection();
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setString(1, customerPhoneNumber);
         resultSet = preparedStatement.executeQuery();
         
         while(resultSet.next()) {
            customerVO = new CustomerVO();
            
            customerVO.setCustomerId(resultSet.getString(1));
            customerVO.setCustomerNumber(resultSet.getInt(2));
            customerVO.setCustomerStatus(resultSet.getInt(3));
            
            customers.add(customerVO);
         }
         
      } catch (SQLException e) {
         System.out.println("findCustomersByCustomerPhoneNumber() SQL 오류");
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
            e.printStackTrace();
         }
      }
      
      return customers; 
   }
//   동일한 핸드폰 번호로 가입된 회원의 수
   public int selectCount(String customerPhoneNumber) {
      String query = "select count(customer_id) from tbl_customer where customer_phone_number = ?";
      int count = 0;
      try {
         connection = DBConnecter.getConnection();
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setString(1, customerPhoneNumber);
         resultSet = preparedStatement.executeQuery();
         
         resultSet.next();
         count = resultSet.getInt(1);
         
      } catch (SQLException e) {
         System.out.println("selectCount() SQL 오류");
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
            e.printStackTrace();
         }
      }
      
      return count; 
   }
   
   
}



















