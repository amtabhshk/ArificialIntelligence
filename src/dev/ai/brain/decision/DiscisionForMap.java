package dev.ai.brain.decision;

import dev.ai.brain.rudimentary.StringCalculations;
import dev.ai.nuron.transporter.MapDiscisionTransporter;

/**
 * @author Bapu
 *
 */
public class DiscisionForMap {
	
	public String findOrShowMapof(String $_original_invoice) throws Exception{
		String mapof="",afterbetween="",afterand="";
		StringCalculations calculations=new StringCalculations();
		if($_original_invoice.contains("of")){
			mapof=calculations.findWordAfter($_original_invoice, "of", 1);
			new MapDiscisionTransporter().createMapforPlaces(mapof);
		   return "showing the map of: "+mapof;//word after of i.e show map
		}
		else if($_original_invoice.contains("between")){
			afterbetween=calculations.findWordAfter($_original_invoice, "between", 1);
			if($_original_invoice.contains("and")){
			afterand=calculations.findWordAfter($_original_invoice, "and", 1);
			return "displaying path between : "+afterbetween+" and : "+afterand;//word after between and word after ater between i.e show map
			}
			else{
				return "please properly speak between ?(where) and ?(where) you want the path ";
			}
			
		}
		else{
			return "couldn't get the map of the your loaction +location name";
		}
		
	}

}
