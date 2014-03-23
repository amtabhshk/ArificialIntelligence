package dev.ai.brain.decision;

import dev.ai.brain.rudimentary.StringCalculations;

/**
 * @author Bapu
 *
 */
public class DiscisionForFind {
	
	public String findFindWhat(String $_original_invoice) throws Exception {
		
		if($_original_invoice.contains("map")){
			
			return new DiscisionForMap().findOrShowMapof($_original_invoice);
			
		}
		else if($_original_invoice.contains("hotel")){
			
			return findHotel($_original_invoice);			
		}
		else if($_original_invoice.contains("location")){
			
			return new DiscisionForMap().findOrShowMapof($_original_invoice);
			
		}
		else if($_original_invoice.contains("weather")){
			
			return findWeather($_original_invoice,"weather");
		}
		else if($_original_invoice.contains("temperature")){
			
			return findWeather($_original_invoice,"temperature");			
		}
		else if($_original_invoice.contains("distance")){
			
			return findDistance($_original_invoice);
		}	
		else{
			
		return "Sorry,Try again";
		}
	}
	public String findHotel(String $_original_invoice) {
		
		String hotelIn="";
		StringCalculations calculations=new StringCalculations();
		if($_original_invoice.contains(" in ")){
			hotelIn=calculations.findWordAfter($_original_invoice, "in", 1);
			return "finding hotel in: "+hotelIn;//find weather in "word after of" location
		}
		else if($_original_invoice.contains(" of ")){
			hotelIn=calculations.findWordAfter($_original_invoice, "of", 1);
			return "finding hotel in: "+hotelIn;//find weather in "word after of" location
		}
		else{
			return "finding hotels in your current location";
			//get current location
			//show hotels in current location
		}		
	}
	public String findWeather(String $_original_invoice,String weatherOrTemperature) {
		String weatherOrTempOf="";
		StringCalculations calculations=new StringCalculations();
		  if(weatherOrTemperature.equals("weather")){
		    if($_original_invoice.contains("of")){
		    	weatherOrTempOf=calculations.findWordAfter($_original_invoice, "of", 1);
			  return "finding weather of: "+weatherOrTempOf;//find weather in "word after of" location
		     }
		
		   else{
			 return "finding weather of current location";
			//get current location
			//show weather in current location
		     }	
		 }else{
			 weatherOrTempOf=calculations.findWordAfter($_original_invoice, "of", 1);
			 return "finding the temperature  of: "+weatherOrTempOf;
		 }
	}
	public String findDistance(String $_original_invoice) {
		String from="",to="";
		StringCalculations calculations=new StringCalculations();
		if($_original_invoice.contains("from")){
			from=calculations.findWordAfter($_original_invoice,"from", 1);
			 if($_original_invoice.contains("to")){
				to=calculations.findWordAfter($_original_invoice,"to", 1);
				return "distance from:"+from +"to:"+to ;
				//now do operation on to and from
			}
			else{
				return "found distance from :"+from+" ,but I couldn't recognise \"TO\" where you want a distance ";
			}
		
		}
		else{
			return "I didn't recognise from whre you want to find the distance";
		}		
	}	
	

}
