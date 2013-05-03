//TestThread
//AfisareNumere

class AfisareNumere extends Thread {
    private int a, b, pas;

    public AfisareNumere(int a, int b, int pas) {
        this.a = a; 
        this.b = b;
        this.pas = pas;
    }

    public void run(){
        for( int i=a; i<=b; i+=pas){
            System.out.print(i + " ");
        }
    }
}

public class TestThread {
    public static void main(String args[]){
        AfisareNumere fir1, fir2;

        fir1 = new AfisareNumere(0,100,5);

        fir2 = new AfisareNumere(100,200,10);

        fir1.start();

        fir2.start();
    }
}