package dev.ai.io;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import dev.ai.interfaces.WallInterfaceAbstract;
import dev.ai.nuron.transporter.SpeachTransporter;
import dev.ai.opticallobe.$_AiFace;

public class Boot {

	/**@author Bapu
	 * @param args
	 */
	
	SpeachTransporter transporter;
	String startUpSpeach="Hi I am ZZargon , I am your Virtual Assistant . You can ask any" +
						 "\n thing ! If you have any trouble ask my creator on +918237377158 ."+
						 "\n Just say or type \"Sample Usage\" to see how to use.";
	
	
	Thread startmain=new Thread(new Runnable() {
		@Override
		public void run() {
			startUi.start();
			new startStartUpSpeach() .speachSysnthesizer(startUpSpeach);	
			
		}
	});
	
	Thread startUi=new Thread(new Runnable() {
		@Override
		public void run() {		
			new $_AiFace();	
			$_AiFace.textArea1.setText("@ AI : "+startUpSpeach);
			$_AiFace.mainpanel.repaint();
		}
	});
	
	Boot(){
		startmain.start();
	}
	
	class startStartUpSpeach extends WallInterfaceAbstract{
		
		@Override
		public String speachSysnthesizer(String speach) {
			transporter= new SpeachTransporter();
			transporter.transportspeachTobrocasArea(startUpSpeach);
			return null;
		}
		
	}
	
	public static void main(String[] args) {
		/*GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
        for(String font:e.getAvailableFontFamilyNames()) {
            System.out.println(font);
        }*/
		File file=new File("C:\\Users\\Public\\AI.temp");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			DataOutputStream dos=new DataOutputStream(fos);
			for(int i=0;i<200;i++){
				dos.writeBytes("000000000010 \n");
				dos.writeBytes("1111100 \n");
				dos.writeBytes("101010101 \n");
				dos.writeBytes("010101010010100 \n");
				dos.writeBytes("0101010100101000000000000 \n");
				dos.writeBytes("11111111111111111111111111 \n");
			}
			
		} catch (FileNotFoundException e) {
		} catch (IOException e) {	
		}
		
		new Boot();
		
	}

}
