package macc;
import java.net.InetAddress;
import java.io.IOException;
import java.net.NetworkInterface;
import java.util.Enumeration;
public class macAddress  {
  public static void main(String[] args) throws IOException{ 
    InetAddress iad=InetAddress.getLocalHost();
    NetworkInterface nif=NetworkInterface.getByInetAddress(iad);
    byte[] mac=nif.getHardwareAddress();
 // Enumeration en= nif.getInetAddresses();
 // System.out.println(" "+en);
    for(int i=0;i<mac.length;i++){
      
    
    System.out.format("%02X%s",mac[i],(i<mac.length-1)?"-":"");}
  }
}
