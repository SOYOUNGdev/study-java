package hashMapTest;

import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONTest {
	public static void main(String[] args) {
		HashMap<String, Object> userMap = new HashMap<>();
		
		JSONArray userJsons = new JSONArray();
		JSONObject userJson = null;
		
		userMap.put("id", "hds");
		userMap.put("password", "1234");
		userMap.put("name", "한동석");
		userMap.put("age", 20);
		
		userJson = new JSONObject(userMap);
//		userJson.put("phoneNumber", "01012341234");
		
		userJsons.add(userJson);
		
		userMap.put("id", "hgd");
		userMap.put("password", "3333");
		userMap.put("name", "홍길동");
		userMap.put("age", 25);
		
		userJson = new JSONObject(userMap);
		userJsons.add(userJson);
		
		System.out.println(userJsons.toJSONString());
		
//		System.out.println(userJson.toJSONString());
	}
}
