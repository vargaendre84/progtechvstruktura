import Intezmenyek.Allamkincstar;
import Intezmenyek.Jegybank;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Megjelenito extends JFrame {
    private JPanel mainPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton getInfoButton;
    private JButton eraseButton;
    private JButton kincstarButton;
    private JButton bankButton;
    private JLabel label1;

    public Megjelenito(String adat) {
        super(adat);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        final Jegybank jegybank = Jegybank.getInstance();
        final Allamkincstar allamkincstar = Allamkincstar.getInstance();

        kincstarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ;
            }
        });
        bankButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ;
            }
        });
        getInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        eraseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                label1.setText("");
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");

            }
        });
    }

   /* public static void main(String[] args) {
        JFrame frame = new Megjelenito("Állampapír nyilvántartó");
        frame.setVisible(true);
        frame.setSize(600,600);
    }
*/
}

