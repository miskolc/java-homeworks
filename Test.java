/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author dragos
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String host = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Host: ");
        host = sc.next();
        try {
            InetAddress ia = InetAddress.getByName(host);
            System.out.println(ia);
        }
        catch(UnknownHostException uhe) {
            System.out.println(uhe.toString());
        }

    }

}