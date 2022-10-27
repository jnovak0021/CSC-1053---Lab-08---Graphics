import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Lab8Part1Main extends JFrame
{
   //constructor to create JFrame, calls JFrame constructor
   public Lab8Part1Main()
   {
      super("Lab 8 Part 1");  //JFrame constructor 
      
      Container contents = getContentPane();
      //set layout to FLowLayout
      contents.setLayout(new FlowLayout());

      setSize(600,600);
      setVisible(true);
     
      //Lab8Part1 object Reference
      Lab8Part1 panel = new Lab8Part1();
      
      //add panel to JFrame
      contents.add(panel);
   }

   public static void main(String[]args)
   {
      Lab8Part1Main l8P1 = new Lab8Part1Main();
      l8P1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}