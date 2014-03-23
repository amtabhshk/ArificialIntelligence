package dev.ai.stt;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import dev.ai.opticallobe.$_AiFace;


public class SpeachToText {

	/**
	 *@author Bapu
	 * @param args
	 * @throws Exception 
	 */
	
	public String SpeachToText(String pathh) throws Exception{
		
		 String hypothesis=null;
	     Path path = Paths.get(pathh);
	   
	           byte[] data = Files.readAllBytes(path);
	  
	           
	           String request = "https://www.google.com/"+
	                    "speech-api/v1/recognize?"+
	                    "xjerr=1&client=chromium&lang=en-IN&maxresults=10&pfilter=0";
	           URL url = new URL(request);
	           HttpURLConnection connection = (HttpURLConnection) url.openConnection();          
	           connection.setDoOutput(true);
	           connection.setDoInput(true);
	           connection.setInstanceFollowRedirects(false);
	           connection.setRequestMethod("POST");
	           connection.setRequestProperty("Content-Type", "audio/x-flac; rate=16000");
	           //connection.setRequestProperty("chromium", "speech2text");
	           connection.setConnectTimeout(60000);
	           connection.setUseCaches (false);
	           try{
	           DataOutputStream wr = new DataOutputStream(connection.getOutputStream ());
	           //wr.writeBytes(new String(data));
	          wr.write(data);
	           wr.flush();
	           wr.close();
	          // connection.disconnect();
	           System.out.println("Upload Done...");   
	           $_AiFace.TA1.setText("Upload Done...Plz wait...");
	           }catch(Exception n){
	        	   $_AiFace.TA1.setText("Remote host closed connection while hand shake..Please Exit");
	           }
	           BufferedReader in=null;
	           try{
	           in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	          
	                    String decodedString=null;
	                    while ((decodedString=in.readLine())!= null) {
	                    	System.out.println("Decoding...");
	                    	$_AiFace.TA2.setText("Decoding...Plz wait..");
	                    	hypothesis=decodedString;
	                    	//System.out.println("Decoded..:"+decodedString);
	                    	
	                    
	                    }
	           }catch(java.io.IOException e){
	        	   $_AiFace.TA2.setText("Server returned HTTP response code: 500");
	        	   $_AiFace.TA3.setText("May be Your connection is slow");
	        	   $_AiFace.TA4.setText("Try again,Plz don't speak very close to mic");
	        	   $_AiFace.TA5.setText("or you can try writing in the Text Field");
	           }
	                    
			return hypothesis;
	}
	
}
