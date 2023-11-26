package ultilities;

import constant.GHNContent;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DistrictGHNUtils {

	public static int getDistrictId(String name) {
		int result =-1;
		try {
			URL url = new URL(GHNContent.LINK_GET_DISTRICT);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", GHNContent.LINK_GET_DISTRICT);
			connection.setRequestProperty("Token", GHNContent.GHN_CLIENT_ID);
			BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			String line;
			StringBuffer response = new StringBuffer();
			while ((line = rd.readLine())!= null) {
				response.append(line);
			}
			rd.close();

			JSONObject  jsonObject = new JSONObject(response.toString());
			JSONArray data = jsonObject.getJSONArray("data");

			for (int i=0; i<data.length(); i++) {
				JSONObject district = data.getJSONObject(i);
				if(district.getString("DistrictName").equals(name)) {
					result = district.getInt("DistrictID");
					break;
				}
			}
			return result;
		} catch (Exception e) {
		}
		return -1;
	}
	public static int getDistrictIdOfWard(String name, int huyen) {
		int result = -1;
		try {
			URL url = new URL("https://online-gateway.ghn.vn/shiip/public-api/master-data/ward?district_id");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Token", GHNContent.GHN_CLIENT_ID);
			conn.setDoOutput(true);

			JSONObject jsonInput = new JSONObject();
			jsonInput.put("district_id", huyen);

			String jsonInputString = jsonInput.toString();

			conn.getOutputStream().write(jsonInputString.getBytes());

			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuilder response = new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
				response.append(new String(inputLine.getBytes(), "UTF-8"));
			}
			in.close();

			JSONObject jsonResponse = new JSONObject(response.toString());
			JSONArray data = jsonResponse.getJSONArray("data");
			for (int i = 0; i < data.length(); i++) {
				JSONObject district = data.getJSONObject(i);
				if (district.getString("WardName").equals(name)) {
					result =district.getInt("WardCode");
					break;
				}
			}

			return  result;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	public static void main(String[] args) {
		//System.out.println(token());
		System.out.println(getDistrictId("Huyện Sơn Hà"));
		System.out.println(getDistrictIdOfWard("Thị trấn Di Lăng",getDistrictId("Huyện Sơn Hà")));
	}

}
