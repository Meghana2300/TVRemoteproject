import static java.awt.Font.BOLD;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.lang.Math;

//import sun.audio.*;
import java.awt.*;
//import haswanth.tril6;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.BadLocationException;

import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;    
public  class TvRemote extends JPanel implements Runnable
{
	
	Thread thread = null;  
	 SimpleDateFormat formatter = new SimpleDateFormat("s", Locale.getDefault());  
	 Date currentDate;  
	 int xcenter = 175, ycenter = 175, lastxs = 0, lastys = 0, lastxm = 0, lastym = 0, lastxh = 0, lastyh = 0;  
	 private void drawStructure(Graphics g) {  
	  g.setFont(new Font("TimesRoman", Font.BOLD, 20));  
	  g.setColor(Color.black);  
	  g.fillOval(xcenter - 150, ycenter - 150, 300, 300);  
	  g.setColor(Color.blue);  
	  g.drawString("UR SP", 113, 300);  
	  g.setColor(Color.green);  
	  g.drawString("9", xcenter - 145, ycenter + 0);  
	  g.drawString("3", xcenter + 135, ycenter + 0);  
	  g.drawString("12", xcenter - 10, ycenter - 130);  
	  g.drawString("6", xcenter - 10, ycenter + 145);  
	 }  
	 public void paint(Graphics g)   
	 {  
				 
	  int xhour, yhour, xminute, yminute, xsecond, ysecond, second, minute, hour;  
	  drawStructure(g);  
	  currentDate = new Date();  
	  formatter.applyPattern("s");  
	  second = Integer.parseInt(formatter.format(currentDate));  
	  formatter.applyPattern("m");  
	  minute = Integer.parseInt(formatter.format(currentDate));  
	  formatter.applyPattern("h");  
	  hour = Integer.parseInt(formatter.format(currentDate));  
	  xsecond = (int)(Math.cos(second * 3.14f / 30 - 3.14f / 2) * 120 + xcenter);  
	  ysecond = (int)(Math.sin(second * 3.14f / 30 - 3.14f / 2) * 120 + ycenter);  
	  xminute = (int)(Math.cos(minute * 3.14f / 30 - 3.14f / 2) * 100 + xcenter);  
	  yminute = (int)(Math.sin(minute * 3.14f / 30 - 3.14f / 2) * 100 + ycenter);  
	  xhour = (int)(Math.cos((hour * 30 + minute / 2) * 3.14f / 180 - 3.14f / 2) * 80 + xcenter);  
	  yhour = (int)(Math.sin((hour * 30 + minute / 2) * 3.14f / 180 - 3.14f / 2) * 80 + ycenter);  
	  // Erase if necessary, and redraw    
	  g.setColor(Color.magenta);  
	  if (xsecond != lastxs || ysecond != lastys)   
	  {  
	   g.drawLine(xcenter, ycenter, lastxs, lastys);  
	  }  
	  if (xminute != lastxm || yminute != lastym)   
	  {  
	   g.drawLine(xcenter, ycenter - 1, lastxm, lastym);  
	   g.drawLine(xcenter - 1, ycenter, lastxm, lastym);  
	  }  
	  if (xhour != lastxh || yhour != lastyh)   
	  {  
	   g.drawLine(xcenter, ycenter - 1, lastxh, lastyh);  
	   g.drawLine(xcenter - 1, ycenter, lastxh, lastyh);  
	  }  
	  g.setColor(Color.magenta);  
	  g.drawLine(xcenter, ycenter, xsecond, ysecond);  
	  g.setColor(Color.red);  
	  g.drawLine(xcenter, ycenter - 1, xminute, yminute);  
	  g.drawLine(xcenter - 1, ycenter, xminute, yminute);  
	  g.setColor(Color.green);  
	  g.drawLine(xcenter, ycenter - 1, xhour, yhour);  
	  g.drawLine(xcenter - 1, ycenter, xhour, yhour);  
	  lastxs = xsecond;  
	  lastys = ysecond;  
	  lastxm = xminute;  
	  lastym = yminute;  
	  lastxh = xhour;  
	  lastyh = yhour;  
	 }  
	 public void start()   
	 {  
	  if (thread == null)   
	  {  
	   thread = new Thread(this);  
	   thread.start();  
	  }  
	 }  
	 public void stop()   
	 {  
	  thread = null;  
	 }  
	 public void run()   
	 {  
	  while (thread != null)   
	  {  
	   try   
	   {  
	    Thread.sleep(100);  
	   }   
	   catch (InterruptedException e) {}  
	   repaint();  
	  }  
	  thread = null;  
	 }  
	 public void update(Graphics g)   
	 {  
	  paint(g);  
	 }  

	static JTextArea txt=new JTextArea();
static JTextField field=new JTextField();
	public static void main(String[] args) {
		
		  TextField tf=new TextField();  
		   JFrame f1=new JFrame("Sp TV");
		 
		//f.setVisible(true);
		    f1.getContentPane().setBackground(Color.white);
		    f1.setSize(330,600);  
		    f1.getContentPane().setLayout(null);
			   f1.setVisible(true);
			   
			   
		           
		    JButton btnNewButton_2 = new JButton("1");
		    btnNewButton_2.setBounds(11, 52, 90, 30);
		    f1.getContentPane().add(btnNewButton_2);
		   btnNewButton_2.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	 try 
		 	            {
		 	            	String myurl="https://www.youtube.com/watch?v=VMAwgDJIsM0";
		 	            	java.awt.Desktop.getDesktop().browse(java.net.URI.create(myurl));
		 	            	
		 	            }
		 	            catch (Exception e2) 
		 	            {
		 	            	e2.printStackTrace();
		 	            }
		 	            	
		    	  	    btnNewButton_2.setVisible(true);   
		    	       
	            }}
		            );
	                 
	            	 JButton btnNewButton_3 = new JButton("2");
		    btnNewButton_3.setBounds(111, 52, 90, 30);
		    f1.getContentPane().add(btnNewButton_3); 
		    f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   btnNewButton_3.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	 JFrame ch2=new JFrame(); 
	            	  ImageIcon icon = new ImageIcon("C:\\Users\\megha\\Downloads\\has.jpg");
	            	  JLabel label = new JLabel(icon);
	            	 ch2.getContentPane().add(label);
	    	    	 ch2.setSize(400,400);
	    	    	 //ch2.pack();
	    	  	   ch2.getContentPane();
	    	  	    ch2.setVisible(true);   
	    	  	    
	    	       	}	});
		    
		    JButton btnNewButton_4 = new JButton("3");
		    btnNewButton_4.setBounds(210, 52, 90, 30);
		    f1.getContentPane().add(btnNewButton_4);
		    btnNewButton_4.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	 JFrame ch3=new JFrame();  
	            	 ImageIcon icon = new ImageIcon("C:\\Users\\megha\\Downloads\\af34136075a527bc2ebb09b13f701759.png");
	            	  JLabel label = new JLabel(icon);
	            	 ch3.getContentPane().add(label);
	    	    	 ch3.setSize(400,400);
	    	    	 //ch2.pack();
	    	  	   ch3.getContentPane();
	    	  	    ch3.setVisible(true);   
	    	  	
	    	       	}} );
		    
		    JButton btnNewButton_5 = new JButton("4");
		    btnNewButton_5.setBounds(11, 96, 90, 30);
		    f1.getContentPane().add(btnNewButton_5);
		    btnNewButton_5.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	 JFrame ch4=new JFrame();  
	            	 ImageIcon icon = new ImageIcon("C:\\Users\\megha\\Downloads\\images (1).jfif");
	            	  JLabel label = new JLabel(icon);
	            	 ch4.getContentPane().add(label);
	    	    	 ch4.setSize(400,400);
	    	    	 //ch2.pack();
	    	  	   ch4.getContentPane();
	    	  	    ch4.setVisible(true);   
	    	       	}}   );
		    
		    JButton btnNewButton_6 = new JButton("5");
		    btnNewButton_6.setBounds(111, 96, 90, 30);
		    f1.getContentPane().add(btnNewButton_6);
		    btnNewButton_6.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	 JFrame ch5=new JFrame();  
	            	 ImageIcon icon = new ImageIcon("C:\\Users\\megha\\Downloads\\FTV_FASHIONTV_1024_7681.jpg");
	            	  JLabel label = new JLabel(icon);
	            	 ch5.getContentPane().add(label);
	    	    	 ch5.setSize(400,400);
	    	    	 //ch2.pack();
	    	  	   ch5.getContentPane();
	    	  	    ch5.setVisible(true);   
	    	     }}  );
		   
		    JButton btnNewButton_7 = new JButton("6");
		    btnNewButton_7.setBounds(210, 96, 90, 30);
		    f1.getContentPane().add(btnNewButton_7);
		    btnNewButton_7.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		 JFrame ch6=new JFrame();  
		    		 ImageIcon icon = new ImageIcon("C:\\Users\\megha\\Downloads\\images (2).jfif");
	            	  JLabel label = new JLabel(icon);
	            	 ch6.getContentPane().add(label);
	    	    	 ch6.setSize(400,400);
	    	    	 //ch2.pack();
	    	  	   ch6.getContentPane();
	    	  	    ch6.setVisible(true);   
	    	       	} });
		   
		   JButton btnNewButton_8 = new JButton("7");
		    btnNewButton_8.setBounds(11, 139, 90, 30);
		    f1.getContentPane().add(btnNewButton_8);
		    btnNewButton_8.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		 JFrame ch7=new JFrame();  
		    		 ImageIcon icon = new ImageIcon("C:\\Users\\megha\\Downloads\\IMG_20190402_215604 (1).jpg");
	            	  JLabel label = new JLabel(icon);
	            	 ch7.getContentPane().add(label);
	    	    	 ch7.setSize(400,400);
	    	    	 //ch2.pack();
	    	  	   ch7.getContentPane();
	    	  	    ch7.setVisible(true);   
	    	       	}   });
		   
		    JButton btnNewButton_9 = new JButton("8");
		    btnNewButton_9.setBounds(111, 139, 90, 30);
		    f1.getContentPane().add(btnNewButton_9);
		    btnNewButton_9.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		 JFrame ch8=new JFrame();  
		    		 ImageIcon icon = new ImageIcon("C:\\Users\\megha\\Downloads\\2a7ed033ee24eeb1580d8554888c7c33 (1).jpg");
	            	  JLabel label = new JLabel(icon);
	            	 ch8.getContentPane().add(label);
	    	    	 ch8.setSize(400,400);
	    	    	 //ch2.pack();
	    	  	   ch8.getContentPane();
	    	  	    ch8.setVisible(true);   
	    	       	}  });
		    
		    JButton btnNewButton_10 = new JButton("9");
		    btnNewButton_10.setBounds(210, 139, 90, 30);
		    f1.getContentPane().add(btnNewButton_10);
		    btnNewButton_10.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		 JFrame ch9=new JFrame();  
		    		 ImageIcon icon = new ImageIcon("C:\\Users\\megha\\Downloads\\download (1) (1).jfif");
	            	  JLabel label = new JLabel(icon);
	            	 ch9.getContentPane().add(label);
	    	    	 ch9.setSize(400,400);
	    	    	 //ch2.pack();
	    	  	   ch9.getContentPane();
	    	  	    ch9.setVisible(true);   
		    	}	    });
		    
		    JButton btnNewButton_11 = new JButton("TV/AV");
		    btnNewButton_11.setBounds(11, 178, 90, 30);
		    f1.getContentPane().add(btnNewButton_11);
		    btnNewButton_11.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		 JFrame ch10=new JFrame();  
		    		 ImageIcon icon = new ImageIcon("C:\\Users\\megha\\Downloads\\3+DVD's (1).png");
	            	  JLabel label = new JLabel(icon);
	            	 ch10.getContentPane().add(label);
	    	    	 ch10.setSize(400,400);
	    	    	 //ch2.pack();
	    	  	   ch10.getContentPane();
	    	  	    ch10.setVisible(true);   
	    	        	} });
		    
		    JButton btnNewButton_12 = new JButton("0");
		    btnNewButton_12.setBounds(111, 178, 90, 30);
		    f1.getContentPane().add(btnNewButton_12);
		    
		    Button button_3g = new Button("game");
		    button_3g.setBounds(111, 421, 90, 30);
		    f1.getContentPane().add(button_3g);
		    button_3g.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		picpuzzle2 gam=new picpuzzle2(); 
		    		gam.setVisible(true);
		    	}  });
		    
		    JButton btnNewButton_13 = new JButton("MENU");
		    btnNewButton_13.setBounds(210, 178, 90, 30);
		    f1.getContentPane().add(btnNewButton_13);
		     btnNewButton_13.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		 JFrame fr1=new JFrame("Menu");
		  		 try {
		             fr1.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\megha\\Downloads\\istockphoto-621925576-612x612.jpg")))));
		         } catch (IOException e1) {
		             e1.printStackTrace();
		         }
		         fr1.pack();
		  		 fr1.setSize(300,450);  
				    fr1.getContentPane().setLayout(null);

			    	 JButton btnNewButton99 = new JButton("audio");
		    		    btnNewButton99.setIcon(new ImageIcon("C:\\Users\\megha\\Downloads\\high-volume.png"));
		    		    btnNewButton99.setBounds(158, 11, 100, 121);
		    		    fr1.getContentPane().add(btnNewButton99);
		    		    fr1.setVisible(true);
		    		  
		    			  btnNewButton99.addActionListener(new  ActionListener() {
				                 public void actionPerformed(ActionEvent e) {
				                	 try 
						 	            {
						 	            	String myurl=" https://open.spotify.com/artist/0fgtHVpOPfXb07S8Jx443z";
						 	            	java.awt.Desktop.getDesktop().browse(java.net.URI.create(myurl));
						 	            	
						 	            }
						 	            catch (Exception e2) 
						 	            {
						 	            	e2.printStackTrace();
						 	            }
						 	            	
				                	 btnNewButton99.setVisible(true);
						    	       
										}}
						            );
					                
				                	 //}});
				                
		    			  JButton btnNewButton = new JButton("settings");
		  		    btnNewButton.setIcon(new ImageIcon("C:\\Users\\megha\\Downloads\\settings.png"));
		  		    btnNewButton.setBounds(10, 11, 100, 121);
		  		    fr1.getContentPane().add(btnNewButton);
		  		  btnNewButton.addActionListener(new  ActionListener() {
		                 public void actionPerformed(ActionEvent e) {
		              	   JFrame f1=new JFrame();
		         		    f1.getContentPane();
		         		    f1.setSize(330,500);  
		         		    f1.getContentPane().setLayout(null);
		         		    f1.setVisible(true);
		         		    JButton b1=new JButton("ok");
		         		    JButton b2=new JButton("cancel");
		         		     b1.setBounds(210, 178, 90, 30);
		         		     b2.setBounds(11, 178, 90, 30);
								Choice c1=new Choice ();
								JLabel l1=new JLabel("Select ");
								l1.setBounds(100, 100, 150, 30);
								 c1.setBounds(100,150,150,30);  
							        c1.add("Language");  
							        c1.add("Time");  
							        c1.add("Button Lock");  
							        f1.add(l1);
							        f1.add(c1);
						        	f1.add(b1);
						         	f1.add(b2);
							b1.addActionListener(new  ActionListener() {
				                   public void actionPerformed(ActionEvent e) {
				                	   if(c1.getSelectedItem()=="Language") {
				                		   JFrame f2=new JFrame();
				           		    f2.getContentPane();
				           		    f2.setSize(330,500);  
				           		    f2.getContentPane().setLayout(null);
				           		    f2.setVisible(true);
				           			JRadioButton r1=new JRadioButton("A)English");    
				           			JRadioButton r2=new JRadioButton("B) Hindi");    
				           			JRadioButton r3=new JRadioButton("C) Itlian");   
				           			JRadioButton r4=new JRadioButton("D) Britian");    
				           			r1.setBounds(75,50,100,30);    
				           			r2.setBounds(75,70,100,30);    
				           			r3.setBounds(75,90,100,30); 
				           			r4.setBounds(75,110,100,30); 
				           			ButtonGroup bg=new ButtonGroup();    
				           			bg.add(r1);bg.add(r2);    bg.add(r3); bg.add(r4);
				           			f2.add(r1);
				           			f2.add(r2);
				           			f2.add(r3);
				           			f2.add(r4);
				                	   }
				           if(c1.getSelectedItem()=="Time") {      
							JFrame f3=new JFrame("Time Timer" );
							 f3.setSize(330,500);  
							f3.pack();
							f3.setVisible(true);
							JLabel timeLabel=new JLabel(new Date().toString());
							f3.add(timeLabel);
							Timer timer = new Timer(1000, null);
							timer.setInitialDelay(1);
							timer.start();
							timeLabel.setText(new Date().toString());
				           }		
		                 } });
		                 }});
				  		    
		  		  /*  JButton btnNewButton_1 = new JButton("in out\r\n\r\n");
		  		    btnNewButton_1.setToolTipText("sound");
		  		    btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Haswanth Tummala\\Downloads\\icons8-sound-80.png"));
		  		    btnNewButton_1.setBounds(158, 11, 100, 121);
		  		    fr1.getContentPane().add(btnNewButton_1);*/
		  		    
		  		    JButton btnNewButton_2 = new JButton("help");
		  		    btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\megha\\Downloads\\help.png"));
		  		    btnNewButton_2.setBounds(10, 156, 100, 121);
		  		  btnNewButton_2 .setVisible(true);
		  		 fr1.getContentPane().add(btnNewButton_2);
		  		  btnNewButton_2.addActionListener(new ActionListener() {
				    	public void actionPerformed(ActionEvent e) {
				    		JTextArea ta = new JTextArea();
				    		    ta.setTabSize(12);
				    		    ta.setRows(50);
				    		    ta.setText("\u001FAbout:\r\nhaswant o;oxobj;z");
				    		    ta.setLineWrap(true);
				    		    ta.setWrapStyleWord(true);
				    		    JScrollPane scroll = new JScrollPane(ta);
				    		    		ta.append("The first line.\n");
				    		    ta.append("Line Two!\n");
				    		    ta.append("This is the 3rd line of this document.");

				    		    // Print some results . . .
				    		    try {
				    		      for (int n = 0; n < ta.getLineCount(); n += 1)
				    		        System.out.println("line " + n + " starts at "
				    		            + ta.getLineStartOffset(n) + ", ends at "
				    		            + ta.getLineEndOffset(n));
				    		      System.out.println();

				    		      int n = 0;
				    		      while (true) {
				    		        System.out.print("offset " + n + " is on ");
				    		        System.out.println("line " + ta.getLineOfOffset(n));
				    		        n += 13;
				    		      }
				    		    } catch (BadLocationException ex) {
				    		      System.out.println(ex);
				    		    }

				    		    // Layout . . .
				    		    JFrame fx = new JFrame();
				    		    fx.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				    		    fx.getContentPane().add(scroll, java.awt.BorderLayout.CENTER);
				    		    fx.setSize(505, 356);
				    		    fx.setVisible(true);
				    		  }  });
		  		    
		  		    JButton btnNewButton_3 = new JButton("chat");
		  		    btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\megha\\Downloads\\download.jpg"));
		  		    btnNewButton_3.setBounds(158, 156, 100, 121);
		  		    fr1.getContentPane().add(btnNewButton_3);
		  		    fr1.setVisible(true);   
		  		  btnNewButton_3.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				    		JFrame frame1 =new JFrame();
				    		frame1.setVisible(true);
				    		 frame1.getContentPane().setLayout(null);  
				               frame1.setSize(300, 400);
				  //frame1.setLayout(null);
				    		frame1.setTitle("chat BOT");
				    		frame1.add(field);
				    		frame1.add(txt);
				    		txt.setLocation(1, 1);
				    		txt.setSize(400, 300);
				    		field.setLocation(1, 300);
				    		field.setSize(400,60);
				    		 field.addActionListener(new ActionListener() {
				    				public void actionPerformed(ActionEvent e) {
							    		String msg=field.getText();
				    				txt.append("you="+msg+"\n");
				    				field.setText("");
				    				 if(msg.toLowerCase().contains("how are u"))
				    				{
				    					txt.append("Bot= i am great and you?\n");
				    				
				    				}
				    else if(msg.toLowerCase().contains("fine"))
				    				 {
				    					txt.append("Bot=Great to hear\n");
				    				}
				    				else if(msg.toLowerCase().contains("inka"))
				    				{
				    					txt.append("Bot=chpali\n");
				    				}
				    					}	});
				    		 }});
				    	}	});
		    JButton btnNewButton_14 = new JButton("PR++");
		    btnNewButton_14.setBounds(111, 222, 90, 30);
		    f1.getContentPane().add(btnNewButton_14);
		 
		   JButton btnNewButton_15 = new JButton("vol>");
		    btnNewButton_15.setBounds(210, 265, 90, 30);
		    f1.getContentPane().add(btnNewButton_15);
		    
		    JButton btnNewButton_16 = new JButton("PR--");
		    btnNewButton_16.setBounds(111, 299, 90, 30);
		    f1.getContentPane().add(btnNewButton_16);
		    
		    JButton btnNewButton_17 = new JButton("OK");
		    btnNewButton_17.setBounds(111, 265, 90, 30);
		    f1.getContentPane().add(btnNewButton_17);
		    
		   JButton btnNewButton_19 = new JButton("Sleep");
		    btnNewButton_19.setBounds(11, 338, 90, 30);
		    f1.getContentPane().add(btnNewButton_19);
		    btnNewButton_19.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                f1.setState(Frame.ICONIFIED);
	                f1.setSize(330,500); 
	               f1.pack();
	                f1.setVisible(true);
	                //f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	            }
	        });
		    Button button = new Button("ARC");
		    button.setBackground(Color.RED);
		    button.setBounds(10, 384, 90, 30);
		    f1.getContentPane().add(button);
		    
		    Button button_1 = new Button("sound");
		    button_1.setBackground(Color.WHITE);
		    button_1.setBounds(111, 384, 90, 30);
		    f1.getContentPane().add(button_1);
		    
		    Button button_2 = new Button("picture");
		    button_2.setBounds(210, 384, 90, 30);
		    f1.getContentPane().add(button_2);
		    
		    Button button_3 = new Button("PSM");
		    button_3.setBounds(111, 421, 90, 30);
		    f1.getContentPane().add(button_3);
		    
		    Button button_4 = new Button("SSM");
		    button_4.setBounds(213, 420, 90, 30);
		    f1.getContentPane().add(button_4);
		    
		    Button button_5 = new Button("OFF");
		  button_5.setFont(null);
		    button_5.setBackground(Color.RED);
		    button_5.setBounds(11, 11, 90, 30);
		    f1.getContentPane().add(button_5);
		    button_5.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
	    		System.exit(0);
		    	}
		    });
		    	
		   Button button_6 = new Button("ON");
		    button_6.setBackground(Color.GREEN);
		    button_6.setBounds(210, 11, 90, 30);
		    f1.getContentPane().add(button_6);
		    button_6.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	 JFrame ch11=new JFrame();  
	    	    	 ch11.setSize(300,300);  
	    	  	   ch11.getContentPane().setLayout(null);  
	    	  	    ch11.setVisible(true);   
	            }		}    );
		    
		    Button button_7 = new Button("Q-view");
		    button_7.setBackground(Color.YELLOW);
		    button_7.setBounds(213, 338, 90, 30);
		    f1.getContentPane().add(button_7);
		    
		    Button button_8 = new Button("list");
		    button_8.setBackground(Color.CYAN);
		    button_8.setBounds(111, 338, 90, 30);
		    f1.getContentPane().add(button_8);
		    
		    JButton btnNewButton = new JButton("vol<");
		   btnNewButton.setBounds(11, 265, 90, 30);
		    f1.getContentPane().add(btnNewButton);
		    
		    JButton btnNewButton_18 = new JButton("timer");
		    btnNewButton_18.setBackground(Color.white);
		    btnNewButton_18.setForeground(Color.BLACK);
		    btnNewButton_18.setBounds(112, 11, 90, 30);
		    f1.getContentPane().add(btnNewButton_18);
		   btnNewButton_18.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
			 JFrame ch16=new JFrame();  
	    	 ch16.setSize(400,400);  
	  	  // ch16.getContentPane().setLayout(null);  
	  	    ch16.setVisible(true);   
	  	 TvRemote clock = new TvRemote();  
	  	  ch16.getContentPane().add(clock);  
	  	  ch16.setVisible(true);  
	  	  clock.start();  
	  		    	}});
		 
	}

}




