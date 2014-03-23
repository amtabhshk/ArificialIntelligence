package dev.ai.brain.rudimentary;

public class WhWordChecker {
	
	private static final String[] Wh=new String[]{"when","who","where","how","what"};
	private String whichWh="";
	
	public String WhWordChecker(String $_original_invoice){
		for(int i=0;i<5;i++){
		if($_original_invoice.contains(Wh[i])) {
			whichWh=Wh[i];
			i++;
			break;
		}
		else{
			whichWh="no wh word";
		}
	 }
		return whichWh;
  }
	
}
