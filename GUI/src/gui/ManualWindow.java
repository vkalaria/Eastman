/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author phillip
 */
public class ManualWindow extends JPanel {
   
   final private JPanel inner1 = new JPanel(new GridLayout(1,2));
   final private JPanel inner2 = new JPanel(new GridLayout(1,2));
   final private JPanel inner3 = new JPanel(new GridLayout(1,3));
   
   final private JPanel inner1_1 = new JPanel(new BorderLayout());
   final private JPanel inner1_2 = new JPanel(new GridLayout(1,2));

   final private JPanel inner1_2_1 = new JPanel(new BorderLayout());
   final private JPanel inner1_2_2 = new JPanel(new BorderLayout());
   
   final private JPanel inner2_1 = new JPanel(new GridLayout(1,2));
   final private JPanel inner2_2 = new JPanel(new GridLayout(1,2));

   public ManualWindow(final JFrame parent)
   {
      Border lineBorder = new LineBorder(Color.BLACK, 2);
      Font font1 = new Font("SansSerif", Font.BOLD, 16);
      Font font2 = new Font("SansSerif", Font.BOLD, 20);
      Font font3 = new Font("SansSerif", Font.BOLD, 24);

      JButton start = new JButton("START");
      JButton stop = new JButton("STOP");
      JButton back = new JButton("BACK");
      JButton speedUp = new JButton("SPEED +");
      JButton slowDown = new JButton("SPEED -");
      JButton coldPlus = new JButton("Cold +");
      JButton tapPlus = new JButton("Tap +");

      JLabel speedTitle = new JLabel("Motor Speed", JLabel.CENTER);
      JLabel coldWaterTitle = new JLabel("Cold Water", JLabel.CENTER);
      JLabel tapWaterTitle = new JLabel("Tap Water", JLabel.CENTER);
      
      JLabel speed = new JLabel();
      JLabel cold = new JLabel();
      JLabel tap = new JLabel();

      setLayout(new GridLayout(3,1));
      setBorder(new EmptyBorder(10, 10, 10, 10));
//      repaint();

      speedTitle.setFont(font1);
      coldWaterTitle.setFont(font1);
      tapWaterTitle.setFont(font1);
      
      speed.setBorder(lineBorder);
      cold.setBorder(lineBorder);
      tap.setBorder(lineBorder);

      speedUp.setFont(font2);
      slowDown.setFont(font2);
      coldPlus.setFont(font2);
      tapPlus.setFont(font2);

      start.setBackground(Color.GREEN);
      start.setFont(font3);
      
      stop.setBackground(Color.RED);
      stop.setFont(font3);

      back.setBackground(Color.LIGHT_GRAY);
      back.setFont(font3);

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
      
      back.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) {
            parent.setVisible(false);
         }
      });
      
      inner1_1.add(speedTitle, BorderLayout.NORTH);
      inner1_1.add(speed, BorderLayout.CENTER);
      
      inner1_2_1.add(coldWaterTitle, BorderLayout.NORTH);
      inner1_2_1.add(cold, BorderLayout.CENTER);
      
      inner1_2_2.add(tapWaterTitle, BorderLayout.NORTH);
      inner1_2_2.add(tap, BorderLayout.CENTER);
      
      inner1_2.add(inner1_2_1);
      inner1_2.add(inner1_2_2);
      
      inner1.add(inner1_1);
      inner1.add(inner1_2);
      
      inner2_1.add(speedUp);
      inner2_1.add(slowDown);
      
      inner2_2.add(coldPlus);
      inner2_2.add(tapPlus);
      
      inner2.add(inner2_1);
      inner2.add(inner2_2);
      
      inner3.add(start);
      inner3.add(stop);
      inner3.add(back);
      // top, left, bottom, right
      inner1_1.setBorder(new EmptyBorder(0, 0, 0, 5));
      inner1_2.setBorder(new EmptyBorder(0, 5, 0, 0));
      inner1_2_1.setBorder(new EmptyBorder(0, 0, 0, 1));
      inner1_2_2.setBorder(new EmptyBorder(0, 1, 0, 0));

      inner2_1.setBorder(new EmptyBorder(15, 0, 15, 5));
      inner2_2.setBorder(new EmptyBorder(15, 5, 15, 0));

      inner1.setBorder(new EmptyBorder(0, 0, 5, 0));
      inner2.setBorder(new EmptyBorder(5, 0, 5, 0));
      inner3.setBorder(new EmptyBorder(5, 0, 0, 0));

      
      add(inner1);
      add(inner2);
      add(inner3);

   }   
}
