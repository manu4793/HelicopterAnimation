//import java.awt.*;
import java.awt.Color;
import java.awt.Image;
import java.awt.Canvas;
import java.awt.Toolkit;
import java.awt.Graphics;
import javax.swing.JFrame;

//Class to define the Stickman objects

class Helicopter {

  int x,     //object position
      y;
		
  Helicopter()
  {
    x = 0;
	 y = 0;
  }

  Helicopter(int initX, int initY)
  {
    x = initX;
	 y = initY;
  }
  
  void move(int xInc, int yInc)
  {
    x = x + xInc;
	 y = y + yInc;
  }
  
  void drawFrame(Graphics g, int f,int x, int y)
  {
    //g = Graphics object
	 //f = frame to draw
	 //x = horizontal location
	 //y = vertical location
	 
    switch (f)
	 {
	   case 0:  //draws frame 0
		{
        
         g.drawOval(0+x, 0+y, 55,45);     //cuerpo del helicoptero
         g.fillOval(0+x, 0+y, 55,45);
         g.drawLine(0+x,25+y,-50+x,25+y); //tail
         g.drawLine(-50+x,40+y,-50+x,10+y);
         g.drawLine(-65+x,25+y,-35+x,25+y);
         g.drawLine(25+x,0+y,25+x,-20+y); //rotor
         g.drawLine(-25+x,-20+y,75+x,-20+y);
         g.drawLine(60+x,0+y,-10+x,-40+y);


		  break;
		}
	   case 1:  //draws frame 1
		{
        
         g.drawOval(0+x, 0+y, 55,45);     //cuerpo del helicoptero
         g.fillOval(0+x, 0+y, 55,45);
         g.drawLine(0+x,25+y,-50+x,25+y); //tail
         g.drawLine(-37+x,40+y,-62+x,10+y);
         g.drawLine(-62+x,40+y,-37+x,10+y);
         g.drawLine(25+x,0+y,25+x,-20+y); //rotor
         g.drawLine(-25+x,-20+y,75+x,-20+y);
         g.drawLine(60+x,-40+y,-10+x,0+y);

		  break;
		}
	   case 2:  //draws frame 2
		{
        
         g.drawOval(0+x, 0+y, 55,45);     //cuerpo del helicoptero
         g.fillOval(0+x, 0+y, 55,45);
         g.drawLine(0+x,25+y,-50+x,25+y); //tail
         g.drawLine(-45+x,38+y,-55+x,12+y);
         g.drawLine(-63+x,30+y,-37+x,20+y);
         g.drawLine(25+x,0+y,25+x,-20+y); //rotor
         g.drawLine(-25+x,-20+y,75+x,-20+y);
         g.drawLine(25+x,15+y,25+x,-40+y);

		}
	 } //switch	
  }
}
public class HelicopterAnimation extends Canvas
 {
   public void paint(Graphics g) {  
     Image img;
     
            Toolkit t = Toolkit.getDefaultToolkit();  
            img = t.getImage("background.png"); //Returns an image pixel data from a file
            
             //Create to StickMan objects
             Helicopter Helicopter1 = new Helicopter();
		       Helicopter Helicopter2 = new Helicopter();
		       Helicopter Helicopter3 = new Helicopter();
         
         for (int i=0; i<200; i++)
		    {
             g.clearRect(0,0,400,400);     //Erase image
             g.drawImage(img, 0, 0,this);  //Draw image
             
             Helicopter1.drawFrame(g,(i+1)%3,i,170);
             Helicopter2.drawFrame(g,i%3,i*2,250);
             Helicopter3.drawFrame(g,i%3,400-2*i,250);
             
             //to implement a time delay
             try{
	              Thread.sleep(50); //hold 100ms before next Canvas
	             }
	               catch(InterruptedException e)
	             {
                }    
           }
    }    
   
   public static void main( String args[] )
 	{
     
     JFrame frame = new JFrame("Helicopter Animation");	//Create the frame and place the title 
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
     HelicopterAnimation canvas = new HelicopterAnimation(); //Create the canvas and place the Stick Animation
     canvas.setBackground(Color.RED); //Change the background color of the canvas to RED     
     frame.add(canvas); //Add the canvas to the frame 
     frame.setSize(400,400); //Set frame size 
     frame.setLocationRelativeTo(null); //Set the frame location
     frame.setVisible(true); //Makes the frame visible 
   }
}