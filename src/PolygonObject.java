import java.awt.Color;
import java.awt.Polygon;  
import java.awt.Graphics;

public class PolygonObject {
    
    Polygon p;
    Color c;

    public PolygonObject(int[] x, int[] y, Color color){

        p = new Polygon();
        p.xpoints = x;
        p.ypoints = y;
        p.npoints = x.length;
        c = color;
        
    }

    public void drawPolygon(Graphics g){
        g.setColor(c);
        g.drawPolygon(p);
    }
}
