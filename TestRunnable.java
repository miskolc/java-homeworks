import java.awt.*;
import java.awt.event.*;

class Plansa extends Canvas implements Runnable{
    Dimension dim = new Dimension(300,300);
    Color culoare;
    String figura;
    int x=0, y=0, r=0;

    public Plansa(String figura, Color culoare){
        this.figura = figura;
        this.culoare = culoare;
    }

    public void paint(Graphics g){
        //Desenam un chenar
        g.setColor(Color.black);
        g.drawRect(0,0,dim.width-1,dim.height-1);
        //Desenam figura la coordonatele
        g.setColor(culoare);
        if( figura.equals("patrat") )
            g.drawRect(x,y,r,r);
        if( figura.equals("cerc") )
            g.drawOval(x,y,r,r);


    }

    public void update(Graphics g){
        paint(g);
    }

    public Dimension getPrefferedSize(){
        return dim;
    }

    public void run(){
        for( int i=0; i<100; i++){
            x = (int)(Math.random() * dim.width);
            y = (int)(Math.random() * dim.height);
            r = (int)(Math.random() * 100);

            try {
                Thread.sleep(50);
            } catch(InterruptedException e){ }
            repaint();
        }
    }
}

class Fereastra extends Frame{
    public Fereastra(String titlu){
        super(titlu);
        setSize(600,300);
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });  // Ca sa inchida fereastra?
        
        // Cream doua obiecte de tip Plansa
        Plansa p1 = new Plansa("patrat", Color.blue);
        Plansa p2 = new Plansa("cerc",   Color.red);

        // Acestea extind Canvas, le plasam pe fereastrastra
        setLayout(new GridLayout(1,2));
        add(p1);
        add(p2);
        pack();

        // Pornim 2 fire de executie care vor actualiza
        // desenul celor 2 planse
        new Thread(p1).start();
        new Thread(p2).start();  

    }
}

public class TestRunnable{
    public static void main(String args[]){
        Fereastra f = new Fereastra("Test Runnable");
        f.setVisible(true);
    }
}