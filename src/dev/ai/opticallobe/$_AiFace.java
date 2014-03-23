package dev.ai.opticallobe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.embed.swing.JFXPanel;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextArea;

import dev.ai.HostInfo;
import dev.ai.ResourceAllocator;
import dev.ai.io.Communicator;

/**
 * @author Bapu
 *
 */
public class $_AiFace {
	JFrame frame;
	BufferedReader bufferedReader;
	FileReader fileReader;
	String sentence;
	public static JFXPanel jfxPanel;
	public static JButton go;
	public static JButton Listen;
	public static JButton Stop;
	//textarea for conversation
	public static JTextArea textArea1;
	public static JTextArea textArea2;
	public static JTextArea textArea3;
	public static JTextArea textArea4;
	//textarea for write
	public static JTextArea textArea5write;
	//textarea for information diplay //example: what is apple
	public static JTextArea textArea6DisplayInfo;
	//testarea for listen info
	public static JTextArea textArea7ListenInfo;
	//textarea for progress info
	public static JTextArea TA1;
	public static JTextArea TA2;
	public static JTextArea TA3;
	public static JTextArea TA4;
	public static JTextArea TA5;
	public static JTextArea TA6;
	public static JTextArea TA7;
	
	
	@SuppressWarnings("serial")
	public static JPanel mainpanel=new JPanel(){
	
		public void paintComponent(Graphics g)  {
     	   super.paintComponent(g); 
     	  
     	   Graphics2D line = (Graphics2D) g;
     	  line.setColor(Color.GRAY);
     	   
     	   Rectangle2D rectangleboarder= new Rectangle2D.Float(3,3, 1250, 700);
     	  line.draw(rectangleboarder);

     	   Line2D sysinfo$ = new Line2D.Float(10, 100, 1240, 100);     	   
     	  line.draw(sysinfo$);
     	   
     	   Line2D separatorleft$right1st = new Line2D.Float(400, 110, 400, 690);     	   
     	  line.draw(separatorleft$right1st);
     	  
     	 Line2D separatorleft$right2nd = new Line2D.Float(700, 110, 700, 690);     	   
    	  line.draw(separatorleft$right2nd);
    	   
    	   Line2D separatorup$down = new Line2D.Float(10, 470, 390, 470);     	   
    	  line.draw(separatorup$down);
    	   
    	   Graphics2D string = (Graphics2D) g;
    	  string.setColor(Color.CYAN);
    	  
    	   
    	  string.drawString("User :: "+System.getProperty(HostInfo.OS_USER_NAME), 20, 20);
    	  string.drawString("Architechtire :: "+System.getProperty(HostInfo.OS_ARCHITECHTURE), 20, 40);
    	  string.drawString("Operating System :: "+System.getProperty(HostInfo.OS_NAME), 20, 60);
    	  string.drawString("CPU ::  "+System.getProperty(HostInfo.OS_CPU_TYPE), 20, 80);
    	  string.drawString("Country ::	 "+System.getProperty(HostInfo.OS_USER_COUNTRY),500, 20);
    	  string.drawString("Java Version ::	 "+System.getProperty(HostInfo.OS_JAVA_VERSION),500, 40);
    	  
    	  Graphics2D string2 = (Graphics2D) g;
    	  string2.setColor(Color.BLUE);
    	  Font font=new Font("Britannic Bold", Font.BOLD, 15);
    	  string2.setFont(font);
    	  string2.drawString("Conversations", 140, 120);
    	  
    	  Graphics2D image = (Graphics2D) g;
    	  Image icon = null;
     	  
			try {
				 icon = ImageIO.read(ResourceAllocator.getFile("resource/image/index.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}  
			
				image.drawImage(icon, 1200, 5, -icon.getWidth(mainpanel), icon.getHeight(mainpanel), mainpanel);			
				//image.drawImage(icon, 1100, 5, panel);
	
		}
	};
	
	@SuppressWarnings("serial")
	JPanel picturechangepanel=new JPanel(){
		    
		public void paintComponent(Graphics g)  {
     	   super.paintComponent(g); 
     	  
     	 
    	  Graphics2D image = (Graphics2D) g;
    	  Image icon = null;
     	  
			try {
				 icon = ImageIO.read(ResourceAllocator.getFile("resource/image/index.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}  
			
				image.drawImage(icon, 0, 5, icon.getWidth(picturechangepanel), icon.getHeight(picturechangepanel), picturechangepanel);			
			//image.drawImage(icon, 100, 5, -icon.getWidth(picturechangepanel), icon.getHeight(panel2), picturechangepanel);
	
		}
	};
	
	@SuppressWarnings("serial")
	JPanel displaycodepanel=new JPanel(){
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			
			 Graphics2D string = (Graphics2D) g;
	    	  string.setColor(Color.CYAN);
	    	  
	    	  try {
	    		 String s1=bufferedReader.readLine();
	    		 String s2=bufferedReader.readLine();
	    		 String s3=bufferedReader.readLine();
	    		 String s4=bufferedReader.readLine();
	    		 String s5=bufferedReader.readLine();
	    		 String s6=bufferedReader.readLine();
	    		 String s7=bufferedReader.readLine();
	    		 String s8=bufferedReader.readLine();
	    		 String s9=bufferedReader.readLine();
	    		 String s10=bufferedReader.readLine();
	    		  s1=s2;
	    		  s2=s3;
	    		  s3=s4;
	    		  s4=s5;
	    		  s5=s6;
	    		  s6=s7;
	    		  s7=s8;
	    		  s8=s9;
	    		  s9=s10;
	    		  s10=bufferedReader.readLine();
	    	string.drawString("Back Ground Processing.class...", 10, 15);	
	    	string.drawString("---------------------------------------", 10, 25);	
			string.drawString(s1, 10, 45);					string.drawString(s6, 10, 175);		
			string.drawString(s2, 10, 65);					string.drawString(s7, 10, 205);		
			string.drawString(s3, 10, 95);					string.drawString(s8, 10, 235);		
			string.drawString(s4, 10, 125);					string.drawString(s9, 10, 265);		
			string.drawString(s5, 10, 145);					string.drawString(s10, 10, 295);		
			
			} catch (IOException e){
				e.printStackTrace();
			}
	    	  catch (NullPointerException e){
	    		  try {
	  				readSentence();
	  			} catch (IOException rs) {
	  				e.printStackTrace();
	  			}
				}
		}
	};
	
	Thread threadrotateimage=new Thread(new Runnable() {
		
		@Override
		public void run() {
			rotateImage();
			
		}
	});
	
	Thread threaddisplaycode=new Thread(new Runnable() {
		
		@SuppressWarnings("static-access")
		@Override
		public void run() {
			try {
				readSentence();
			} catch (IOException e) {
				e.printStackTrace();
			}
			 
			for(;;){
    	        try {
    	        	threaddisplaycode.sleep(100);
    			} catch (InterruptedException e) {
    				e.printStackTrace();
    			}
    	        //frame.repaint();
    	        mainpanel.repaint();
    	        mainpanel.add(displaycodepanel).setBounds(405, 115, 290,350);
    	        try {
    	        	threaddisplaycode.sleep(100);
    			} catch (InterruptedException e) {
    				e.printStackTrace();
    			}
    	      //  frame.repaint();
    	        mainpanel.repaint();
    	        mainpanel.remove(displaycodepanel);
    	     
    	        }
			
		}
	});
	
/*	Thread threadbrowsercumdisplay=new Thread(new Runnable() {
		
		@Override
		public void run() {
			
			
		}
	});*/
	
    public $_AiFace(){
    	
    	threadrotateimage.start();
    	threaddisplaycode.start();
    	
    	frame=new JFrame();
    	frame.setTitle("Artificial Intelligence Pro");
    	frame.getContentPane().setLayout(null);
        frame.setSize(1270,740);
        frame.setLocation(5, 5);
      
        go=new JButton(">>");
        go.addActionListener(new Communicator(this));
        
        Listen=new JButton(".");
        Listen.addActionListener(new Communicator(this));
        try {
			Image icon = ImageIO.read(ResourceAllocator.getFile("resource/image/microphone-icon.jpg"));
			Listen.setIcon(new ImageIcon(icon));
		} catch (IOException e) {
			e.printStackTrace();
		}  
        
        Stop=new JButton("_");
        Stop.addActionListener(new Communicator(this));
        Stop.setEnabled(false);
        try {
			Image icon = ImageIO.read(ResourceAllocator.getFile("resource/image/micoff.png"));
			Stop.setIcon(new ImageIcon(icon));
		} catch (IOException e) {
			e.printStackTrace();
		}  
        
        textArea1=new JTextArea(370,70);
        textArea1.setEditable(false);
        textArea2=new JTextArea(370,70);
        textArea2.setEditable(false);
        textArea3=new JTextArea(370,70);
        textArea3.setEditable(false);
        textArea4=new JTextArea(330,70);
        textArea4.setEditable(false);
        textArea5write=new JTextArea(370,70);
        textArea6DisplayInfo=new JTextArea(525,240);
        textArea6DisplayInfo.setEditable(false);
        textArea7ListenInfo=new JTextArea(330,25);
        textArea7ListenInfo.setEditable(false);
        TA1=new JTextArea(270,25);
        TA1.setEditable(false);
        TA2=new JTextArea(270,25);
        TA2.setEditable(false);
        TA3=new JTextArea(270,25);
        TA3.setEditable(false);
        TA4=new JTextArea(270,25);
        TA4.setEditable(false);
        TA5=new JTextArea(270,25);
        TA5.setEditable(false);
        TA6=new JTextArea(270,25);
        TA6.setEditable(false);
        TA7=new JTextArea(270,25);
        TA7.setEditable(false);
        textArea1.setBackground(Color.BLACK);
        textArea1.setForeground(Color.CYAN);
        textArea2.setBackground(Color.BLACK);
        textArea2.setForeground(Color.CYAN);
        textArea3.setBackground(Color.BLACK);
        textArea3.setForeground(Color.CYAN);
        textArea4.setBackground(Color.BLACK);
        textArea4.setForeground(Color.CYAN);
        textArea5write.setBackground(Color.DARK_GRAY);
        textArea5write.setForeground(Color.WHITE);
        textArea6DisplayInfo.setBackground(Color.BLACK);
        textArea6DisplayInfo.setForeground(Color.WHITE);
        textArea7ListenInfo.setBackground(Color.BLACK);
        textArea7ListenInfo.setForeground(Color.YELLOW);
        TA1.setBackground(Color.BLACK);
        TA1.setForeground(Color.YELLOW);
        TA2.setBackground(Color.BLACK);
        TA2.setForeground(Color.YELLOW);
        TA3.setBackground(Color.BLACK);
        TA3.setForeground(Color.YELLOW);
        TA4.setBackground(Color.BLACK);
        TA4.setForeground(Color.CYAN);
        TA5.setBackground(Color.BLACK);
        TA5.setForeground(Color.CYAN);
        TA6.setBackground(Color.BLACK);
        TA6.setForeground(Color.YELLOW);
        TA7.setBackground(Color.BLACK);
        TA7.setForeground(Color.YELLOW);
      
        
        Font font1=new Font("Calibri", Font.CENTER_BASELINE, 13);
        Font font2=new Font("Calibri", Font.CENTER_BASELINE, 15);
        textArea5write.setFont(font1);
        
        textArea6DisplayInfo.setForeground(Color.WHITE);
        textArea6DisplayInfo.setFont(font2);
      
        mainpanel.add(textArea1).setBounds(10, 390, 370, 70);
        mainpanel.add(textArea2).setBounds(10, 310, 370, 70);
        mainpanel.add(textArea3).setBounds(10, 230, 370, 70);
        mainpanel.add(textArea4).setBounds(10, 150, 370, 70);
        mainpanel.add(textArea5write).setBounds(10, 500, 330, 70);
        mainpanel.add(textArea6DisplayInfo).setBounds(720, 450, 525, 240);
        mainpanel.add(textArea7ListenInfo).setBounds(15,670, 330,25);
        Font font3=new Font("Agency FB", Font.BOLD, 15);
        textArea7ListenInfo.setFont(font3);
        textArea7ListenInfo.setText("Press above icon to Speak...(or you can type)");
       
        
        mainpanel.add(go).setBounds(343,515,55, 35);
        mainpanel.add(Listen).setBounds(95, 610,70, 35);
        mainpanel.add(Stop).setBounds(175, 610,70, 35);
       // button.setBorderPainted(new RoundRectangle2D(10, 20, 20, 20, 20, 20)));
        
        mainpanel.add(TA1).setBounds(410, 480, 280, 25);
        mainpanel.add(TA2).setBounds(410, 510, 280, 25);
        mainpanel.add(TA3).setBounds(410, 540, 280, 25);
        mainpanel.add(TA4).setBounds(410, 570, 280, 25);
        mainpanel.add(TA5).setBounds(410, 600, 280, 25);
        mainpanel.add(TA6).setBounds(410, 630, 280, 25);
        mainpanel.add(TA7).setBounds(410, 660, 280, 25);
        Font font4=new Font("Agency FB", Font.ITALIC, 15);
        TA1.setFont(font4);
        TA2.setFont(font4);
        TA3.setFont(font4);
        TA4.setFont(font4);
        TA5.setFont(font4);
        TA6.setFont(font4);
        TA7.setFont(font4);
        
       
        
        mainpanel.setBackground(Color.black);
        mainpanel.setLayout(null); 
        
        picturechangepanel.setBackground(Color.black);
        picturechangepanel.setLayout(null); 
       
        displaycodepanel.setBackground(Color.black);
        displaycodepanel.setLayout(null); 
        
        jfxPanel=new JFXPanel();
        jfxPanel.setBackground(Color.black);
       // jfxPanel.setLayout(null); 
        
      /*  threadbrowsercumdisplay.start();*/
       
       // mainpanel.add(jfxPanel).setBounds(720, 120, 510, 300);
       
        frame.setUndecorated(true);
        frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        frame.getContentPane().setBackground(Color.red);
        frame.setResizable(false);
        frame.setOpacity(0.9f);
        frame.setVisible(true);
       
        frame.add(mainpanel).setBounds(1, 1,1269,739);
        
       
       
    }
    
    @SuppressWarnings("static-access")
	void rotateImage(){
    	 for(;;){
    	        try {
    	        	threadrotateimage.sleep(1000);
    			} catch (InterruptedException e) {
    				e.printStackTrace();
    			}
    	        //frame.repaint();
    	        mainpanel.repaint();
    	        mainpanel.add(picturechangepanel).setBounds(1100, 5,100,90);
    	        try {
    	        	threadrotateimage.sleep(1000);
    			} catch (InterruptedException e) {
    				e.printStackTrace();
    			}
    	      //  frame.repaint();
    	        mainpanel.repaint();
    	        mainpanel.remove(picturechangepanel);
    	     
    	        }
    	       
    }
    
    void readSentence() throws IOException{
    	//String s=(""+ResourceAllocator.getFile("opticallobe/$_AiFace.class")).substring(6, (""+ResourceAllocator.getFile("opticallobe/$_AiFace.class")).length());
    	//System.out.println("s:"+s);
    	String s="C:/Users/Public/AI.temp";
    	fileReader=new FileReader(s);
    	bufferedReader=new BufferedReader(fileReader);	
    	
    }
    
   
    
 
}