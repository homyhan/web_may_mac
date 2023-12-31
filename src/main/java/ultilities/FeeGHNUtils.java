package ultilities;

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
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

public class FeeGHNUtils {
	public static String registerShip(int  from_district_id, int from_ward_id,String tenHuyen, String tenXa) {
		String apiUrl = "http://140.238.54.136/api/registerTransport";
		String authToken =token();
		ArrayList<String> result = new ArrayList<>();
		try {
			int districtId_to = DistrictGHNUtils.getDistrictId(tenHuyen);
			int ward_id_to = DistrictGHNUtils.getDistrictIdOfWard(tenXa,districtId_to);
			Map<String, String> params = new HashMap<>();
			params.put("height", String.valueOf(100));
			params.put("length", String.valueOf(50));
			params.put("width", String.valueOf(30));
			params.put("weight", String.valueOf(1000));
			params.put("from_district_id", from_district_id+"");
			params.put("from_ward_id", from_ward_id+"");
			params.put("to_district_id", districtId_to+"");
			params.put("to_ward_id", ward_id_to+"");
			StringBuilder postData = new StringBuilder();
			for (Map.Entry<String, String> param : params.entrySet()) {
				if (postData.length() != 0) postData.append('&');
				postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
				postData.append('=');
				postData.append(URLEncoder.encode(param.getValue(), "UTF-8"));
			}
			URL url = new URL(apiUrl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Authorization", "Bearer " + authToken);
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			con.setRequestProperty("Content-Length", Integer.toString(postData.toString().getBytes().length));
			con.setDoOutput(true);
			con.getOutputStream().write(postData.toString().getBytes(StandardCharsets.UTF_8));
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuilder response = new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// Parse the JSON response to get the cost and time
			JSONObject jsonObject = new JSONObject(response.toString());
			JSONObject transportObject = jsonObject.getJSONObject("Transport");
			String id = transportObject.getString("id");
			return  id;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public static String token()  {
		try {
			HttpClient httpClient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost("http://140.238.54.136/api/auth/login");

			List<NameValuePair> params = new ArrayList<>();
			params.add(new BasicNameValuePair("email", "20130307@gmail"));
			params.add(new BasicNameValuePair("password", "123456"));

			httpPost.setEntity(new UrlEncodedFormEntity(params));
			httpPost.setHeader(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");

			HttpEntity httpEntity = httpClient.execute(httpPost).getEntity();
			String response = EntityUtils.toString(httpEntity);
			String token = response.replace("{\"access_token\":\"", "");
			String tokenResponse = token;
			int startIndex = tokenResponse.indexOf("token\":")+1;
			int endIndex = tokenResponse.indexOf(",\"token_type\"")-1;
			String token1 = tokenResponse.substring(startIndex, endIndex);
			return token1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public static double getFeeShip( int from_district_id, int from_ward_id,String tenHuyen, String tenXa) {
		String apiUrl = "http://140.238.54.136/api/calculateFee";
		String authToken = token();
		double result = 0.0;
		try {
			int districtId_to = DistrictGHNUtils.getDistrictId(tenHuyen);
			int ward_id_to = DistrictGHNUtils.getDistrictIdOfWard(tenXa, districtId_to);
			Map<String, String> params = new HashMap<>();
			params.put("height", String.valueOf(100));
			params.put("length", String.valueOf(50));
			params.put("width", String.valueOf(30));
			params.put("weight", String.valueOf(1000));
			params.put("from_district_id", String.valueOf(from_district_id));
			params.put("from_ward_id", String.valueOf(from_ward_id));
			params.put("to_district_id", String.valueOf(districtId_to));
			params.put("to_ward_id", String.valueOf(ward_id_to));
			System.out.println(params);
			StringBuilder postData = new StringBuilder();
			for (Map.Entry<String, String> param : params.entrySet()) {
				if (postData.length() != 0) postData.append('&');
				postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
				postData.append('=');
				postData.append(URLEncoder.encode(param.getValue(), "UTF-8"));
			}
			System.out.println(params);
			URL url = new URL(apiUrl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Authorization", "Bearer " + authToken);
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			con.setRequestProperty("Content-Length", Integer.toString(postData.toString().getBytes().length));
			con.setDoOutput(true);
			con.getOutputStream().write(postData.toString().getBytes(StandardCharsets.UTF_8));
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuilder response = new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// Parse the JSON response to get the cost and time
			System.out.println(response.toString());
			JSONObject jsonObject = new JSONObject(response.toString());
			JSONArray dataArray = jsonObject.getJSONArray("data");
			JSONObject dataObject = dataArray.getJSONObject(0);
			double cost = dataObject.getDouble("service_fee");
			result = cost;
			return  result;
		} catch (Exception e) {
		}
		return result;
	}
	public static String getDateShip(int from_district_id, int from_ward_id,String tenHuyen, String tenXa) {
		String apiUrl = "http://140.238.54.136/api/leadTime";
		String authToken = token();
		String result = "";
		try {
			int districtId_to = DistrictGHNUtils.getDistrictId(tenHuyen);
			int ward_id_to = DistrictGHNUtils.getDistrictIdOfWard(tenXa, districtId_to);
			Map<String, String> params = new HashMap<>();
			params.put("height", String.valueOf(100));
			params.put("length", String.valueOf(50));
			params.put("width", String.valueOf(30));
			params.put("weight", String.valueOf(1000));
			params.put("from_district_id", String.valueOf(from_district_id));
			params.put("from_ward_id", String.valueOf(from_ward_id));
			params.put("to_district_id", String.valueOf(districtId_to));
			params.put("to_ward_id", String.valueOf(ward_id_to));
			StringBuilder postData = new StringBuilder();
			for (Map.Entry<String, String> param : params.entrySet()) {
				if (postData.length() != 0) postData.append('&');
				postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
				postData.append('=');
				postData.append(URLEncoder.encode(param.getValue(), "UTF-8"));
			}
			URL url = new URL(apiUrl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Authorization", "Bearer " + authToken);
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			con.setRequestProperty("Content-Length", Integer.toString(postData.toString().getBytes().length));
			con.setDoOutput(true);
			con.getOutputStream().write(postData.toString().getBytes(StandardCharsets.UTF_8));
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuilder response = new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			System.out.println(response.toString());
			JSONObject jsonObject = new JSONObject(response.toString());
			JSONArray dataArray = jsonObject.getJSONArray("data");
			JSONObject dataObject = dataArray.getJSONObject(0);

			int time = dataObject.getInt("timestamp");
			Date dateTime = new Date(time * 1000L); // Convert seconds to milliseconds
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd"); // Format the date
			String formattedDate = dateFormat.format(dateTime); // Format the date as a string
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dateTime);
			calendar.add(Calendar.DATE, 3); // Add 3 days
			Date newdateTime = (Date) calendar.getTime();
			SimpleDateFormat newDateFormat = new SimpleDateFormat("yyyy/MM/dd"); // Format the date
			String newFormattedDate = newDateFormat.format(newdateTime); // Format the date as a string
			result = (formattedDate + " - " + newFormattedDate);
			return result;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	public static String getID(String id) {
		String apiUrl = "http://140.238.54.136/api/allTransports ";
		String authToken =token();
		try {

			URL url = new URL(apiUrl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Authorization", "Bearer " + authToken);
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuilder response = new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			return response.toString();



		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}
	public static void main(String[] args) {
		System.out.println(token());
		System.out.println(getFeeShip(3695, 90737, "Huyện Sơn Hà", "Thị trấn Di Lăng"));
		System.out.println(getDateShip(3695,90737,"Huyện Sơn Hà","Thị trấn Di Lăng"));
	}
}