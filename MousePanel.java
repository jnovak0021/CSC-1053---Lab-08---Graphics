import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class MousePanel extends JPanel
{
   //random object
   Random rand = new Random();
   
   //array list of position of position of boxs
   ArrayList <Integer> points = new ArrayList <Integer>();
   
   //store location of box'ss
   private int x,y;
   
   //opcatiy of highlight box and highlight outline box
   private int a,b;
   
   //store data for highlight box// startX and StartY being the original click location and lengthX and length Y the drag to location
   private int startX, startY, lengthX, lengthY;
   
   
   //JPanel constructor
   public MousePanel()
   {
      super();
      
      setBackground(Color.RED);
      
      //set Layout to flow layout
      setLayout(new FlowLayout());

      //preffered size: 500,500
      setPreferredSize(new Dimension(500,500));
      
      //JButton to reset position of squares
      JButton reset = new JButton("Reset");
      
      //add button listener
      reset.addActionListener(new ButtonListener());
      
      //add reset button to JPanel
      add(reset);
      
      //add MouseListener MouseClass()
      addMouseListener(new MouseClass());
      addMouseMotionListener(new MouseClass());
      
   }
   
   
   
   //paint component
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      
      g.setColor(Color.BLACK);

      //for loop to print out all boxs
      //points.get(i) = x position & points.get(i+1) = y position
      for(int i = 0; i < points.size(); i +=2)
      {
         //25 by 25 box at random location
         g.fillRect(points.get(i)-13,points.get(i+1)-13,25,25);
      }
      
      
      //opaque highlight box
      g.setColor(new Color(173,216,230,a));
     
      //if statement to draw the highlight box no matter which way the user drags the box
      //draws solid highlight box then outline second
      if(startX > lengthX && startY > lengthY)
      {
         g.fillRect(lengthX,lengthY,startX-lengthX,startY-lengthY);         
         g.setColor(new Color(173,216,230,b));
         g.drawRect(lengthX,lengthY,startX-lengthX,startY-lengthY);
         
      }
      else if(startX > lengthX)
      {
         g.fillRect(lengthX,startY,startX-lengthX,lengthY-startY);
         g.setColor(new Color(173,216,230,b));
         g.drawRect(lengthX,startY,startX-lengthX,lengthY-startY);
      }
      else if(startY > lengthY)
      {
         g.fillRect(startX,lengthY,lengthX-startX,startY-lengthY);
         g.setColor(new Color(173,216,230,b));
         g.drawRect(startX,lengthY,lengthX-startX,startY-lengthY);

      }else
      {
        g.fillRect(startX,startY,lengthX-startX,lengthY-startY);
        g.setColor(new Color(173,216,230,b));
        g.drawRect(startX,startY,lengthX-startX,lengthY-startY);
      }

      
      //for loop to draw black box into white box if half is contained in 
      for (int i = 0; i < points.size(); i+=2)
      {
         //Highlight box Down and Right
         //repaint black box white
         if(((points.get(i) < lengthX) && (points.get(i) > startX)) && ((points.get(i+1) < lengthY) && (points.get(i+1) >startY)))
         {
            g.setColor(Color.WHITE);
            g.fillRect(points.get(i)-14,points.get(i+1)-14,25,25);
         }
         //Highlight box Down and left
         else if(((points.get(i) > lengthX) && (points.get(i) < startX)) && ((points.get(i+1) < lengthY) && (points.get(i+1) >startY)))
         {
            g.setColor(Color.WHITE);
            g.fillRect(points.get(i)-14,points.get(i+1)-14,25,25);
         }
         //Highlight box up and Right
         else if(((points.get(i) < lengthX) && (points.get(i) > startX)) && ((points.get(i+1) > lengthY) && (points.get(i+1) < startY)))
         {
            g.setColor(Color.WHITE);
            g.fillRect(points.get(i)-14,points.get(i+1)-14,25,25);
    
         }
         //Highlight box up and left
         else if(((points.get(i) > lengthX) && (points.get(i) < startX)) && ((points.get(i+1) > lengthY) && (points.get(i+1) <startY)))
         {
           g.setColor(Color.WHITE);
           g.fillRect(points.get(i)-14,points.get(i+1)-14,25,25);}
      }  
   }


   
   //class buttonListener -- implements from ActionListener
   public class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent ae)
      {
         //reset ArrayList of points
         points.clear();
         
         //for loop to store random values of the x and y position of 10 boxs
         //store points in arrayList points at x = i and y = i + 1
         for( int i = 0; i < 10; i++ )
         {
            x = rand.nextInt(470)+15;
            y = rand.nextInt(440)+45;
            points.add(x);
            points.add(y);
       
         }
         repaint();
      }
   }
   
   
   //MouseClass extends MouseAdapter
   public class MouseClass extends MouseAdapter
   {
      //when mouse is pressed, set startX and startY and lengthX and lengthY to where the user clicks
      
      public void mousePressed(MouseEvent me)
      {
        startX = me.getX();
        startY = me.getY();
        lengthX =startX;
        lengthY = startY;

      }
      public void mouseMoved(MouseEvent me)
      {}
      //when mouse is dragged set lengthX and lengthY to location of mouse, and repaint(); set opacity for highlight boxs;
      public void mouseDragged(MouseEvent me)
      {
         a = 150;
         b=250;
         lengthX = me.getX();
         lengthY = me.getY();
         repaint(); 
      }
      //make highlight boxs clear
      public void mouseReleased(MouseEvent me)
      {
         a=0;
         b=0;
         repaint();
      }
   }
}