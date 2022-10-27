import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Lab8Part2Main extends JFrame
{
   public Lab8Part2Main()
   {
      super("Lab8c");
      
      Container contents = getContentPane();
      //set layout of JFrame to FlowLayout
      contents.setLayout(new FlowLayout());
      
      //mousePanel object, add to JFrame
      MousePanel mp = new MousePanel();
      add(mp);
      
      setSize(600,600);
      setVisible(true);
   }
   public static void main(String[]args)
   {
      //JFrame object reference myPanel
      Lab8Part2Main myPanel = new Lab8Part2Main();
      myPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}