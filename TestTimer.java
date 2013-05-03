
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dragos
 */

class Atentie extends TimerTask {

    public void run(){
        Toolkit.getDefaultToolkit().beep();
        System.out.print(".");
    }

}


class Alarma extends TimerTask {
    String mesaj;

    public Alarma(String mesaj){
        this.mesaj = mesaj;
    }
    public void run(){
        System.out.println(mesaj);
    }
}

public class TestTimer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        final Timer t1 = new Timer();

        t1.schedule(new Atentie(), 0 , 1*1000);

        Timer t2 = new Timer();
        t2.schedule(new TimerTask(){
            public void run(){
                System.out.println("S-au scurs 10 secunde");
                t1.cancel();
            }
        },10*1000);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 2);
        calendar.set(Calendar.MINUTE,40);
        calendar.set(Calendar.SECOND,0);
        Date ora = calendar.getTime();


        Timer t3 = new Timer();
        t3.schedule(new Alarma("Toti copiii la culcare!"),ora);
    }

}
