import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel{

    int[] viewFrom = new int[] {10,10,10};
    int[] viewTo = new int[] {0,0,0};

    PolygonObject Poly1;
    public Screen(){

        Poly1 = new PolygonObject(new int[]{10, 200, 10}, new int[]{10, 200, 400} , Color.black);

    }

    public void paint(Graphics g){

        Poly1.drawPolygon(g);

    }
    
}
