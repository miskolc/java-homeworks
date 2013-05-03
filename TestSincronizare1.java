


class Buffer {
    private int number = -1;

    public int get(){
        return number;
    }

    public void put(int number){
        this.number = number;
    }
}

class Producator extends Thread {
    private Buffer buffer;

    public Producator( Buffer buffer ){
        this.buffer = buffer;
    } 

    public void run(){
        for( int i=0;i<=1000;i++){
            buffer.put(i);
            System.out.println("Producatorul a pus: \t" + i);
            try {
                sleep((int) (Math.random() * 100));
            } catch(InterruptedException e){ }
        }
    }

}

class Consumator extends Thread {
    private Buffer buffer;

    public Consumator( Buffer buffer ){
        this.buffer = buffer;
    }

    public void run(){
        int value = 0;
        for( int i=0;i<=1000;i++){
            value = buffer.get();
            System.out.println("Consumatorul a primit: \t" + value);
            // //Codul de jos nu exista in carte dar face sa aiba loc mai multe matchuieli, pentru ca
            // // in codul din carte, atunci cand producatorul doarme, se executa cam toate run-urile 
            // // pentru Consumator
            // try {
            //     sleep((int) (Math.random() * 100));
            // } catch(InterruptedException e){ }
        }
    }
}

public class TestSincronizare1 {
    public static void main(String args[]) {
        Buffer b = new Buffer();
        Producator p1 = new Producator(b);
        Consumator c1 = new Consumator(b);
        p1.start();
        c1.start();

    }
}