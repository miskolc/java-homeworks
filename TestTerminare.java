import java.io.*;

class NumaraSecunde extends Thread {
    public float sec = 0;
    public boolean executie = true;
    private int x;
    public NumaraSecunde(int x){
        this.x = x;
    }
    public void run()
    {
        while(executie){
            try{
                Thread.sleep(1);
                sec += 0.001;
                //System.out.print(x);
            } catch(InterruptedException e) {}
        }
    }
}

class AfiseazaUnu extends Thread {
    public boolean executie = true;
    private int x=0;

    public void run(){
        while(executie){
            //System.out.print("X");
            // x++;
            // if(x == 10000000){
            //     x = x%1000000;
            //     System.out.print("X");
            // }
        }
    }
}

public class TestTerminare {
    public static void main(String args[])
        throws IOException {
            NumaraSecunde[] fir = new NumaraSecunde[8];
            AfiseazaUnu au = new AfiseazaUnu();

            for(int i=0;i<=7;i++){
                fir[i] = new NumaraSecunde(i);
            }
            for(int i=0;i<=5;i++){
                System.out.println("On noua linie"+ i + " "+ fir[i].sec);
            }

            au.start();
            
            for(int i=0;i<=7;i++){
               fir[i].start();
            }
            System.out.println("Apasati tasta Enter");
            System.in.read();


            // //Oprim firul de executie 
            for(int i=0;i<=7;i++){
                fir[i].executie = false;
            }
            au.executie = false;

            for(int i=0;i<=7;i++){
                System.out.println("S-au scurs: "+fir[i].sec+" secunde");
            }
        }       

}

// Apasati tasta Enter

// S-au scurs: 5.699997 secunde
// S-au scurs: 5.699997 secunde
// S-au scurs: 5.699997 secunde
// S-au scurs: 5.699997 secunde
// S-au scurs: 5.699997 secunde
// S-au scurs: 5.699997 secunde
// S-au scurs: 5.699997 secunde
// S-au scurs: 5.699997 secunde
