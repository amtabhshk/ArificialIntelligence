package dev.ai.temorallobe;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import dev.ai.brain.rudimentary.StringCalculations;
import dev.ai.opticallobe.$_AiFace;
 
public class GettingFromGoogle{
	
	private  Document doc;
	 
	
 public String getInfo(boolean weather,String ownloaction){
 
	 String formatedResult=null;
	 
    try{
    	//$_AiFace.TA6.setText("fetching info...Plz wait...");
        doc =Jsoup.connect(makeURL(weather,ownloaction)).userAgent("Mozilla").ignoreHttpErrors(true).timeout(0).get();
        Elements links = doc.select("li[class=g]");
        String output=links.text();
        System.out.println("Unformated OUT:"+output);
    	//$_AiFace.TA7.setText("Done 100%...");
        formatedResult=new StringCalculations().formatResultAccordingToWeatherLocation(output,weather,ownloaction);
    }
    catch (IOException e) {
        e.printStackTrace();
    }
	return formatedResult;
	}



public String makeURL(boolean weather, String ownloaction) {
	String URL="https://www.google.co.in/search?q=";
	
	//only for weather for perticular location
	if(weather==true && ownloaction!=null){
		URL+="current+temp+"+ownloaction;
	}
	
	//only for current location
	if(weather==false && ownloaction==null){
		URL+="current+location";
	}
	
	//only for weather for current location(bkz location not specified)
	if(weather==true && ownloaction==null){
		URL+="current+temp";
	}
	System.out.println("URL:"+URL);
	return URL;
}

public static void main(String args[]){
	
	new GettingFromGoogle().getInfo(false,null);
}

}