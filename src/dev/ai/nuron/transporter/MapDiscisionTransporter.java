package dev.ai.nuron.transporter;

import javafx.application.Platform;
import dev.ai.opticallobe.$_AiFace;
import dev.ai.opticallobe.Browser;

public class MapDiscisionTransporter {
	
	
	public void createMapforPlaces(final String places) throws Exception{
		System.out.println("places="+places);
		 Platform.runLater(new Runnable() { 
	         @Override
	         public void run() {
	        	
	        	$_AiFace.mainpanel.add($_AiFace.jfxPanel).setBounds(720, 120, 510, 300);
	            $_AiFace.mainpanel.repaint();
	            new Browser($_AiFace.jfxPanel,places);
	            $_AiFace.jfxPanel.repaint();
	        	 
	         }
	     });
		
	}

}
