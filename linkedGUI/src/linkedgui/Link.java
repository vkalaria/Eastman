package linkedgui;

import java.io.*;
import java.net.*;

/**
 *
 * @author phillip
 */
public class Link implements Runnable{
   
   ServerSocket serverSocket = null;
   Socket socket = null;
   DataInputStream input = null;
   DataOutputStream output = null;
   ManualWindow manual = null;
   MainWindow main = null;
   PrintWriter out = null;
   
   public Link(MainWindow m, ManualWindow man)
   {
      manual = man;
      main = m;
      try{
         serverSocket = new ServerSocket(32415);
      }catch(IOException ex){
         System.err.println(ex);
      }
   }
   
   public void run()
   {
      String python = null;
      
      try{
         socket = serverSocket.accept();
         input = new DataInputStream(socket.getInputStream());
         output = new DataOutputStream(socket.getOutputStream());
         out = new PrintWriter(output);
         
         while(true)
         {
            python = input.readLine();
            parse(python);
         }
      }catch(IOException ex){
         System.err.println(ex);
      }
   }
  
   public void parse(String s)
   {
      int i;
      String[] tokens = s.split(",");
      String[] key_value;
      
      for(i=0; i< tokens.length; i++)
      {
         key_value = tokens[i].split(":");
         switch (key_value[0]) {
            case "tempStart":
               main.setTempStart(key_value[1]);
               break;
            case "tempEnd":
               main.setTempEnd(key_value[1]);
               break;
            case "WaterTemp":
               main.setWaterTemp(key_value[1]);
               break;
            case "speed":
               manual.setSpeed(key_value[1]);
               main.setScrewSpeed(key_value[1]);
               break;
            case "coldWater":
               main.setColdWater(key_value[1]);
               manual.setCold(key_value[1]);
               manual.setTap(findTap(key_value[1]));
               break;
            case "tempReduction":
               main.setTempReduction(key_value[1]);
               break;
            default:
         }         
      }
      
      System.out.println(s);

   }
   
   public void writeButtonPress(String s)
   {
      try{
         output.writeBytes(s);
         output.flush();
      }catch(IOException ex){
         System.err.println(ex);
      }

//      out.print(s);

   }
   
   public String findTap(String s)
   {
      int cold;
      int tap;
      
      cold = Integer.parseInt(s);
      tap = 100 - cold;
      
      return Integer.toString(tap);
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