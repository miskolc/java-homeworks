import java.net.*;

public class Adrese{
    public static void main(String args[]){
        try{
            System.out.println(InetAddress.getLocalHost());
        }
        catch(UnknownHostException e){
            System.out.println("Gazda nu are IP");
        }
    }
}
