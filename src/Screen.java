import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Screen extends JPanel implements KeyListener{

    double sleepTime = 1000/30, lastRefresh = 0;
    static double[] viewFrom = new double[] {10,10,10};
    static double[] viewTo = new double[] {1,1,1.5};
    static int polygonNum = 0, polygon3DNum = 0;
    static PolygonObject[] drawablePolygon = new PolygonObject[100];
    static PolygonZ[] polygonZs = new PolygonZ[100];
    int[] newOrder;
    boolean[] keys = new boolean[8];

    public Screen(){

        polygonZs[polygon3DNum] = new PolygonZ(new double[]{0, 2, 2, 0}, new double[]{0, 0, 2, 2}, new double[]{0, 0, 0, 0} , Color.gray);
        polygonZs[polygon3DNum] = new PolygonZ(new double[]{0, 2, 2, 0}, new double[]{0, 0, 2, 2}, new double[]{3, 3, 3, 3} , Color.gray);
        polygonZs[polygon3DNum] = new PolygonZ(new double[]{0, 2, 2, 0}, new double[]{0, 0, 0, 0}, new double[]{0, 0, 3, 3} , Color.gray);
        polygonZs[polygon3DNum] = new PolygonZ(new double[]{0, 2, 2, 0}, new double[]{2, 2, 2, 2}, new double[]{0, 0, 3, 3} , Color.gray);
        polygonZs[polygon3DNum] = new PolygonZ(new double[]{0, 0, 0, 0}, new double[]{0, 2, 2, 0}, new double[]{0, 0, 3, 3} , Color.gray);
        polygonZs[polygon3DNum] = new PolygonZ(new double[]{2, 2, 2, 2}, new double[]{0, 2, 2, 0}, new double[]{0, 0, 3, 3} , Color.gray);

        for(int i = -4; i<5; i++){
            for(int j = -4; j<5; j++){
                polygonZs[polygon3DNum] = new PolygonZ(new double[]{i, i, i+1, i+1}, new double[]{j, j+1, j+1, j}, new double[]{0, 0, 0, 0} , Color.green); 
            }
        }

        this.addKeyListener(this);
        this.setFocusable(true);
    }

    public void paint(Graphics g){

        controls();

        g.clearRect(0, 0, 2000, 1200);
        g.drawString(System.currentTimeMillis()+ "", 20, 20);

        for(int i = 0; i<polygon3DNum; i++){
            polygonZs[i].updatePolygon();
        }
        
        setOrder();

        for(int i = 0; i<polygonNum; i++){
            drawablePolygon[newOrder[i]].drawPolygon(g);
        }

        sleepAndRefresh();
    }

    void setOrder(){

        double[] k = new double[polygonNum];
        newOrder = new int[polygonNum];
        for(int i =0; i<polygonNum; i++){
            k[i] = drawablePolygon[i].averageDistance;
            newOrder[i] = i;
        }

        double temp;
        int tempr;

        for(int a = 0; a < k.length-1; a++){
            for(int b= 0; b < k.length-1; b++){
                if(k[b] < k[b+1]){
                    temp = k[b];
                    tempr = newOrder[b];
                    newOrder[b] = newOrder[b+1];
                    k[b] = k[b+1];

                    newOrder[b+1] = tempr;
                    k[b+1] = temp;
                }
            }
        }
    }

    void sleepAndRefresh(){

        while(true){
            if(System.currentTimeMillis() - lastRefresh > sleepTime){
                lastRefresh = System.currentTimeMillis();
                repaint();
                break;
            }else{
                try{
                    Thread.sleep((long)(sleepTime - (System.currentTimeMillis() - lastRefresh)));
                }catch(Exception e){

                }
            }
        }

    }

    public void keyTyped(KeyEvent e) {
        
    }
    
    void controls(){
        
        Vector viewVector = new Vector(viewTo[0]- viewFrom[0], viewTo[1]- viewFrom[1], viewTo[2]- viewFrom[2]);

        if(keys[4]){
            viewFrom[0] += viewVector.x;
            viewFrom[1] += viewVector.y;
            viewFrom[2] += viewVector.z;
            viewTo[0] += viewVector.x;
            viewTo[1] += viewVector.y;
            viewTo[2] += viewVector.z;
        }
        if(keys[6]){
            viewFrom[0] -= viewVector.x;
            viewFrom[1] -= viewVector.y;
            viewFrom[2] -= viewVector.z;
            viewTo[0] -= viewVector.x;
            viewTo[1] -= viewVector.y;
            viewTo[2] -= viewVector.z;
        }

        Vector VerticalVector = new Vector(0, 0, 1);
		Vector SideViewVector = viewVector.crossProduct(VerticalVector);

        if(keys[5]){
            viewFrom[0] += SideViewVector.x;
            viewFrom[1] += SideViewVector.y;
            viewFrom[2] += SideViewVector.z;
            viewTo[0] += SideViewVector.x;
            viewTo[1] += SideViewVector.y;
            viewTo[2] += SideViewVector.z;
        }
        if(keys[7]){
            viewFrom[0] -= SideViewVector.x;
            viewFrom[1] -= SideViewVector.y;
            viewFrom[2] -= SideViewVector.z;
            viewTo[0] -= SideViewVector.x;
            viewTo[1] -= SideViewVector.y;
            viewTo[2] -= SideViewVector.z;
        }

    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            keys[0] = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            keys[1] = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            keys[2] = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            keys[3] = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_W){
            keys[4] = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            keys[5] = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            keys[6] = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            keys[7] = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            keys[0] = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            keys[1] = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            keys[2] = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            keys[3] = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_W){
            keys[4] = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            keys[5] = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            keys[6] = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            keys[7] = false;
        }
    }
    
}
