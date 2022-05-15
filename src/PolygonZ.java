import java.awt.Color;
import java.awt.Polygon;  
import java.awt.Graphics;

public class PolygonZ {

    int[] x;
    int[] y;
    int[] z;
    Color c;

    public PolygonZ(int[] x, int[] y, int[] z, Color c){

        this.x = x;
        this.y = y;
        this.z = z;
        this.c = c;
        
    }

    public void drawPolygon(Graphics g){
        
        g.setColor(c);
        
    }
}
