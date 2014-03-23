package dev.ai.io;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dev.ai.HostInfo;
import dev.ai.brain.rudimentary.StringCalculations;
import dev.ai.brain.rudimentary.StringCheck;
import dev.ai.interfaces.WallInterface;
import dev.ai.nuron.transporter.SpeachTransporter;
import dev.ai.opticallobe.$_AiFace;
import dev.ai.stt.AudioStreamCreater;
import dev.ai.stt.FlacConverter;
import dev.ai.stt.SpeachToText;

public class Communicator implements WallInterface,ActionListener {
	
	private static String $_original_invoice=null;
	private String getDiscisionResult=null;
	private static SpeachTransporter transporter;
	private static $_AiFace $_aiFace;
	
	public Communicator($_AiFace $_AiFace) {
		$_aiFace=$_AiFace;
	}

	@Override
	public void actionPerformed(ActionEvent $_actionEvent){
		String $_ActionEvent=$_actionEvent.getActionCommand();
		if($_ActionEvent.equals(">>"))
		{
			reset();
			String original_voice=$_AiFace.textArea5write.getText();
			listener(original_voice);
		}
		else if($_ActionEvent.equals("."))
		{
			reset();
			$_AiFace.Listen.setEnabled(false);
			$_AiFace.Stop.setEnabled(true);
			new AudioStreamCreater();
			$_AiFace.textArea7ListenInfo.setText("Listening...");
		}
		else if($_ActionEvent.equals("_"))
		{
			$_AiFace.Listen.setEnabled(true);
			$_AiFace.Stop.setEnabled(false);
			AudioStreamCreater.targetDataLine.stop();
			AudioStreamCreater.targetDataLine.close();
			$_AiFace.textArea7ListenInfo.setText("Listening stopped.(Processing data)...");
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					new FlacConverter();
					try {
						String original_voice=new SpeachToText().SpeachToText(System.getProperty(HostInfo.OS_TEMP_PATH_LOC)+""+"\\audio.flac");
						String hypothesis_original_voice=new StringCalculations().speachHypothesis(original_voice)[0];
						listener(hypothesis_original_voice);
					} catch (Exception e) {
						e.printStackTrace();
					}	
				}
			}).start();
			
		}
	}
	
	@Override
	public String executor() {
		try {
			getDiscisionResult=new StringCheck().$_findWithinString($_original_invoice);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getDiscisionResult;
	}

	@Override
	public String speachSysnthesizer(String speach) {
		transporter= new SpeachTransporter();
		transporter.transportspeachTobrocasArea(speach);
		return null;
	}

	class exec extends Thread {
		
		exec(){
			run();
		}
		@Override
		public void run() {
			String speach=executor();
			$_AiFace.textArea6DisplayInfo.setText(new StringCalculations().format(speach,11));
			$_AiFace.mainpanel.repaint();
			speachSysnthesizer(speach);
			
		}
	}
	
	public String listener(String original_voice) {
		$_original_invoice=original_voice;
		$_AiFace.textArea5write.setText(null);
		$_AiFace.textArea6DisplayInfo.setText(null);
		//try{
		//$_AiFace.mainpanel.remove($_AiFace.jfxPanel);
		//}catch(Exception e){e.printStackTrace();}
		$_AiFace.textArea4.setText($_AiFace.textArea3.getText());
		$_AiFace.textArea3.setText($_AiFace.textArea2.getText());
		$_AiFace.textArea2.setText($_AiFace.textArea1.getText());
		$_AiFace.textArea1.setText("@ Me : "+$_original_invoice);
		$_AiFace.mainpanel.repaint();


			new Thread(new Runnable() {
				
				@Override
				public void run() {
					new exec();
					
				}
			}).start();
			
		return null;
	}
	
	public static void reset(){
		$_AiFace.TA1.setText(null);
		$_AiFace.TA2.setText(null);
		$_AiFace.TA3.setText(null);
		$_AiFace.TA4.setText(null);
		$_AiFace.TA5.setText(null);
		$_AiFace.TA6.setText(null);
		$_AiFace.TA7.setText(null);
		$_AiFace.textArea7ListenInfo.setText("Press above icon to Speak...(or you can type)");
		$_AiFace.textArea6DisplayInfo.setText(null);
	}

	@Override
	public String listener() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
