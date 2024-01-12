package vo;

//USER_NUMBER NUMBER,
//USER_NAME VARCHAR2(1000),
//USER_PASSWORD VARCHAR2(1000),
//USER_PHONE_NUMBER VARCHAR2(1000),
//USER_NICKNAME VARCHAR2(1000),
//USER_EMAIL VARCHAR2(1000),
//USER_ADDRESS VARCHAR2(1000),
//USER_BIRTH_DAY DATE,
//USER_GENDER CHAR(1) DEFAULT 'N',
//USER_RECOMMENDER_ID VARCHAR2(1000),
//USER_JOB VARCHAR2(1000)

public class UserVO {
	private int userNumber;
	private String userName;
	private String userPassword;
	private String userPhoneNumber;
	private String userNickname;
	private String userEmail;
	private String userAddress;
	private String userBirthday;
	private String userGender;
	private String userRecommenderId;
	private String userJob;
	private String userId;
	
	public int getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}
	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserRecommenderId() {
		return userRecommenderId;
	}
	public void setUserRecommenderId(String userRecommenderId) {
		this.userRecommenderId = userRecommenderId;
	}
	public String getUserJob() {
		return userJob;
	}
	public void setUserJob(String userJob) {
		this.userJob = userJob;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	   public String toString() {
	      String str = userNumber
	            + ","   + userName
	            + "," +   userPassword
	            + "," +   userPhoneNumber
	            + "," +   userNickname
	            + "," +   userEmail
	            + "," +   userAddress
	            + "," +   userBirthday
	            + "," +   userGender
	            + "," +   userRecommenderId
	            + "," +   userJob
	            + "," + userId;
	      return str;
	   }
}

