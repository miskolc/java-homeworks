

class FirEgoist extends Thread{

    public FirEgoist(String name){
        super(name);
    }

    public void run(){
        int i = 0;
        while(i<100000){
            i++;
            if(i%100 == 0)
                System.out.println(getName() + " a ajuns la pasul: " + i);
            yield();
        }
    }
}


public class TestFirEgoist{
    public static void main(String args[]){
        FirEgoist s1, s2;
        s1 = new FirEgoist("Firul 1");
        s1.setPriority(Thread.MAX_PRIORITY);
        s2 = new FirEgoist("Firul 2");
        s2.setPriority(Thread.MAX_PRIORITY);

        s1.start();
        s2.start();
    }
}