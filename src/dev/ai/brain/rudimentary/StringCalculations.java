package dev.ai.brain.rudimentary;

import dev.ai.opticallobe.$_AiFace;

public class StringCalculations {
	
public  String findWordAfter(String originalString, String word,int numberOfWordafter) {
		
		originalString=originalString.replaceAll("  ", " ");
		String[] arrayWord=originalString.split(" ");
		String string="";
	try{
		for(int i=0;i<arrayWord.length;i++){
		    if(arrayWord[i].equals(word)){
		    	string= arrayWord[i+numberOfWordafter];
		    }
		}
	}catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
		string= "no word after : "+word;	
	}
	return string;
		
	}

public String findUptoLastWord(String originalString, String fromword) {
	
		originalString=originalString.replaceAll("  ", " ");
		String[] arrayWord=originalString.split(" ");
		String string="";
		int i=0;
		try{
			for(int j=0;j<arrayWord.length;j++){
				if(arrayWord[j].equals(fromword)){
					i=j;
				}
			}
			for(int k=i;k<arrayWord.length;k++){
				if(k+1>=arrayWord.length){break;}
				else{string+=arrayWord[k+1]+" ";}
				
			}
		}catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
			string= "arrayIndexOutOfBoundsException error in StringCalculation.java ";	
		}
		return string;
	}


public String format(String speach, int numberOfWordInaSinglerow) {
	
	String tempFormatedSpeach[]=speach.split(" ");
	
	String FormatedSpeach="";
	int i=0;
	int numberOfwords=tempFormatedSpeach.length;
	
		for(int j=0;j<numberOfwords;j++){
				
				FormatedSpeach+=tempFormatedSpeach[j]+" ";
				
				++i;
				
				if(i==(numberOfWordInaSinglerow)){
					
					FormatedSpeach+="\n";
					i=0;
					
				}
			
		}
		return FormatedSpeach;
	}

 public String[] speachHypothesis(String googleReturnedHypothesis){
	 
	 String actuallHypothesis[]=new String[2];
	 System.out.println("actuallHypothesis:"+googleReturnedHypothesis);
	 int confidenceIndex=googleReturnedHypothesis.indexOf("confidence");
	 int utteranceIndex=googleReturnedHypothesis.indexOf("utterance");
	 System.out.println("ui:"+utteranceIndex);
	 System.out.println("ci:"+confidenceIndex);
	 actuallHypothesis[0]=googleReturnedHypothesis.substring(utteranceIndex+12,confidenceIndex-3);
	 actuallHypothesis[1]=googleReturnedHypothesis.substring(confidenceIndex+12,confidenceIndex+21);
	 System.out.println("sp:"+actuallHypothesis[0]);
	 $_AiFace.TA3.setText("Hypothesis... "+actuallHypothesis[0]);
	 System.out.println("con:"+actuallHypothesis[1]);
	 $_AiFace.TA4.setText("Confidence... "+actuallHypothesis[1]);
	return actuallHypothesis;
	 
 }

public String formatResultAccordingToWeatherLocation(String output, boolean weather, String ownloaction) {
 
	String weatherReportOrLocation=null;
	if(weather==false && ownloaction==null){
		weatherReportOrLocation=output.substring(0, output.indexOf("maps.google.co.in"));
		System.out.println("Location:"+weatherReportOrLocation);
	}
	if(weather==true && (ownloaction==null || ownloaction!=null)){
		String temp,humidity,windspeed;
		System.out.println(output);
		try{
		/*System.out.println("OUT:"+output.substring(0,100));
		System.out.println("0."+output.indexOf("|"));
		System.out.println("1."+output.indexOf("Wind")+4);
		System.out.println("2."+output.indexOf("Humidity"));
		System.out.println("3."+output.indexOf("Humidity")+9);
		System.out.println("4."+output.indexOf("Humidity")+15);*/
		
		temp=output.substring(0, output.indexOf("|"));
		windspeed=output.substring(output.indexOf("Wind")+4,output.indexOf("Humidity"));
		humidity=output.substring(output.indexOf("Humidity")+9,output.indexOf("Humidity")+14);
		weatherReportOrLocation=temp+",\n Wind Speed "+windspeed+",\n Humidity "+humidity;
		}catch(StringIndexOutOfBoundsException e){
			
			String forcastedString=output.substring(output.indexOf("Wed")+3, output.indexOf("Detailed"));
			String tempforcasted[]=forcastedString.split(" ");
			String ToDay="ToDay Max Tempaerature "+tempforcasted[1]+" Min Temparature "+tempforcasted[2];
			String Tomorrow="Tomorrow Max Tempaerature "+tempforcasted[3]+" Min Temparature "+tempforcasted[4];
			String DayAfterTomorrow="DayAfterTomorrow Max Tempaerature "+tempforcasted[5]+" Min Temparature "+tempforcasted[6];
			String TwoDaysAfter="TwoDaysAfter Max Tempaerature "+tempforcasted[7]+" Min Temparature "+tempforcasted[8];
			weatherReportOrLocation=ToDay+"\n"+Tomorrow+"\n"+DayAfterTomorrow+"\n"+TwoDaysAfter;
		}
		
		System.out.println(weatherReportOrLocation);
		
	}
	
	
	return weatherReportOrLocation;
}
 
}
