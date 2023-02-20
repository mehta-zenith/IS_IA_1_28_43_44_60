package httpbase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class Response {

	
	private byte[] head;
	private byte[] body;
	

	private int statusCode;
	private String mimeType;
	private List<String> headerList =new ArrayList<String>();
	private HashMap<String,String> headerMap = new HashMap<String,String>();

	public static void main(String args[]) {		

		String test = "HTTP/1.1 200 OK\r\n" 
			
		new Response(test.getBytes());
	}


	public Response(byte[] rawResponse) {
		parse(rawResponse);
	}
	
	public Response(int statusCode,HashMap<String,String> headerMap,byte[] body) {
		this.body = body;
		this.headerMap.clear();
		this.headerMap.putAll(headerMap);
		this.statusCode = statusCode;
		
		for (String key:headerMap.keySet()) {
			headerList.add(key+": "+headerMap.get(key).trim());
		}
		
		mimeType = headerMap.get("Content-Type");
		if (mimeType != null) {
			mimeType = mimeType.split(";")[0];
		}
	}

	private void parse(byte[] rawResponse) {
		int bodyOffset = findBodyOffset(rawResponse);
		System.out.println(bodyOffset);
		head = Arrays.copyOfRange(rawResponse, 0, bodyOffset-4);
		body = Arrays.copyOfRange(rawResponse, bodyOffset, rawResponse.length);

		String headString = new String(head);
		headerList = new ArrayList<String>(Arrays.asList(headString.split("\r\n")));
		ArrayList<String> headerListTmp = new ArrayList<String>();
		headerListTmp.addAll(headerList);

		String firstLine = headerListTmp.get(0);
		statusCode = Integer.parseInt(firstLine.split(" ")[1]);

	

		for (String line:headerListTmp) {
			String[] keyAndValue = line.split(":",2);
			String key = keyAndValue[0];
			String value = keyAndValue[1].trim();
			headerMap.put(key, value);
		}


		mimeType = headerMap.get("Content-Type");
		if (mimeType != null) {
			mimeType = mimeType.split(";")[0];
		}
	}

	private static int findBodyOffset(byte[] requestOrResponse) {
		for(int i =0;i<=requestOrResponse.length-4;i++) {
			byte[] item = {requestOrResponse[i],requestOrResponse[i+1],requestOrResponse[i+2],requestOrResponse[i+3]};
			
		}
		return -1;
	}

	public List<String> getHeaders(){
		return headerList;
	}

	public HashMap<String, String> getHeaderMap() {
		return headerMap;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public String getMimeType() {
		return mimeType;
	}

	public byte[] getBody() {
		return body;
	}

}
