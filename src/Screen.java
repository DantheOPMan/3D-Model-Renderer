import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Screen extends JPanel implements KeyListener{

    double sleepTime = 1000/30, lastRefresh = 0;
    static double[] viewFrom = new double[] {10,10,10};
    static double[] viewTo = new double[] {5,0,0};
    static int polygonNum = 0, polygon3DNum = 0;
    static PolygonObject[] drawablePolygon = new PolygonObject[100];
    static PolygonZ[] polygonZs = new PolygonZ[100];
    int[] newOrder;

    public Screen(){

        polygonZs[polygon3DNum] = new PolygonZ(new double[]{0, 2, 2, 0}, new double[]{0, 0, 2, 2}, new double[]{0, 0, 0, 0} , Color.gray);
        polygonZs[polygon3DNum] = new PolygonZ(new double[]{0, 2, 2, 0}, new double[]{0, 0, 2, 2}, new double[]{3, 3, 3, 3} , Color.gray);
        polygonZs[polygon3DNum] = new PolygonZ(new double[]{0, 2, 2, 0}, new double[]{0, 0, 0, 0}, new double[]{3, 3, 3, 3} , Color.gray);
        polygonZs[polygon3DNum] = new PolygonZ(new double[]{0, 2, 2, 0}, new double[]{2, 2, 2, 2}, new double[]{0, 0, 3, 3} , Color.gray);
        polygonZs[polygon3DNum] = new PolygonZ(new double[]{0, 0, 0, 0}, new double[]{0, 2, 2, 0}, new double[]{0, 0, 3, 3} , Color.gray);
        polygonZs[polygon3DNum] = new PolygonZ(new double[]{2, 2, 2, 2}, new double[]{0, 2, 2, 0}, new double[]{0, 0, 3, 3} , Color.gray);


        this.addKeyListener(this);
        this.setFocusable(true);

    }

    public void paint(Graphics g){

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

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            viewFrom[0]--;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            viewFrom[0]++;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            viewFrom[1]--;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            viewFrom[1]++;
        }
    }

    public void keyReleased(KeyEvent e) {
        
    }
    
}
