/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

/*
 *
 * @author phillip
 */
public class GUI extends JFrame{
   public GUI(){
      
      JPanel pOut = new JPanel(new GridLayout(3,3,5,5));
      pOut.setBorder(new EmptyBorder(10, 10, 10, 10));
      
      JPanel p1 = new JPanel(new BorderLayout(5,5));
      JPanel p2 = new JPanel(new BorderLayout(5,5));
      JPanel p3 = new JPanel(new BorderLayout(5,5));
      JPanel p4 = new JPanel(new BorderLayout(5,5));
      JPanel p5 = new JPanel(new BorderLayout(5,5));
      JPanel p6 = new JPanel(new BorderLayout(5,5));
      
      Border lineBorder = new LineBorder(Color.BLACK, 2);
      Font font = new Font("SansSerif", Font.BOLD, 24);
      
      // Adding elements to the window
      JLabel tempStart = new JLabel();
      tempStart.setBorder(lineBorder);
      tempStart.setBackground(Color.white);
      p1.add(new JLabel("tempStart", JLabel.CENTER), BorderLayout.NORTH);
      p1.add(tempStart);
      
      JLabel tempEnd = new JLabel();
      tempEnd.setBorder(lineBorder);
      tempEnd.setBackground(Color.white);
      p2.add(new JLabel("tempEnd", JLabel.CENTER), BorderLayout.NORTH);
      p2.add(tempEnd);

      JLabel waterTemp = new JLabel();
      waterTemp.setBorder(lineBorder);
      waterTemp.setBackground(Color.white);
      p3.add(new JLabel("WaterTemp", JLabel.CENTER), BorderLayout.NORTH);
      p3.add(waterTemp);

      JLabel screwSpeed = new JLabel();
      screwSpeed.setBorder(lineBorder);
      screwSpeed.setBackground(Color.WHITE);
      p4.add(new JLabel("ScrewSpeed", JLabel.CENTER), BorderLayout.NORTH);
      p4.add(screwSpeed);

      JLabel coldWater = new JLabel();
      coldWater.setBorder(lineBorder);
      coldWater.setBackground(Color.black);
      p5.add(new JLabel("ColdWater%", JLabel.CENTER), BorderLayout.NORTH);
      p5.add(coldWater);

      JLabel tempReduction = new JLabel();
      tempReduction.setBorder(lineBorder);
      tempReduction.setBackground(Color.white);
      p6.add(new JLabel("TempReduction", JLabel.CENTER), BorderLayout.NORTH);
      p6.add(tempReduction);
      
      JButton start = new JButton("START");
      start.setBackground(Color.GREEN);
      start.setFont(font);
      start.setSize(50,50);
      start.setMaximumSize(new Dimension(20, 30));
      
      JButton stop = new JButton("STOP");
      stop.setBackground(Color.RED);
      stop.setFont(font);
//      stop.setPreferredSize(new Dimension(40, 40));
      stop.setMaximumSize(new Dimension(40, 40));

      JButton manual = new JButton("MANUAL");
      manual.setBackground(Color.LIGHT_GRAY);
      manual.setFont(font);
      
      pOut.add(p1);
      pOut.add(p2);
      pOut.add(p3);
      pOut.add(p4);
      pOut.add(p5);
      pOut.add(p6);
      pOut.add(start);
      pOut.add(stop);
      pOut.add(manual);

      setLayout(new GridLayout(1,1,10,10));
      add(pOut);
   }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GUI frame = new GUI(/*"Eastman Screw Convayor"*/);
//        frame.setSize(800, 480);
        frame.setMinimumSize(new Dimension(800,480));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
