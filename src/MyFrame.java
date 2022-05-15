import java.awt.Toolkit;
import javax.swing.JFrame;

public class MyFrame extends JFrame{

    Screen screen = new Screen();

    public MyFrame(){
        this.setUndecorated(true);
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.add(screen);

        setVisible(true);
        

    }


}
