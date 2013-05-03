import java.awt.*;
import java.awt.event.*;

class Plansa extends Canvas {
    Dimension dim = new Dimension(100, 100);
    private Color color[] = {Color.red, Color.blue};
    private int index = 0;

    public Plansa(){
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                index = 1 - index;
                repaint();  

//
 
             //Ce S-AR INTAMPLA FARA REPAINT?
                //cum cominica functiile astea?

                //
            }
        });
    }


    public void paint(Graphics g) {
        g.setColor(color[index]);

        // de unde porneste 0,0 = stanga sus... si lungimi
        g.drawRect(50,0,dim.width, dim.height);
        g.setColor(color[1-index]);
        g.fillOval(0,0,dim.width, dim.height);   
    }

    public Dimension getPrefferedSize(){
        return dim;
    }
}

class Fereastra extends Frame {
    public Fereastra(String titlu) {
        super(titlu);
        setSize(200,200);
        add(new Plansa(), BorderLayout.CENTER);
    }
}

public class TestCanvas {
    public static void main(String args[]){
        Fereastra f = new Fereastra("Test Canvas");
        f.setVisible(true);
    }
}