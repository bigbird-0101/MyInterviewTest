package com.reptile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 时间:2019年1月29日
 * 
 * @author pefuxc
 *
 */
public class TestReptile {

	/**
	 * 爬虫子类 时间:2019年1月29日
	 * 
	 * @author pefuxc
	 *
	 */
	class Reptile {
		private String url;

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getCont() {
			StringBuffer aContent = new StringBuffer();
			try {
				URL aUrl = new URL(url);
				URLConnection aURLConnection = aUrl.openConnection();
				aURLConnection.setDoOutput(true);
				aURLConnection.setDoInput(true);
				aURLConnection.setUseCaches(false);
				aURLConnection.setConnectTimeout(10000);
				aURLConnection.setReadTimeout(10000);
				aURLConnection.setRequestProperty("Pragma:", "no-cache");
				aURLConnection.setRequestProperty("Cache-Control", "no-cache");
				aURLConnection.setRequestProperty("Content-Type",
						"text/xml;charset=UTF-8");
				aURLConnection.connect();
				OutputStreamWriter aOutputStreamWriter = new OutputStreamWriter(
						aURLConnection.getOutputStream());
				aOutputStreamWriter.flush();
				aOutputStreamWriter.close();
				InputStreamReader aInputStreamReader = new InputStreamReader(
						aURLConnection.getInputStream());
				BufferedReader aBufferedReader = new BufferedReader(
						aInputStreamReader);
				for (String line = aBufferedReader.readLine(); line != null; line = aBufferedReader
						.readLine()) {
					aContent.append(line);
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return aContent.toString();
		}

	}

	public static void main(String[] args) {
		Reptile aReptile=new TestReptile().new Reptile();
		aReptile.setUrl("https://blog.csdn.net/mollen/article/details/86498499");
		String aContent=aReptile.getCont();
		System.out.println(aContent);
	}
}