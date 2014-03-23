package dev.ai.temorallobe;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import dev.ai.opticallobe.$_AiFace;

/**
 * @author Bapu
 *
 */
public class GettingWhoFromNet {
	
	
	public String gettingFromWiki(String calculatedwhoperson){
		  Document doc=null;
		  String[] paragraph=new String[2];
		  paragraph[0]="Sorry Could not fetch the data,I've imformed my creator to fix it. Please try again";
		try {
			System.out.println("link:"+calculatedwhoperson);
			$_AiFace.TA6.setText("fetching info...Plz wait...");
			doc = Jsoup.connect("http://en.wikipedia.org/wiki/"+calculatedwhoperson)
			  .data("query", "Java")
			  .userAgent("Mozilla")
			  .cookie("auth", "token")
			  .timeout(0)
			  .get();
		} catch (IOException e) {
			System.out.println("error in:GettingWhoFromNet.java"+e);
		}
		 try{
		  			Elements paragraphs = doc.select(".mw-content-ltr p");
		  			Element firstParagraph = paragraphs.first();
		  			Element lastParagraph = paragraphs.last();
		  			Element p;
		  			int i=1;
		  			p=firstParagraph;
		  			paragraph[0]=p.text();
		  			System.out.println("getting data:"+paragraph[0]);
		  			//return paragraph[0];
		  			while (p!=lastParagraph){
		  				p=paragraphs.get(i);
			  				System.out.println(p.text());
			  				i++;
		  			}
		  			$_AiFace.TA7.setText("Done 100%...");
					return paragraph[0]; 
		 }catch(Exception e){
			 return paragraph[0];
		 }

	}

}
