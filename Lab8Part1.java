import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Lab8Part1 extends JPanel
{

   //int for pixels skipped, index of radioButtons, and count and for the ratio
   int pixelSkip, ratio, index, count;
   
   //ArrayList Color to store colors of the boxs
   private ArrayList <Color> colorArray = new ArrayList <Color>();
  
   //crreate 5 color objects of Color.WHITE to add to colorArray as default value
   private Color c1 = Color.WHITE,c2 = Color.WHITE,c3 = Color.WHITE,c4 = Color.WHITE,c5 = Color.WHITE;   
   
   //create JRadioButton(s) 1 skip, 3 skip, and 5 skip
   private JRadioButton skip1 = new JRadioButton("1 skip");
   private JRadioButton skip3 = new JRadioButton("3 skip");
   private JRadioButton skip5 = new JRadioButton("5 skip");
   
   //create CheckBox for colors of the square
   private JCheckBox red = new JCheckBox("Red");
   private JCheckBox yellow = new JCheckBox("Yellow");
   private JCheckBox green = new JCheckBox("Green");
   private JCheckBox purple = new JCheckBox("Purple");
   private JCheckBox black = new JCheckBox("Black");
   
   //create JComboBox items 
   private String [] items = {"1:1","2:1","3:1"};
   
   //create JComboBox
   JComboBox <String> menu;
   
   
   //constructor
   public Lab8Part1()
   {
      super();
      
      //add default Color.WHITE color objects to the array list coloArray
      colorArray.add(c1);
      colorArray.add(c2);
      colorArray.add(c3);
      colorArray.add(c4);
      colorArray.add(c5);
         
         
      //JPanel1
      JPanel panelOne = new JPanel();
      panelOne.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
      panelOne.setPreferredSize(new Dimension(90,60));
      
      //create JTextField with texrtListener
      JTextField myText = new JTextField(10);
      myText.addActionListener(new textListener());
      
      //add JTextField to panel
      panelOne.add(myText);
      add(panelOne);
      
      //JComboBox menu stores items
      menu = new JComboBox(items);
      
      //add ItemListener to menu
      menu.addItemListener(new CheckBoxListener());
      panelOne.add(menu);
   
   
      //JPanel2
      JPanel panelTwo = new JPanel();
      panelTwo.setPreferredSize(new Dimension(60,90));
      
      //add ItemListener to each radio button and set skip1 to selected
      skip1.addItemListener(new CheckBoxListener());
      skip3.addItemListener(new CheckBoxListener());
      skip5.addItemListener(new CheckBoxListener());
      skip1.setSelected(true);
         
      //group skip radio buttons together and add to Panel
      ButtonGroup bg = new ButtonGroup();
      bg.add(skip1);
      bg.add(skip3);
      bg.add(skip5);
      panelTwo.add(skip1);
      panelTwo.add(skip3);
      panelTwo.add(skip5);
      
      add(panelTwo);
     
     
      //JPanel3 with GridLayout 5x1
      JPanel panelThree = new JPanel();
      panelThree.setLayout(new GridLayout(5,1));
      
      //add panelThree to the JPanel
      add(panelThree);
      //add itemListener ColorCheckBoxListener() to each box and add to panelThree
      red.addItemListener(new ColorCheckBoxListener());
      panelThree.add(red);
      yellow.addItemListener(new ColorCheckBoxListener());
      panelThree.add(yellow);
      green.addItemListener(new ColorCheckBoxListener());
      panelThree.add(green);
      purple.addItemListener(new ColorCheckBoxListener());
      panelThree.add(purple);
      black.addItemListener(new ColorCheckBoxListener());
      panelThree.add(black);
      
      
      //set layout of JPanel to flowlayout
      setLayout(new FlowLayout());
      setPreferredSize(new Dimension(500,500));
      setVisible(true);
      setBackground(Color.DARK_GRAY);
   }
   
   
   
   //paint component
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      
      //x y store value of x, y postion;pX and pY store length of Rect, k keeps track of index,
      //and a keeps while loop from looping infinitley
      int x = 0,y = 200,pX = 150, pY = 150, k = 0,a = 0;

      //fill in rectangles with pixelSkip while a rectangle can be drawn
      while((pX > 0 && pY > 0 && a < 300))
      {
            //if colorArray has one of the specified colors, draw the rect using the rect formula and update values
            if((colorArray.get(k) == Color.RED || colorArray.get(k) == Color.YELLOW || colorArray.get(k) == Color.GREEN || colorArray.get(k) == Color.MAGENTA || colorArray.get(k) == Color.BLACK))
            {
               g.setColor(colorArray.get(k));
               g.drawRect(((x+pixelSkip)*ratio),y+pixelSkip,(pX-pixelSkip*2)*ratio,(pY-pixelSkip*2));
               x+=pixelSkip;
               y+=pixelSkip;
               pX-=pixelSkip*2;
               pY-=pixelSkip*2;
               
            }
            k++;
            a++;
            
            //keep colorArray in bounds
            if(k >4)
            {
               k = 0;
            }
      }
   }


   //Class for JTextBox myText
   public class textListener implements ActionListener
   {
      public void actionPerformed(ActionEvent ae)
      {
         String s = ((JTextField)ae.getSource()).getText();
         //if a is entered
         if(s.equals("a"))
         {
            //make ratio 2:1
            ratio = 2;
    
            //make pixelSkip 1
            pixelSkip = 2;
            
            //update GUI elements 
            skip3.setSelected(true);
            red.setSelected(false);
            yellow.setSelected(false);
            green.setSelected(false);
            purple.setSelected(false);
            black.setSelected(true);
            menu.setSelectedIndex(1);
            
            //set all values of color array to White except at index 4 (black)
            c1 = Color.WHITE;
            colorArray.set(0,c1);
            c2 = Color.WHITE;
            colorArray.set(1,c2);
            c3 = Color.WHITE;
            colorArray.set(2,c3);
            c4 = Color.WHITE;
            colorArray.set(3,c4);
            c5 = Color.BLACK;
            colorArray.set(4,c5);  
         }
         repaint();
      }  
   }
   
   
   
   //class CheckRadioBoxListener for Radio buttons and for ratio buttons
   public class CheckBoxListener implements ItemListener
   {
      public void itemStateChanged(ItemEvent ie)
      {
         //get index of the ComboBox
         index  = menu.getSelectedIndex();
         
         //if statement to determine ratio based of radio button
         if(index == 0)
         {
            ratio = 1; 
            repaint();
         }
         else if(index == 1)
         {
            ratio = 2;      
            repaint();
         }
         else if(index == 2)
         {
            ratio = 3;         
            repaint();
         }
         
         //if statement for if 1 skip is selected
         if(ie.getSource() == skip1 && ie.getStateChange() == ItemEvent.SELECTED)
         {
            pixelSkip = 2;
            repaint();
         }
         //if statement for if 3 skip is selected
         if(ie.getSource() == skip3 && ie.getStateChange() == ItemEvent.SELECTED)
         {
            pixelSkip = 4;
            repaint();
         }
         //if statement for if 5 skip is selected
         if(ie.getSource() == skip5 && ie.getStateChange() == ItemEvent.SELECTED)
         {
            pixelSkip = 6;
            repaint();
         }
      }
   }
   
   
   //class CheckBoxListener class which implements ItemListener for color selection
   public class ColorCheckBoxListener implements ItemListener
   {
      public void itemStateChanged(ItemEvent ie)
      {
         //for red checkBox
         if(ie.getSource() == red)
         {
         
            //if user checks red box, set c1 to red and update colorArray
            if(ie.getStateChange() == ItemEvent.SELECTED)
            {           
               c1 = Color.RED;
               colorArray.set(0,c1);
               repaint();    
            }
            
            //if user deselects red checkBox, set c1 to white and update colorArray
            if(ie.getStateChange() == ItemEvent.DESELECTED)
            {
               c1 = Color.WHITE;
               colorArray.set(0,c1);           
            }
         }
         
         //for yellow checkBox
         if(ie.getSource() == yellow)
         {
            //if user checks yellow box, set c2 to yellow and update colorArray
            if(ie.getStateChange() == ItemEvent.SELECTED)
            {
               c2 = Color.YELLOW;
               colorArray.set(1,c2);
               repaint();
            }
            
            //if user deselects yellow checkBox, set c2 to white and update colorArray
            if(ie.getStateChange() == ItemEvent.DESELECTED)
            {
               c2 = Color.WHITE;
               colorArray.set(1,c2);
               repaint();
            }
         }
         
         //for Green checkBox
         if(ie.getSource() == green)
         {
            ///if user checks Green box, set c3 to green and update colorArray
            if(ie.getStateChange() == ItemEvent.SELECTED)
            {
               c3 = Color.GREEN;
               colorArray.set(2,c3);
               repaint();
            }
            //if user deselects green checkBox,  set c3 to white and update colorArray
            if(ie.getStateChange() == ItemEvent.DESELECTED)
            {    
               c3 = Color.WHITE;
               colorArray.set(2,c3);
               repaint();
            }
         }
         
         //for purple checkBox
         if(ie.getSource() == purple)
         {
            //if user checks purple box, set c4 to magenta and update colorArray
            if(ie.getStateChange() == ItemEvent.SELECTED)
            {
               c4 = Color.MAGENTA;
               colorArray.set(3,c4);
               repaint();
            }
            //if user deselects purple checkBox, set c4 to white and update colorArray
            if(ie.getStateChange() == ItemEvent.DESELECTED)
            {
               c4 = Color.WHITE;
               colorArray.set(3,c4);
               repaint();
            }      
         }

         //for black checkBox
         if(ie.getSource() == black)
         {
            //if user checks black box, set c5 to black and update colorArray
            if(ie.getStateChange() == ItemEvent.SELECTED)
            {  
               c5 = Color.BLACK;
               colorArray.set(4,c5);
            }
            
            //if user deselects black checkBox, set c5 to white and update colorArray
            if(ie.getStateChange() == ItemEvent.DESELECTED)
            {
               c5 = Color.WHITE;
               colorArray.set(4,c5);
            }
         }
       repaint();
      }
   }
}