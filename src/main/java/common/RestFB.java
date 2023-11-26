package common;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.types.User;

import helper.Contants;

public class RestFB {
	
	public static String getToken(final String code) throws ClientProtocolException, IOException {
		//tự viết api gettoken
		
		//chuẩn bị link api của facebook
		String link = "";
		if (Contants.ISLOCALHOST) {
			 link = String.format(Constants.FACEBOOK_LINK_GET_TOKEN, Constants.FACEBOOK_APP_ID, Constants.FACEBOOK_APP_SECRET, Constants.FACEBOOK_REDIRECT_URL_4_LOCALHOST, code);
		} else {
			 link = String.format(Constants.FACEBOOK_LINK_GET_TOKEN, Constants.FACEBOOK_APP_ID, Constants.FACEBOOK_APP_SECRET, Constants.FACEBOOK_REDIRECT_URL_4_AZURE, code);//azure
		}
		
		//dùng thư viện requet gọi method get lấy thông tin
		String response = Request.Get(link).execute().returnContent().asString();
		JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
		//nếu trả về dữ liệu có accesstoken là có nghĩa login facebook thành công
		String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
		return accessToken;
	}
	
	public static User getUserInfo(String accessToken) {
		//dựa vào accesstoken gọi api của facebook client để lấy thông tin
		FacebookClient facebookClient = new DefaultFacebookClient(accessToken, Constants.FACEBOOK_APP_SECRET, Version.LATEST);
		return facebookClient.fetchObject("me", User.class);
	}
	//https://localhost:8443/login-facebook?code=AQC_p5gQyCTKolnmNH4mJABTlGcgMtrGKHGnRstxn7jEOnu-DfVZ69DvTWhFnqx2d73SXqojbF9NXcvDSGnMtzBaYRecwrJsAHkY3OcPFRRM8YIa3T4awitQcKnOojdbn10yBI23fmNlj5c3Xmtdhoms51yspw7vhQXy35a5oXZ52puFA-wiILCwMBg_akd0fcJ0cuIKjZKKwR6cUqhA4oPce54WrkKfrOD9Pz6xOjSZUmKnqqpKKb5Z3Hj9oDKTSA02DdkCuapBNH1MOtCw-f-VifQSAbAgbpPDSuDij8BEZ4dagS7VuSg6kxQ0fhocWaNrangXrDEqOu8upqf_swzHfd6ic1Z0B5ql_i93-MG8HG7F9OgAs-TULmRmYTXPiJ0otAKUVfqETm3bNsC6MqxIY61h8hC1UH2SZ1dEo8bZqQ#_=_

	//https://graph.facebook.com/oauth/access_token?client_id=%s&client_secret=%s&redirect_uri=%s&code=%s
	//https://graph.facebook.com/oauth/access_token?client_id=178067928037086&client_secret=d5b1bca26d74621d2cffc9f08f53cf24&redirect_uri=https://localhost:8443/login-facebook&code=
    //https://graph.facebook.com/oauth/access_token?client_id=178067928037086&client_secret=d5b1bca26d74621d2cffc9f08f53cf24&redirect_uri=https://localhost:8443/login-facebook&code=AQC_p5gQyCTKolnmNH4mJABTlGcgMtrGKHGnRstxn7jEOnu-DfVZ69DvTWhFnqx2d73SXqojbF9NXcvDSGnMtzBaYRecwrJsAHkY3OcPFRRM8YIa3T4awitQcKnOojdbn10yBI23fmNlj5c3Xmtdhoms51yspw7vhQXy35a5oXZ52puFA-wiILCwMBg_akd0fcJ0cuIKjZKKwR6cUqhA4oPce54WrkKfrOD9Pz6xOjSZUmKnqqpKKb5Z3Hj9oDKTSA02DdkCuapBNH1MOtCw-f-VifQSAbAgbpPDSuDij8BEZ4dagS7VuSg6kxQ0fhocWaNrangXrDEqOu8upqf_swzHfd6ic1Z0B5ql_i93-MG8HG7F9OgAs-TULmRmYTXPiJ0otAKUVfqETm3bNsC6MqxIY61h8hC1UH2SZ1dEo8bZqQ#_=_
	/* Khi gọi api get accesstoken thì sẽ trả ra được output
	 {
		  "access_token": "EAACh86uYtt4BAIdnL0UBJiWTHwuGhpKh24oSZBu3AiR9R5ZBeB2eY5oQ9vIzORHkqUWG3ah3ztDZAxHDRLHKbfm9ykBMbrmtwLTOEiPDMYWJpJpPYPeiPUtmxse7WRBkxsHnNPT2EpLMV2KroiZCgDlJLkH6CK5chE5ZBXRBNpYt3pVvZBZBY4ZB7RIogTV1O1WPYYbyHRKJzRFMPTswgKrN5bO6CUyYSKVaHuPL5fkLlAZDZD",
		  "token_type": "bearer",
		  "expires_in": 5182890
	  }
	  */
}
