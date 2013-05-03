import java.awt.*;


class Fonturi extends Canvas {
    private Font[] fonturi;
    Dimension canvasSize = new Dimension(400, 400);


    public Fonturi() {
        fonturi = GraphicsEnvironment.
                getLocalGraphicsEnvironment().getAllFonts();
        canvasSize.height = (1 + fonturi.length) * 20; 
        System.out.println("Inaltimea este: " + canvasSize.height);       
    }

    public void paint(Graphics g){
       
        String nume;
        for( int i=0;i<fonturi.length;i++) 
        {
            nume = fonturi[i].getFontName();
            g.setFont(new Font(nume,Font.PLAIN,14));
            g.drawString(i + ". " + nume,20,(i+1) * 20);
            System.out.println(i + ". " + nume);
        }
    }

    public Dimension getPreferredSize() {
        System.out.println("Data din getPreferredSize" + canvasSize.height);
        return canvasSize;
    }
}

class Fereastra extends Frame {
    public Fereastra(String titlu){
        super(titlu);
        ScrollPane sp = new ScrollPane();
        sp.setSize(400, 400);
        sp.add(new Fonturi());
        add(sp, BorderLayout.CENTER);
        pack();       
    }
}


public class TestAllFonts {
    public static void main(String args[]) {
        Fereastra f = new Fereastra("All Fonts");
        f.setVisible(true);
    }
}