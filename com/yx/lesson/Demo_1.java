package src.com.yx.lesson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Demo_1 {

	public static void download(String urls, File file, String song_name) {
		FileOutputStream fos = null;
		try {
			URL url = new URL(urls);
			// 链接上了服务器
			URLConnection con = url.openConnection();
			// 获取字节输入流
			InputStream is = con.getInputStream();
			// 判断是否存在这个文件夹
			// 例如 e:\\music\\周杰伦
			/*
			 * File file_dic=new File(path+"\\"); //判断文件是否存在 if(!file_dic.exists()) {
			 * //创建文件夹 file_dic.mkdirs(); }
			 */

			File file1 = new File(file.getPath() + "\\" + song_name);
			System.out.println(file1.getPath());
			if (!file.exists()) {
				// 创建文件夹
				file.createNewFile();
			}
			fos = new FileOutputStream(file1);
			byte[] bys = new byte[1024];
			int len = 0;
			while ((len = is.read(bys)) != -1) {
				fos.write(bys, 0, len);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (fos != null)
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

//	public static void main(String[] args) {
//
//		/*
//		 * JSONObject json=JSONObject.
//		 * fromObject("{\"code\": 200, \"msg\": \"success\", \"url\": \"https://win-web-rh01-sycdn.kuwo.cn/0fee6bc0f618221b04f449bdd2991f37/5d39527c/resource/n2/77/88/427663201.mp3\"}"
//		 * ); //http://www.kuwo.cn/url?format=mp3&rid=6691107&response=url&type=
//		 * convert_url3&br=128kmp3&from=web&t=1564037749652&reqId=3c568541-aea9-11e9-
//		 * baf6-3f2902c3a273 String str=json.getString("code"); System.out.println(str);
//		 */
//		// {"code":"aaa","phone":"13838384388"}
//		// {"code": 200, "msg": "success", "url":
//		// "https://win-web-rh01-sycdn.kuwo.cn/0fee6bc0f618221b04f449bdd2991f37/5d39527c/resource/n2/77/88/427663201.mp3"}
//		// String str="{}"
//		try {
//			Document doc = Jsoup.connect(
//					"http://www.kuwo.cn/api/www/search/searchMusicBykeyWord?key=%E5%91%A8%E6%9D%B0%E4%BC%A6&&pn=" + 1
//							+ "&rn=30")
//					.ignoreContentType(true).get();
//			String str_json = doc.select("body").text();
//			JSONObject json = JSONObject.fromObject(str_json);
//			System.out.println(json.getString("url"));
//
////		Demo_1.download(json.getString("url"), "d:\\", "来自地狱的疯子.mp3");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
}
