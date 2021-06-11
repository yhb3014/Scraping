package cgv;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainApp {
	
	private static final String URL = "http://www.cgv.co.kr/movies/";
	
	public static void main(String[] args) throws IOException{
		
		Document doc = Jsoup.connect(URL).get();
		Elements elements = doc.select("div.sect-movie-chart");
		
		System.out.println("==========================");
		
		Iterator<Element> ie1 = elements.select("strong.rank").iterator();
		Iterator<Element> ie2 = elements.select("strong.title").iterator();
		Iterator<Element> ie3 = elements.select("span.percent").iterator();
		
		while(ie1.hasNext()) {
			System.out.println(ie1.next().text() + "\t" + ie2.next().text() + "\t" +"평점 : "+ ie3.next().text());
		}
		
		System.out.println("==========================");
	}

}
