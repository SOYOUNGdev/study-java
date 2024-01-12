package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dao.CustomerDAO;
import dao.DBConnecter;
import vo.CustomerVO;

public class Test {
   public static void main(String[] args) {
//      연결 테스트
//      try {
//         Connection connection = DBConnecter.getConnection();
//         connection.close();
//      } catch (SQLException e) {
//         e.printStackTrace();
//      }
      
      CustomerDAO customerDAO = new CustomerDAO();
      
//      CustomerVO customerVO = new CustomerVO();
//      customerVO.setCustomerId("jbg");
//      customerVO.setCustomerName("장보고");
//      customerVO.setCustomerAge(46);
//      customerVO.setCustomerPassword("9999");
//      customerVO.setCustomerPhoneNumber("01012341234");
//      customerVO.setCustomerBirth("2009-11-11");
      
//      아이디 중복검사
//      System.out.println(customerDAO.checkId(customerVO.getCustomerId()));
      
//      회원가입
//      int i = 0;
//      
//      if(customerDAO.join(customerVO)) {
//         System.out.println("성공");
//      }else {
//         System.out.println("더 이상 회원가입을 할 수 없습니다.");
//         Scanner sc = new Scanner(System.in);
//         String customerId = null, customerPassword = null;
//         int status = 0;
//         
//         ArrayList<CustomerVO> customers = customerDAO.findCustomersByCustomerPhoneNumber(customerVO.getCustomerPhoneNumber());
//         
//         for(CustomerVO customer : customers) {
//            System.out.println(++i + ". " + customer.getCustomerId() + ", " + (customer.getCustomerStatus() == 0 ? "로그인 하기" : "복구하기"));
//         }
//         System.out.println("로그인 혹은 복구할 계정 번호를 선택하세요.");
//         
//         i = sc.nextInt() - 1;
//         
//         if(customers.get(i).getCustomerStatus() == -1) {
//            customerDAO.restore(customers.get(i).getCustomerNumber());
//            System.out.println("복구 되었습니다.");
//         }
//         
//         System.out.print("아이디 : ");
//         customerId = sc.next();
//         System.out.print("비밀번호 : ");
//         customerPassword = sc.next();
//         
//         status = customerDAO.login(customerId, customerPassword);
//         
//         if(status == -1) {
//            System.out.println("탈퇴된 계정입니다.");
//         }else if(status == 0) {
//            System.out.println("로그인 실패");
//         }else {
//            System.out.println("로그인 성공");
//         }
//         
//      }
      
//      회원 탈퇴
//      customerDAO.delete(3);
      
//      아이디 찾기
//      customerDAO.findIdByCustomerPhoneNumber("01055555555").forEach(System.out::println);
   
//      회원정보 수정
      CustomerVO customerVO = customerDAO.findCustomerById(1);
      if(customerVO != null) {
         customerVO.setCustomerBirth(null);
         
         customerDAO.update(customerVO);
         
      }
      
      
   }
}


