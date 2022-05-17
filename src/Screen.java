import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel{

    static double[] viewFrom = new double[] {10,10,10};
    static double[] viewTo = new double[] {5,0,0};
    static int polygonNum = 0;
    static PolygonObject[] drawablePolygon = new PolygonObject[100];

    PolygonZ polygonZ = new PolygonZ(new double[]{2, 4, 2}, new double[]{2, 4, 6}, new double[]{5, 5, 5} , Color.black);

    public Screen(){
                


    }

    public void paint(Graphics g){

        for(int i = 0; i<polygonNum; i++){
            drawablePolygon[i].drawPolygon(g);
            
        }

    }
    
}
