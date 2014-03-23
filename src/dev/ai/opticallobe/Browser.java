package dev.ai.opticallobe;

import java.util.Set;

import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class Browser extends Thread {
	
	public Browser(JFXPanel fxPanel,String places){
		initFX(fxPanel,places);
	}
	
	 void initFX(final JFXPanel fxPanel,String places) {
	        Group group = new Group();
	        Scene scene = new Scene(group);
	        fxPanel.setScene(scene);
	      

	        final WebView webView = new WebView();

	        group.getChildren().add(webView);
	        //webView.setMinSize(600, 300);
	        //webView.setMaxSize(600, 300);
	        
	        WebEngine webEngine = webView.getEngine();
	        webEngine.load("http://maps.googleapis.com/maps/api/staticmap?center="+places+"&zoom=14&size=510x300&scale=1&maptype=roadmap&markers=color:red|label:S|"+places+"&sensor=false");
	        //webEngine.load("https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRysCMG8olZEnEa938Q1ARou5qDGsBQcTNPYjFl7InWXRg9fmFm");
	        //removing the scrolles//
	        webView.getChildrenUnmodifiable().addListener(new ListChangeListener<Node>() {
	            @Override public void onChanged(Change<? extends Node> change) {
	              Set<Node> deadSeaScrolls = webView.lookupAll(".scroll-bar");
	              for (Node scroll : deadSeaScrolls) {
	                scroll.setVisible(false);
	              }
	            }
	          });
	        
	    }

}
