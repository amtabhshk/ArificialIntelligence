package dev.ai.brain.decision;

import java.util.Random;

public class DiscisionForSlangs {
    static Random rnd = new Random();
	
	public String slangsDisciscision(){
		
		int i=rnd.nextInt(10);
		String abuse="";
		switch (i) {
		case 1:
			abuse= "don't abuse me";
			break;
		case 2:
			abuse= "you asshole,I knew it,you will say this to me";
			break;
		case 3:
			abuse= "you motherfucker";
			break;
		case 4:
			abuse= "This is a very discent application,so please...";
			break;
		case 5:
			abuse= "I'll cut your penis,and put it in your mouth";
			break;
		case 6:
			abuse= "you bitch";
			break;
		case 7:
			abuse= "did you learnt it from your home,asshole..";
			break;
		case 8:
			abuse= "ok...you pussy..enough";
			break;
		case 9:
			abuse= "who tought you this kind of vulgar words...:)";
			break;
		case 10:
			abuse= "your boobs are nice...you motherfucker";
			break;

		default:
			break;
			
		
		}
		return abuse;
		
	}

}
