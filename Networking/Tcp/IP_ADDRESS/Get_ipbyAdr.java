package chat;
import java.util.Scanner;
import java.net.InetAddress;
import java.io.IOException;

class Get_ipbyAdr{
  public static void main(String[] args)throws IOException {
    Scanner in=new Scanner(System.in);
    System.out.println("enter host address");
String host= in.next();
 InetAddress ia=InetAddress.getByName(host) ;
InetAddress locl=InetAddress.getLocalHost();
//System.out.println(locl.toString());
// System.out.print(ia.toString());
 System.out.println("\n "+ia.getHostAddress()+"\n "+ia.getHostName());
 in.close();  
  }
}
