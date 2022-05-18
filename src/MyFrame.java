import java.awt.Toolkit;
import javax.swing.JFrame;
import java.awt.Dimension;


public class MyFrame extends JFrame {
    
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Screen screen = new Screen();

    public MyFrame(){

        this.add(screen);
        
        this.setUndecorated(true);
        this.setSize(screenSize);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(true);
        

    }

}
