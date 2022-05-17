import java.awt.Color;
import java.awt.Polygon;

public class PolygonZ {

    double[] x,y,z;
    Color c;

    public PolygonZ(double[] x, double[] y, double[] z, Color c){

        this.x = x;
        this.y = y;
        this.z = z;
        this.c = c;
        createPolygon();
        
    }

    void createPolygon(){

        double[] newX = new double[x.length];
        double[] newY = new double[y.length];

        for(int i=0; i< x.length; i++){
            newX[i] = 200 * Calculator.calculatePositionX(Screen.viewFrom, Screen.viewTo, x[i], y[i], z[i]);
            newY[i] = 200 * Calculator.calculatePositionY(Screen.viewFrom, Screen.viewTo, x[i], y[i], z[i]);
        }
        Screen.drawablePolygon[Screen.polygonNum] = new PolygonObject(newX,newY,c);
        
    }
}
