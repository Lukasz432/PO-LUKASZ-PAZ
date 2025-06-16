import javax.swing.*;

public class Frame extends JFrame {

    Frame(String tytul, int x, int y){
        this.setTitle(tytul);
        this.setSize(x,y);
        this.setLocationRelativeTo(null);
    }

}