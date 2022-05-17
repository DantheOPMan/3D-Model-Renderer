import java.awt.Color;
import java.awt.Polygon;

public class PolygonZ {

    double[] x,y,z;
    int poly = 0;
    Color c;

    public PolygonZ(double[] x, double[] y, double[] z, Color c){

        Screen.polygon3DNum++;
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
            newX[i] = 500 + 50 * Calculator.calculatePositionX(Screen.viewFrom, Screen.viewTo, x[i], y[i], z[i]);
            newY[i] = 500 + 50 * Calculator.calculatePositionY(Screen.viewFrom, Screen.viewTo, x[i], y[i], z[i]);
        }
        poly = Screen.polygonNum;
        Screen.drawablePolygon[Screen.polygonNum] = new PolygonObject(newX,newY,c);
        Screen.drawablePolygon[poly].averageDistance = getDistance();
        
    }

    void updatePolygon(){
        
        double[] newX = new double[x.length];
        double[] newY = new double[y.length];

        for(int i=0; i< x.length; i++){
            newX[i] = 500 + 50 * Calculator.calculatePositionX(Screen.viewFrom, Screen.viewTo, x[i], y[i], z[i]);
            newY[i] = 500 + 50 * Calculator.calculatePositionY(Screen.viewFrom, Screen.viewTo, x[i], y[i], z[i]);
        }
        Screen.drawablePolygon[poly] = new PolygonObject(newX,newY,c);      
        Screen.drawablePolygon[poly].averageDistance = getDistance();
        Screen.polygonNum--;
    }

    double getDistance(){
        double total = 0;
        for(int i =0; i <x.length; i++){
            total += getDistanceToP(i);
        }
        return total / x.length;
    }

    double getDistanceToP(int i){
        return Math.sqrt(Math.pow(Screen.viewFrom[0] - x[i],2) + Math.pow(Screen.viewFrom[1] - y[i],2) + Math.pow(Screen.viewFrom[2] - z[i],2));
        
    }
}
