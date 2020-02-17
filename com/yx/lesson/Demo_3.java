package src.com.yx.lesson;

import java.awt.Panel;
import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Demo_3 extends Panel {

	public static void muzicAll(String name, File file, boolean b) {

		if (b == false) {
			return;
		}
		int n = 1;
		String song_count = "";
		try {
			int number = 1;
			for (int i = 0; i < number;) {

				Document doc = Jsoup.connect(
						"http://www.kuwo.cn/api/www/search/searchMusicBykeyWord?key=" + name + "&&pn=" + n + "&rn=30")
						.ignoreContentType(true).get();

				JSONObject json_doc = JSONObject.fromObject(doc.select("body").text()).getJSONObject("data");
				// 获取歌曲总数
				song_count = json_doc.getString("total");
				number = Integer.parseInt(song_count);
				JSONArray jarray = json_doc.getJSONArray("list");
				n += 1;

				for (Object obj : jarray) {
					i++;
					JSONObject json_music = JSONObject.fromObject(obj.toString());
					String singer_name = json_music.getString("artist");
					String song_name = json_music.getString("name");

					String song_rid = json_music.getString("rid");
					Testmuzic t = new Testmuzic(song_name);

					/*
					 * System.out.println(json_music.getString("artist"));
					 * System.out.println(json_music.getString("rid"));
					 * System.out.println(json_music.getString("name"));
					 */
					String urls = "http://www.kuwo.cn/url?format=mp3&rid=" + song_rid
							+ "&response=url&type=convert_url3&br=128kmp3&from=web&t=1564037749652&reqId=3c568541-aea9-11e9-baf6-3f2902c3a273";

					Demo_1.download(Demo_3.paresUrl(urls), file, song_name + ".mp3");

				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String paresUrl(String url)

	{
		Document doc;
		String song_url = null;
		try {
			doc = Jsoup.connect(url).ignoreContentType(true).get();
			String str_json = doc.select("body").text();
			JSONObject json = JSONObject.fromObject(str_json);

			song_url = json.getString("url");
			System.out.println(song_url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return song_url;
	}
}
