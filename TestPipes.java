
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dragos
 */

class Consumator extends Thread{
    DataInputStream in;

    public Consumator(DataInputStream in){
        this.in = in;
    }

    public void run(){
        int value = -1;
        for(int i=0;i<=1000;i++){
            try {
                value = in.readInt();
            } catch (IOException ex) {
                Logger.getLogger(Consumator.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Consumator received: "+ value);
        }
    }
}

class Producator extends Thread{
    DataOutputStream out;

    public Producator(DataOutputStream out){
        this.out = out;
    }

    public void run(){

        for(int i=0;i<=1000;i++){
            try {
                out.writeInt(i);
            } catch (IOException ex) {
                Logger.getLogger(Producator.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Producator wrote: "+i);
        }
    }
}

public class TestPipes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        PipedInputStream pipeIn = new PipedInputStream();
        PipedOutputStream pipeOut = new PipedOutputStream(pipeIn);

        DataInputStream in = new DataInputStream(pipeIn);
        DataOutputStream out = new DataOutputStream(pipeOut);

        Consumator c = new Consumator(in);
        Producator p = new Producator(out);

        p.start();
        c.start();

    }

}
