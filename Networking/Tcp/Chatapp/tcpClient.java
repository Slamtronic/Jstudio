package chat1;
import java.net.InetAddress;import java.net.Socket;
import java.io.IOException;import java.util.Scanner;
import java.io.InputStream;import java.io.OutputStream;
import java.io.PrintWriter;
class Tcpclient {
  
private static int port=1234;private static String host;
private static Scanner userEntry;
public static void main(String[] args)
{   userEntry=  new Scanner(System.in) ;

  System.out.print(" enter host ip:"); 
   host=userEntry.nextLine();
  acceserver();
}
public static void acceserver(){
  Socket link=null;
 try{
   
   link=new Socket(host,port);
   Scanner input= new Scanner(link.getInputStream());
   PrintWriter output=new PrintWriter(link.getOutputStream(),true );
 // Scanner userEntry= new Scanner(System.in) ;
  String message,response;
 do { 
  System.out.print("enter ure message: ");
  message=userEntry.nextLine();
  System.out.println("MSG:"+message);
  response=userEntry.nextLine();
 System.out.println("RESP: "+response);
  
 } while(!message.equals("CLOSE")) ;
    
    
  
   
 } 
 catch(IOException e){   System.out.println("cant link") ;} 
 
 finally{
  System.out.println("closing....");
  try{
  link.close();
  
  }
  catch (IOException E){
    System.out.println("forcing disconnection");
   System.exit(1);
  }
   
 }
}
}