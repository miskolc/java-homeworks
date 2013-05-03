import java.awt.*;

class Texte extends Canvas {
    Dimension canvasSize = new Dimension(800, 100);
    private String[] zile = {
        "Luni", "Marti", "Miercuri", "Joi",
        "Vineri", "Sambata", "Duminica" };
    private String[] luni = {
        "Ianuarie", "Februarie", "Martie", "Aprilie",
        "Mai", "Iunie", "Iulie", "August", "Septembrie",
        "Octombrie", "Noiembrie", "Decembrie" };    

    public void paint(Graphics g){
        FontMetrics fm;
        int x,y;
        String etZile = "Zilele saptamanii: ",
               etLuni = "Lunile anului:", text;

        // Alegem un font si aflam metrica sa
        
        g.setFont(new Font("Arial", Font.BOLD, 20));
        fm = g.getFontMetrics();
        x = 0;
        y = fm.getHeight();

        g.drawString(etZile, x, y);
        x += fm.stringWidth(etZile);

        for( int i=0; i< zile.length; i++ ){
            text = zile[i];
            if( i < zile.length - 1)
                text += ", ";
            else 
                text += ".";
            g.drawString(text, x, y);
            x += fm.stringWidth(text);
        } 

        //Cu alt font :
     
        g.setFont(new Font("Dialog", Font.PLAIN, 14));
        fm = g.getFontMetrics(); 
        x = 0;
        y += fm.getHeight();

        g.drawString(etLuni,x,y);
        x += fm.stringWidth(etLuni);

        for( int i=0; i< luni.length; i++){
            text = zile[i];
            if( i < luni.length -1 )
                text += ", ";
            else 
                text += ".";
            g.drawString(text,x,y);
            x += fm.stringWidth(text);
        }      

    } 
    public Dimension getPreferredSize(){
        return canvasSize;
    }    
}

class Fereastra extends Frame{
    public Fereastra(String titlu){
        super(titlu);
        add(new Texte(), BorderLayout.CENTER);
        pack();
    }
}

public class TestFontMetrics {
    public static void main(String args[]){
        Fereastra f = new Fereastra("FontMetrics");
        f.setVisible(true);
    }
}