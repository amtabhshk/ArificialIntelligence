package dev.ai.brain.decision;

import dev.ai.brain.rudimentary.StringCalculations;
import dev.ai.temorallobe.GettingFromGoogle;
import dev.ai.temorallobe.GettingWhoFromNet;

public class DiscisionForWhWord {
	private String calculatedwhoperson=null;
	static StringCalculations calculations;
	
	public String redirectAccordingToWhWords(String whword,String originalString){
		if(whword.equalsIgnoreCase("who")){
			return who(whword,originalString);
		}
		else if(whword.equalsIgnoreCase("when")){
			return when(whword,originalString);
		}
		else if(whword.equalsIgnoreCase("what")){
			return what(whword,originalString);
			
		}
		else if(whword.equalsIgnoreCase("where")){
			return where(whword,originalString);
		}
		else if(whword.equalsIgnoreCase("how")){
			return how(whword,originalString);
		}
		else{
			return "No wh Word in DiscisioForWhWord.java";
		}
		
		
	}
	
	private String how(String whword, String originalString) {
		// TODO Auto-generated method stub
		return "Not yet implemented by Amit Abhishek";
	}

	private String where(String whword, String originalString) {
		// TODO Auto-generated method stub
		return "Not yet implemented by Amit Abhishek";
	}

	private String what(String whword, String originalString) {
		calculations=new StringCalculations();
		String rse=null;
		
		if(whword.equalsIgnoreCase("what")){
			
		  if(originalString.contains("weather") || originalString.contains("temp") || originalString.contains("current") || originalString.contains("location") || originalString.contains("my")){
				
			if(originalString.contains("weather") || originalString.contains("temp")){
				//"Weather of "+calculations.findWordAfter(originalString, "of", 1)+" is "+ 
				rse=new GettingFromGoogle().getInfo(true,calculations.findWordAfter(originalString, "of", 1));		
			}
			else if((originalString.contains("my") || originalString.contains("current")) &&  (originalString.contains("location") )){
				rse= "Your Location is "+new GettingFromGoogle().getInfo(false,null);
			}
			else if((originalString.contains("my") || originalString.contains("current")) &&  (originalString.contains("weather") )){
				rse= "Weather of your current location "+new GettingFromGoogle().getInfo(true,null);
			}
		  }
				
			else {
				if((calculations.findWordAfter(originalString, whword, 1)).equalsIgnoreCase("is")){	
					calculatedwhoperson=calculations.findUptoLastWord(originalString,"is");		
				}
			else{		
				calculatedwhoperson=calculations.findUptoLastWord(originalString,whword);	
				}
				rse=new GettingWhoFromNet().gettingFromWiki(calculatedwhoperson);	
		  }
		}
		return rse;
		
			
	}

	private String when(String whword, String originalString) {
		// TODO Auto-generated method stub
		return "Not yet implemented by Amit Abhishek";
	}

	public String who(String whword,String originalString){
		calculations=new StringCalculations();
		if(whword.equalsIgnoreCase("who")){	
			if((calculations.findWordAfter(originalString, whword, 1)).equalsIgnoreCase("is")){	
					calculatedwhoperson=calculations.findUptoLastWord(originalString,"is");
				}
			else{
				
				calculatedwhoperson=calculations.findUptoLastWord(originalString,whword);
			}
			
		}
		return new GettingWhoFromNet().gettingFromWiki(calculatedwhoperson);	
	}

}
