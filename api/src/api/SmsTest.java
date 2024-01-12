package api;

import java.util.HashMap;	// ctrl shift o

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class SmsTest {
	public static void main(String[] args) {
		String api_key = "NCS048ZXN4LLNFAK";
	    String api_secret = "MWIKKVCXXJV4SM4JVGQC2U28VEOWHENH";
	    Message coolsms = new Message(api_key, api_secret);

	    // 4 params(to, from, type, text) are mandatory. must be filled
	    HashMap<String, String> params = new HashMap<String, String>();
	    params.put("to", "01023290798");
	    params.put("from", "01023290798");
	    params.put("type", "SMS");
	    params.put("text", "문 앞에 택배 놓고 갑니다");
	    params.put("app_version", "test app 1.2"); // application name and version

	    try {
	      JSONObject obj = (JSONObject) coolsms.send(params);
	      System.out.println(obj.toString());
	    } catch (CoolsmsException e) {
	      System.out.println(e.getMessage());
	      System.out.println(e.getCode());
	    }
	}
}
