import java.awt.Color;

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
        
        poly = Screen.polygonNum;
        Screen.drawablePolygon[Screen.polygonNum] = new PolygonObject(new double[]{},new double[]{},c); 
        updatePolygon();
    }

    void updatePolygon(){
        
        double dx = - 50 * Calculator.calculatePositionX(Screen.viewFrom, Screen.viewTo, Screen.viewTo[0], Screen.viewTo[1], Screen.viewTo[2]);
        double dy = - 50 * Calculator.calculatePositionY(Screen.viewFrom, Screen.viewTo, Screen.viewTo[0], Screen.viewTo[1], Screen.viewTo[2]);

        double[] newX = new double[x.length];
        double[] newY = new double[y.length];

        for(int i=0; i< x.length; i++){
            newX[i] = dx + MyFrame.screenSize.getWidth()/2 + 50 * Calculator.calculatePositionX(Screen.viewFrom, Screen.viewTo, x[i], y[i], z[i]);
            newY[i] = dy + MyFrame.screenSize.getHeight()/2 + 50 * Calculator.calculatePositionY(Screen.viewFrom, Screen.viewTo, x[i], y[i], z[i]);
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
        return Math.sqrt(Math.pow((Screen.viewFrom[0] - x[i]),2) + Math.pow((Screen.viewFrom[1] - y[i]),2) + Math.pow((Screen.viewFrom[2] - z[i]),2));
        
    }
}
