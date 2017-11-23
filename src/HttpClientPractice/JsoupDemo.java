package HttpClientPractice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupDemo {
	static List<Info> infoList = new ArrayList();

	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				getList();
			}
		}).start();
		
//		for (Info infos : infoList) {
//			System.out.println(infos.toString());
//		}
	}

	public static void getList() {
		try {
			for (int i = 1; i <= 14; i++) {
				String baseUrl = "http://www.med66.com/kouqiangxiufu/page" + i + ".shtm";
				Document doc = Jsoup.connect(baseUrl).get();
				// System.out.println(doc);
				Elements ele = doc.getElementsByClass("main_left").select("ul").select("li");
				// System.out.println(ele);
				Info info;
				for (Element child : ele) {
					// System.out.println(child);
					String date = child.select("span").text();
					String url = child.select("a").attr("href");
					String content = getContent(url);

					String title = child.select("a").text();
					info = new Info(date, url, title, content);

						if (!"".equals(date)) {
							infoList.add(info);
							System.out.println(info.toString());
						}

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getContent(String url) {
		String content = "";
		Document doc;
		if (!"".equals(url)) {
			try {
				doc = Jsoup.connect(url.trim()).get();
				// System.out.println(doc.getElementById("fontzoom").text());
				if (doc != null && content != null && doc.getElementById("fontzoom")!=null) {
					content = doc.getElementById("fontzoom").text();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return content;
	}

}

class Info {
	private String date;
	private String url;
	private String title;
	private String content;

	public Info(String date, String url, String title, String content) {
		this.date = date;
		this.url = url;
		this.title = title;
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public String getUrl() {
		return url;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return date + "\n" + url + "\n" + title + "\n" + content;
	}
}
