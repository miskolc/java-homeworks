import java.awt.*;

class Fereastra extends Frame {
    public Fereastra(String titlu){
        super(titlu);
        setSize(200,100);
    }

    public void paint(Graphics g){
        //Apelam metoda paint a clase

        super.paint(g);
        g.setFont(new Font("Arial", Font.BOLD, 11));
        g.setColor(Color.red);
        g.drawString("Aplicatie DEMO", 5, 35);
    }

}

public class TestPaint {
    public static void main(String args[]){
        Fereastra f = new Fereastra("Test paint");
        f.setVisible(true);
    }
}