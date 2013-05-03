
class Buffer{
    private int number = -1;
    private boolean available = false;

    public synchronized int get(){
        if(!available){
            //wait while there's no new number available in the buffer
            try{
                wait();
            } catch(InterruptedException e) { 
                e.printStackTrace();
            }
        }

        //Read from the buffer

        available = false;
        notifyAll();
        return this.number;
    }

    public synchronized void put(int number){
        // available variable to be read from the buffer
        if(available){
            try {
                wait();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }

        // we put a number in the buffer    
        available = true;
        this.number = number;
        notifyAll();

    }

    // public int get(){
    //     return number;
    // }

    // public void put(int number){
    //     this.number = number;
    // }
}

class Producator extends Thread{
    private Buffer buffer;

    public Producator(Buffer buffer){
        this.buffer = buffer;
    }

    public void run(){
        for(int i = 0;i<=1000;i++){
            buffer.put(i);
            System.out.println("Sistemul a pus:\t"+ i);
            try {
                Thread.sleep((int) (Math.random() * 100));
            } catch(InterruptedException e) { }
        }
    }
}

class Consumator extends Thread{
    private Buffer buffer;

    public Consumator(Buffer buffer){
        this.buffer = buffer;
    }

    public void run(){
        int x = 0;
        for(int i=0;i<=1000;i++){
            x = buffer.get();
            System.out.println("Sistemul a primit:\t"+ x);
        }

    }
}

public class TestSincronizare2 {
    public static void main(String[] args){
        Buffer b = new Buffer();
        Producator p1 = new Producator(b);
        Consumator c1 = new Consumator(b);

        p1.start();
        c1.start();
    }
}