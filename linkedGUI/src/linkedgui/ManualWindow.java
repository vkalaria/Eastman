package linkedgui;

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
public class ManualWindow extends JPanel{
   
   JLabel speed = new JLabel();
   JLabel cold = new JLabel();
   JLabel tap = new JLabel();


   public ManualWindow(LinkedGUI parent)
   {
      Border lineBorder = new LineBorder(Color.BLACK, 2);
      Font font1 = new Font("SansSerif", Font.BOLD, 16);
      Font font2 = new Font("SansSerif", Font.BOLD, 20);
      Font font3 = new Font("SansSerif", Font.BOLD, 24);
      Font manualFont = new Font("SansSerif", Font.BOLD, 60 );

      JPanel inner1 = new JPanel(new GridLayout(1,2));
      JPanel inner2 = new JPanel(new GridLayout(1,2));
      JPanel inner3 = new JPanel(new GridLayout(1,3));

      JPanel inner1_1 = new JPanel(new BorderLayout());
      JPanel inner1_1_1 = new JPanel(new BorderLayout());
      
      JPanel inner1_2 = new JPanel(new GridLayout(1,2));

      JPanel inner1_2_1 = new JPanel(new BorderLayout());
      JPanel inner1_2_1_1 = new JPanel(new BorderLayout());
      
      JPanel inner1_2_2 = new JPanel(new BorderLayout());
      JPanel inner1_2_2_1 = new JPanel(new BorderLayout());

      JPanel inner2_1 = new JPanel(new GridLayout(1,2));
      JPanel inner2_2 = new JPanel(new GridLayout(1,2));
      
      JPanel inner3_1 = new JPanel(new GridLayout(1,3));
      JPanel inner3_2 = new JPanel(new GridLayout(1,3));
      JPanel inner3_3 = new JPanel(new GridLayout(1,3));

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
      
      setLayout(new GridLayout(3,1));
      setBorder(new EmptyBorder(10, 10, 10, 10));
//      repaint();

      speedTitle.setFont(font1);
      coldWaterTitle.setFont(font1);
      tapWaterTitle.setFont(font1);
      
      speed.setBorder(lineBorder);
      speed.setFont(manualFont);
      speed.setHorizontalAlignment(speed.CENTER);
      cold.setBorder(lineBorder);
      cold.setFont(manualFont);
      cold.setHorizontalAlignment(cold.CENTER);
      tap.setBorder(lineBorder);
      tap.setFont(manualFont);
      tap.setHorizontalAlignment(tap.CENTER);

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
            parent.link.writeButtonPress("stop\n");
         }
      });
      
      start.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            parent.link.writeButtonPress("start\n");
            
         }
      });
      
      back.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) {
            parent.link.writeButtonPress("auto\n");
            parent.changePane(2);
         }
      });
      
      speedUp.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) {
            int currentSpeed = Integer.parseInt(speed.getText());
            if(currentSpeed <= 90)
            {
               currentSpeed += 10;
               speed.setText(Integer.toString(currentSpeed));
               parent.link.writeButtonPress("motor+\n");
            }
            
         }
      });
      
      slowDown.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) {
            int currentSpeed = Integer.parseInt(speed.getText());
            if(currentSpeed >= -90)
            {
               currentSpeed -= 10;
               speed.setText(Integer.toString(currentSpeed));
               parent.link.writeButtonPress("motor-\n");
            }
         }
      });
      
      coldPlus.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) {
            int currentCold = Integer.parseInt(cold.getText());
            if(currentCold <= 95)
            {
               currentCold += 5;
               tap.setText(Integer.toString(100 - currentCold));
               cold.setText(Integer.toString(currentCold));
               parent.link.writeButtonPress("cold+\n");
            }
         }
      });
      
      tapPlus.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) {
            int currentTap = Integer.parseInt(tap.getText());
            if(currentTap <= 95)
            {
               currentTap += 5;
               tap.setText(Integer.toString(currentTap));
               cold.setText(Integer.toString(100 - currentTap));
               parent.link.writeButtonPress("tap+\n");
            }
         }
      });
      
/*      JButton start = new JButton("START");
      JButton stop = new JButton("STOP");
      JButton back = new JButton("BACK");
      JButton speedUp = new JButton("SPEED +");
      JButton slowDown = new JButton("SPEED -");
      JButton coldPlus = new JButton("Cold +");
      JButton tapPlus = new JButton("Tap +");
*/
      inner1_1.add(speedTitle, BorderLayout.NORTH);
      inner1_1.add(inner1_1_1, BorderLayout.CENTER);
      inner1_1_1.setBackground(Color.WHITE);
      inner1_1_1.add(speed);
      
      inner1_2_1.add(coldWaterTitle, BorderLayout.NORTH);
      inner1_2_1.add(inner1_2_1_1, BorderLayout.CENTER);
      inner1_2_1_1.setBackground(Color.WHITE);
      inner1_2_1_1.add(cold);
      
      inner1_2_2.add(tapWaterTitle, BorderLayout.NORTH);
      inner1_2_2.add(inner1_2_2_1, BorderLayout.CENTER);
      inner1_2_2_1.setBackground(Color.WHITE);
      inner1_2_2_1.add(tap);
      
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
      
      inner3_1.add(start);
      inner3_2.add(stop);
      inner3_3.add(back);
      
      inner3.add(inner3_1);
      inner3.add(inner3_2);
      inner3.add(inner3_3);
      
      // top, left, bottom, right
      inner1_1.setBorder(new EmptyBorder(0, 0, 0, 5));
      inner1_2.setBorder(new EmptyBorder(0, 5, 0, 0));
      inner1_2_1.setBorder(new EmptyBorder(0, 0, 0, 1));
      inner1_2_2.setBorder(new EmptyBorder(0, 1, 0, 0));

      inner2_1.setBorder(new EmptyBorder(15, 0, 15, 5));
      inner2_2.setBorder(new EmptyBorder(15, 5, 15, 0));

      inner3_1.setBorder(new EmptyBorder(0,0,0,5));
      inner3_2.setBorder(new EmptyBorder(0,0,0,0));
      inner3_3.setBorder(new EmptyBorder(0,5,0,0));
      
      inner1.setBorder(new EmptyBorder(0, 0, 5, 0));
      inner2.setBorder(new EmptyBorder(5, 0, 5, 0));
      inner3.setBorder(new EmptyBorder(5, 0, 0, 0));

      
      add(inner1);
      add(inner2);
      add(inner3);

   }

   void setSpeed(String s)
   {
      speed.setText(s);
   }
   
   void setCold(String s)
   {
      cold.setText(s);
   }
   
   void setTap(String s)
   {
      tap.setText(s);
   }
}