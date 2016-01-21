package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rsr on 19/01/16.
 */
public class GUI extends JFrame {
    public GUI(){
        initUI();
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI m = new GUI();
                m.setVisible(true);
            }
        });
    }

    private void initUI() {
        setTitle("Flash Cards");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(new MainPanel());
    }
}
