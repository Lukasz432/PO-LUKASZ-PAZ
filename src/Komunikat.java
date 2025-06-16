import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Komunikat extends Frame{
    private JPanel panel1;
    private JButton OKButton;
    private JLabel wiadomoscLabel;

    public Komunikat(String wiadomosc){
        super("Komunikat", 400,200);
        this.wiadomoscLabel.setText(wiadomosc);
        this.setContentPane(panel1);
        this.setVisible(true);

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }


}

