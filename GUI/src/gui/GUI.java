/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

/*
 *
 * @author phillip
 */
public class GUI extends JFrame{
      
   final private JFrame manualFrame = new JFrame();

   final private ManualWindow manualWindow = new ManualWindow(manualFrame);
   
   final private JPanel pOut = new JPanel(new GridLayout(3,3,5,5));
   
   final private JPanel p1 = new JPanel(new BorderLayout(5,5));
   final private JPanel p2 = new JPanel(new BorderLayout(5,5));
   final private JPanel p3 = new JPanel(new BorderLayout(5,5));
   final private JPanel p4 = new JPanel(new BorderLayout(5,5));
   final private JPanel p5 = new JPanel(new BorderLayout(5,5));
   final private JPanel p6 = new JPanel(new BorderLayout(5,5));

   public GUI(){

      Border lineBorder = new LineBorder(Color.BLACK, 2);
      Font font1 = new Font("SansSerif", Font.BOLD, 24);
      Font font2 = new Font("SansSerif", Font.BOLD, 16);

      JLabel tempStart = new JLabel();
      JLabel tempStartTitle = new JLabel("Temp Start", JLabel.CENTER);
      JLabel tempEnd = new JLabel();
      JLabel tempEndTitle = new JLabel("Temp End", JLabel.CENTER);
      JLabel waterTemp = new JLabel();
      JLabel waterTempTitle = new JLabel("Water Temp", JLabel.CENTER);
      JLabel screwSpeed = new JLabel();
      JLabel screwSpeedTitle = new JLabel("Screw Speed", JLabel.CENTER);
      JLabel coldWater = new JLabel();
      JLabel coldWaterTitle = new JLabel("Cold Water %", JLabel.CENTER);
      JLabel tempReduction = new JLabel();
      JLabel tempReductionTitle = new JLabel("Temp Reduction", JLabel.CENTER);

      JButton start = new JButton("START");
      JButton stop = new JButton("STOP");
      JButton manual = new JButton("MANUAL");

      pOut.setBorder(new EmptyBorder(10, 10, 10, 10));
      
      // Adding elements to the window and setting their properties.
      tempStart.setBorder(lineBorder);
      tempStart.setBackground(Color.white);
      tempStartTitle.setFont(font2);
      p1.add(tempStartTitle, BorderLayout.NORTH);
      p1.add(tempStart);
      
      tempEnd.setBorder(lineBorder);
      tempEnd.setBackground(Color.white);
      tempEndTitle.setFont(font2);
      p2.add(tempEndTitle, BorderLayout.NORTH);
      p2.add(tempEnd);

      waterTemp.setBorder(lineBorder);
      waterTemp.setBackground(Color.white);
      waterTempTitle.setFont(font2);
      p3.add(waterTempTitle, BorderLayout.NORTH);
      p3.add(waterTemp);

      screwSpeed.setBorder(lineBorder);
      screwSpeed.setBackground(Color.WHITE);
      screwSpeedTitle.setFont(font2);
      p4.add(screwSpeedTitle, BorderLayout.NORTH);
      p4.add(screwSpeed);

      coldWater.setBorder(lineBorder);
      coldWater.setBackground(Color.black);
      coldWaterTitle.setFont(font2);
      p5.add(coldWaterTitle, BorderLayout.NORTH);
      p5.add(coldWater);

      tempReduction.setBorder(lineBorder);
      tempReduction.setBackground(Color.white);
      tempReductionTitle.setFont(font2);
      p6.add(tempReductionTitle, BorderLayout.NORTH);
      p6.add(tempReduction);
      
      start.setBackground(Color.GREEN);
      start.setFont(font1);
      
      stop.setBackground(Color.RED);
      stop.setFont(font1);

      manual.setBackground(Color.LIGHT_GRAY);
      manual.setFont(font1);
      
      // Adds each of the buttons and the display panels to the outer panel.
      pOut.add(p1);
      pOut.add(p2);
      pOut.add(p3);
      pOut.add(p4);
      pOut.add(p5);
      pOut.add(p6);
      pOut.add(start);
      pOut.add(stop);
      pOut.add(manual);
      

      // Creating actionListeners for each of the three buttons on the screen
      stop.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            
         }
      });
      
      start.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            
         }
      });
      
      manual.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) {
            manualFrame.setLocationRelativeTo(null);
            manualFrame.setVisible(true);
         }
      });

      // sets the properties of the manual window.
      manualFrame.add(manualWindow);
      manualFrame.setMinimumSize(new Dimension(800,480));
      manualFrame.setMaximumSize(new Dimension(800, 480));
      manualFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
      manualFrame.setLocationRelativeTo(null);
      manualFrame.pack();
      manualFrame.setTitle("Manual Controls");

      //  sets the layout of the frame and adds the outer border panel
      setLayout(new GridLayout(1,1,10,10));
      add(pOut);
   }

   // Main function launches the screen.
   public static void main(String[] args) {
      // TODO code application logic here
      GUI frame = new GUI(/*"Eastman Screw Convayor"*/);
      frame.setMinimumSize(new Dimension(800,480));
      frame.setMaximumSize(new Dimension(800,480));
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
   }
}
