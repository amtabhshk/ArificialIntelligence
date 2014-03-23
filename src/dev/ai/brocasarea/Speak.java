package dev.ai.brocasarea;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Speak {

	/**
	 * @author Bapu
	 * @param args
	 */
	private static final String voiceof="kevin16";
	public void Speak(String sentences) {
		VoiceManager manager=VoiceManager.getInstance();
		Voice voice=manager.getVoice(voiceof);
		voice.allocate();
		try{
		voice.speak(sentences);
		}catch(Exception e){System.out.println(e);}

	}
	
}
