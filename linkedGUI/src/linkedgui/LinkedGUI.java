package linkedgui;

import java.awt.Dimension;
import java.awt.GridLayout;
//import java.awt.Font;
//import java.io.DataInputStream;
//import java.io.IOException;
//import java.net.ServerSocket;
//import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.border.*;

//import static linkedgui.MainWindow.python;

/**
 *
 * @author phillip
 */
public class LinkedGUI extends JFrame{

   public ManualWindow manualWindow = null;
   public MainWindow mainWindow = null;
   public Link link = null;
   
   public LinkedGUI (){
   
      mainWindow = new MainWindow(new GridLayout(3,3,5,5), this);
      manualWindow = new ManualWindow(this);
      setLayout(new GridLayout(1,1,10,10));
      setTitle("Easman Screw Convayor");

      this.add(mainWindow);
      
      setMinimumSize(new Dimension(800,480));
      setMaximumSize(new Dimension(800,480));
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pack();
      setVisible(true);
   }
   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable(){
         public void run() {
            LinkedGUI frame = new LinkedGUI();
         }
      });
   }
      
   void changePane(int arg) {
      
      if(arg == 1)
      {
         mainWindow.setVisible(false);
         remove(mainWindow);
         add(manualWindow);
         manualWindow.setVisible(true);
      }
      else
      {
         manualWindow.setVisible(false);
         remove(manualWindow);
         add(mainWindow);
         mainWindow.setVisible(true);
      }
   }
}
/*   
   System.out.print("hello\n");
   tempStart.setFont(new Font("tStart", Font.BOLD, 60 ));
   tempStart.setHorizontalAlignment(tempStart.CENTER);

      try{
         ServerSocket serverSocket = new ServerSocket(32415);
         Socket socket = serverSocket.accept();
         DataInputStream input = new DataInputStream(
                 socket.getInputStream());
         while(true){
            python = input.readLine();
            System.out.println(python);
            tempStart.setText(python);
         }
      }catch(IOException ex){
         System.err.println(ex);
      }
      
*/      
