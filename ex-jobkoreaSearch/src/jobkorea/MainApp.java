package jobkorea;

import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainApp {
	
	private static final String URL = "https://www.jobkorea.co.kr/Search/?";
	
	public static void main(String[] args) throws IOException{
		String KEY_WORD = "spring";
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		Document doc = Jsoup.connect(URL + getParameter(KEY_WORD, N)).get();
		
		// System.out.println("" + doc.toString());
		Elements elements = doc.select(".list-default .clear li");
		// System.out.println(URL + getParameter(KEY_WORD, N));
		int idx = 0;
		for (Element element : elements) {
			System.out.println(++idx + " : " + element.text());
			System.out.println("=====================");
		}
		
		in.close();
	}
	
	public static String getParameter(String KEY_WORD, int PAGE) {
		return "stext=" + KEY_WORD + ""
/*							+ "&IsCoInfoSC=false"
							+ "&IsRecruit=false"
							+ "&ord=1"
							+ "&Order=1"
							+ "&page=" + PAGE + ""
							+ "&pageSize=10"
							+ "&pageType=HRP";*/
							+ "&tapType=recruit"
							+ "&Page_No="+PAGE;
	}

}
