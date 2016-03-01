//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import java.awt.Color;
//import java.awt.Font;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import sun.audio.AudioStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;



public class ButttonBox extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1;
	private GridBagLayout layout;
	private  GridBagConstraints c;
	private JLabel l;
	private JButton b;
	private JPanel p;
	private Clip clip;
	private AudioInputStream audio;
	
	public ButttonBox(){
		
		super("Button Box Sounds");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		layout = new GridBagLayout();
		setLayout(layout);
		
		JTextField inputField;
		
		c = new GridBagConstraints();
	      // general constraints
	    c.fill = GridBagConstraints.BOTH;
	    
	    c.weightx = 0.0;
        c.gridwidth = GridBagConstraints.RELATIVE;
        
        c.gridx = 1;
        c.gridy = 0;
        l = new JLabel( "Sound Board" );
        layout.setConstraints( l, c );
        add(l );
        
        p = new JPanel(new GridLayout(1,2));
        
        c.weightx = 1;
       // c.gridwidth = GridBagConstraints.WEST;
        c.gridx = 0;
        c.gridy = 1;
        b = new JButton("First Sound");
        b.setActionCommand("one");
        b.addActionListener(this);
       // p.add(b);
        layout.setConstraints( b, c );
        add( b );
        
        /*
        c.weightx = 1;
        //c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridx = 1;
        c.gridy = 1;
        b = new JButton("Second Sound");
        b.setActionCommand("two");
        b.addActionListener(this);
       // p.add(b);
        layout.setConstraints( b, c );
        add( b );
	   */
        
        c.weightx = 1;
        //   c.gridwidth = GridBagConstraints.REMAINDER;
           c.gridx = 2;
           c.gridy = 1;
           b = new JButton("Second Sound");
           b.setActionCommand("two");
           b.addActionListener(this);
           layout.setConstraints( b, c );
           add( b );
           
        
        
        c.weightx = 1;
     //   c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridx = 2;
        c.gridy = 1;
        b = new JButton("Third Sound");
        b.setActionCommand("three");
        b.addActionListener(this);
        layout.setConstraints( b, c );
        add( b );
        
        
        setSize( getPreferredSize());
		pack();
		setVisible(true);
	}
	
	

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
JButton button = (JButton)e.getSource();
		
	switch( button.getActionCommand()){
		
	
		case ("one"):
		
		
			File ding = new File("ding.wav");
		
			playSound(ding);
			
			break;
		
		case ("two"):
			
			ding = new File("chord.wav");
		
			playSound(ding);
			
		break;
		
		case ("three"):
			
			ding = new File("chimes.wav");
		
			playSound(ding);
	
			
		break;
		
		default:
			
			break;
			
		
		}
	        
		
	}
	
	public void playSound(File ding){
		
		try {
			audio = AudioSystem.getAudioInputStream(ding);
		} catch (UnsupportedAudioFileException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("y");
		}
		//http://www.codejava.net/coding/how-to-play-back-audio-in-java-with-examples
		
		//AudioFormat format = new AudioFormat(getOpacity(), getDefaultCloseOperation(), getDefaultCloseOperation(), rootPaneCheckingEnabled, rootPaneCheckingEnabled);
		 
		AudioFormat format = audio.getFormat();
		
		DataLine.Info info = new DataLine.Info(Clip.class, format);
		
		try {
			clip = (Clip) AudioSystem.getLine(info);
		} catch (LineUnavailableException e1) {
			// TODO Auto-generated catch block
			System.out.println("why");
		}
		
		try {
			clip.open(audio);
		} catch (LineUnavailableException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		clip.start();
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new  ButttonBox();
	}

}
