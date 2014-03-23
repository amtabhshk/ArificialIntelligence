package dev.ai.nuron.transporter;

import dev.ai.brocasarea.Speak;

public class SpeachTransporter {

	/**
	 * @param args
	 */
	 static Speak speak; 
  public void transportspeachTobrocasArea(String sentences){
		speak=new Speak();
		speak.Speak(sentences);
		
		
	}

}
