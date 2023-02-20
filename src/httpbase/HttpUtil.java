package httpbase;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

@Deprecated
public class HttpUtil {
	
	public static String httpRequest(String requestUrl, String requestMethod, String outputStr) {
		String resultStr = "";
		StringBuffer buffer = new StringBuffer();
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
		
			httpUrlConn.setRequestMethod(requestMethod);
			httpUrlConn.setConnectTimeout(30*1000);
			httpUrlConn.setReadTimeout(10*1000);

			if ("GET".equalsIgnoreCase(requestMethod)){
				httpUrlConn.connect();
			}
		
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			
			resultStr = buffer.toString();
		} catch (ConnectException ce) {
			System.out.println("server connection timed out.");
		} catch (Exception e) {
			System.out.println(requestUrl+" request error:\n"+e);
		}
		return resultStr;
	}
	

	public static String httpsRequest(String requestUrl, String requestMethod, String outputStr) {
		String resultStr = "";
		StringBuffer buffer = new StringBuffer();
		try {
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);
			
			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			
			httpUrlConn.setRequestMethod(requestMethod);
		


			if ("GET".equalsIgnoreCase(requestMethod)){
				httpUrlConn.connect();
			}
			
			
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();

			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			
			resultStr = buffer.toString();
		} catch (ConnectException ce) {
			System.out.println("server connection timed out.");
		} catch (Exception e) {
			System.out.println(requestUrl+" request error:\n"+e);
		}
		return resultStr;
	}
	
	public static void main(String[] args) {
		System.out.println(httpRequest("", "GET", null));
	}
	
}