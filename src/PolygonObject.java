import java.awt.Color;
import java.awt.Polygon;  
import java.awt.Graphics;

public class PolygonObject {
    
    Polygon p;
    Color c;

    public PolygonObject(double[] x, double[] y, Color color){

        Screen.polygonNum++;
        p = new Polygon();
        for( int i = 0; i<x.length; i++){
            p.addPoint((int) x[i], (int)y[i]);
        }
        c = color;
        
    }

    public void drawPolygon(Graphics g){
        g.setColor(c);
        g.fillPolygon(p);
    }
}
