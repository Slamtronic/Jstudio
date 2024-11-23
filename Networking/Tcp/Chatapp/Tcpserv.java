package chat;
import java.net.ServerSocket;import java.net.Socket;
import java.io.IOException;import java.util.Scanner;
import java.io.InputStream;
import java.io.PrintWriter;
class Tcpserv {
  
private static int port=1234;private static ServerSocket servsoc;




  public static void main(String[] args) {
    System.out.println("connecting......");
    try{
servsoc=new ServerSocket(port);     
    }
 catch (IOException e) {
  System.out.println("cant connect to port: "+port+"\ndetails: "+e);
  System.exit(1);
 System.out.println("DISCONNECTED");
 } 
 do 
 handleClient();
 while (true ) ;
  }
  
  public static void  handleClient(){
    Socket link=null;
  try {
    link=servsoc.accept();
    Scanner input=new Scanner(link.getInputStream());
 PrintWriter output=new PrintWriter(link.getOutputStream(),true);
 
 int numMSG=0;
 String message=input.nextLine();
 while (!message.equals("CLOSE")){
  System.out.println("message reception..");
  numMSG++;
 System.out.println("MES: "+numMSG+" "+message);
   message=input.nextLine();
 }
System.out.println("messages receeved: "+numMSG);
 
  }  
  catch(IOException e){
    
  } 
  finally {
   
   try{ System.out.println("closing connection....");
     
     link.close();}
   catch(IOException e){
    System.out.println("cant disconnect");
    System.exit(1);
   }
  }
    
  }
}
