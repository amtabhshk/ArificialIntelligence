package dev.ai.brain.rudimentary;

import dev.ai.brain.decision.DiscisionForFind;
import dev.ai.brain.decision.DiscisionForSlangs;
import dev.ai.brain.decision.DiscisionForWhWord;


public class StringCheck {
	
	public String $_findWithinString(String $_original_invoice) throws Exception{
		
		String whWord="";
		
		if($_original_invoice.contains("Sample Usage") || $_original_invoice.contains("sample usage") || $_original_invoice.contains("Sample usage")){
			return "Just Say or Type--"+"\n"+
					"what is current temerature"+"\n"+
				   "what is the weather of Kolkata"+"\n"+
					"what is my current location"+"\n"+
					"who is Putin"+"\n"+
					"show/find/get the map of Bhubaneswar";
		}
		
		else if(($_original_invoice.contains("find")) || ($_original_invoice.contains("show")) || ($_original_invoice.contains("get"))){
		
				return new DiscisionForFind().findFindWhat($_original_invoice);
			}
		else if($_original_invoice.contains("zoom")){
	   
	   			return "zoom";
			}
		else if($_original_invoice.contains(whWord=new WhWordChecker().WhWordChecker($_original_invoice))){
	
				return new DiscisionForWhWord().redirectAccordingToWhWords(whWord, $_original_invoice);
			}
		else if(($_original_invoice.contains("fuck")) || ($_original_invoice.contains("bitch")) || ($_original_invoice.contains("asshole")) || ($_original_invoice.contains("penis")) || ($_original_invoice.contains("vagina")) || ($_original_invoice.contains("boob"))){
		
				return new DiscisionForSlangs().slangsDisciscision();
			}
		else{
			return "Sorry,I couldn't understand ,Can you please rephrase your words";
		}
	}
	


}
