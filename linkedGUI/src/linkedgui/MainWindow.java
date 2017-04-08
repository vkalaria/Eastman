package linkedgui;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author phillip
 */
public class MainWindow extends JPanel{
      
   JLabel tempStart = new JLabel();
   JLabel tempEnd = new JLabel();
   JLabel waterTemp = new JLabel();
   JLabel screwSpeed = new JLabel();
   JLabel coldWater = new JLabel();
   JLabel tempReduction = new JLabel();

//   private String python = null;

   public MainWindow(GridLayout g, LinkedGUI parent){
      setLayout(g);

      JPanel p1 = new JPanel(new BorderLayout(5,5));
      JPanel p1_1 = new JPanel(new BorderLayout(0,0));
      JPanel p2 = new JPanel(new BorderLayout(5,5));
      JPanel p2_1 = new JPanel(new BorderLayout(0,0));
      JPanel p3 = new JPanel(new BorderLayout(5,5));
      JPanel p3_1 = new JPanel(new BorderLayout(0,0));
      JPanel p4 = new JPanel(new BorderLayout(5,5));
      JPanel p4_1 = new JPanel(new BorderLayout(0,0));
      JPanel p5 = new JPanel(new BorderLayout(5,5));
      JPanel p5_1 = new JPanel(new BorderLayout(0,0));
      JPanel p6 = new JPanel(new BorderLayout(5,5));
      JPanel p6_1 = new JPanel(new BorderLayout(0,0));
      
      Border lineBorder = new LineBorder(Color.BLACK, 2);
      Font font1 = new Font("SansSerif", Font.BOLD, 24);
      Font font2 = new Font("SansSerif", Font.BOLD, 16);
      Font mainFont = new Font("mainFont", Font.BOLD, 60 );

      JLabel tempStartTitle = new JLabel("Temp Start", JLabel.CENTER);
      JLabel tempEndTitle = new JLabel("Temp End", JLabel.CENTER);
      JLabel waterTempTitle = new JLabel("Water Temp", JLabel.CENTER);
      JLabel screwSpeedTitle = new JLabel("Screw Speed", JLabel.CENTER);
      JLabel coldWaterTitle = new JLabel("Cold Water %", JLabel.CENTER);
      JLabel tempReductionTitle = new JLabel("Temp Reduction", JLabel.CENTER);

      JButton start = new JButton("START");
      JButton stop = new JButton("STOP");
      JButton manual = new JButton("MANUAL");

      // Adding elements to the window and setting their properties.
      tempStart.setBorder(lineBorder);
      tempStart.setBackground(Color.white);
      tempStart.setFont(mainFont);
      tempStart.setHorizontalAlignment(tempStart.CENTER);
      tempStartTitle.setFont(font2);
      p1.add(tempStartTitle, BorderLayout.NORTH);
      p1_1.add(tempStart);
      p1.add(p1_1);
      p1_1.setBackground(Color.WHITE);
      
      tempEnd.setBorder(lineBorder);
      tempEnd.setBackground(Color.white);
      tempEnd.setFont(mainFont);
      tempEnd.setHorizontalAlignment(tempEnd.CENTER);
      tempEndTitle.setFont(font2);
      p2.add(tempEndTitle, BorderLayout.NORTH);
      p2_1.add(tempEnd);
      p2.add(p2_1);
      p2_1.setBackground(Color.WHITE);

      waterTemp.setBorder(lineBorder);
      waterTemp.setBackground(Color.white);
      waterTemp.setFont(mainFont);
      waterTemp.setHorizontalAlignment(waterTemp.CENTER);
      waterTempTitle.setFont(font2);
      p3.add(waterTempTitle, BorderLayout.NORTH);
      p3_1.add(waterTemp);
      p3.add(p3_1);
      p3_1.setBackground(Color.WHITE);

      screwSpeed.setBorder(lineBorder);
      screwSpeed.setBackground(Color.WHITE);
      screwSpeed.setFont(mainFont);
      screwSpeed.setHorizontalAlignment(screwSpeed.CENTER);
      screwSpeedTitle.setFont(font2);
      p4.add(screwSpeedTitle, BorderLayout.NORTH);
      p4_1.add(screwSpeed);
      p4.add(p4_1);
      p4_1.setBackground(Color.WHITE);

      coldWater.setBorder(lineBorder);
      coldWater.setBackground(Color.black);
      coldWater.setFont(mainFont);
      coldWater.setHorizontalAlignment(coldWater.CENTER);
      coldWaterTitle.setFont(font2);
      p5.add(coldWaterTitle, BorderLayout.NORTH);
      p5_1.add(coldWater);
      p5.add(p5_1);
      p5_1.setBackground(Color.WHITE);

      tempReduction.setBorder(lineBorder);
      tempReduction.setBackground(Color.white);
      tempReduction.setFont(mainFont);
      tempReduction.setHorizontalAlignment(tempReduction.CENTER);
      tempReductionTitle.setFont(font2);
      p6.add(tempReductionTitle, BorderLayout.NORTH);
      p6_1.add(tempReduction);
      p6.add(p6_1);
      p6_1.setBackground(Color.WHITE);
      
      start.setBackground(Color.GREEN);
      start.setFont(font1);
      
      stop.setBackground(Color.RED);
      stop.setFont(font1);

      manual.setBackground(Color.LIGHT_GRAY);
      manual.setFont(font1);

      setBorder(new EmptyBorder(10, 10, 10, 10));

      // Adds each of the buttons and the display panels to the outer panel.
      add(p1);
      add(p2);
      add(p3);
      add(p4);
      add(p5);
      add(p6);
      add(start);
      add(stop);
      add(manual);
      

      // Creating actionListeners for each of the three buttons on the screen
      stop.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            parent.link.writeButtonPress("stop\n");
            
         }
      });
      
      start.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            parent.link.writeButtonPress("start\n");
            
         }
      });
      
      manual.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) {
            parent.link.writeButtonPress("manual\n");
            parent.changePane(1);
         }
      });
   }
   
   void setTempStart(String s)
   {
      tempStart.setText(s);
   }
   
   void setTempEnd(String s)
   {
      tempEnd.setText(s);
   }
   
   void setWaterTemp(String s)
   { 
      waterTemp.setText(s);
   }
   
   void setScrewSpeed(String s)
   {
      screwSpeed.setText(s);
   }
   
   void setColdWater(String s)
   {
      coldWater.setText(s);
   }
   
   void setTempReduction(String s)
   {
      tempReduction.setText(s);
   }
}