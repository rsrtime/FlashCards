package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.*;

/**
 * Created by rsr on 19/01/16.
 */
public class GUI extends JFrame {
    private MainPanel panel;

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
        Menu bar = new Menu();
        bar.addOpenActionListener(new OpenListener(this));
        setJMenuBar(bar);
    }

    private class OpenListener implements ActionListener{
        private JFrame context;
        public OpenListener(JFrame context){
            this.context = context;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory( new File( System.getProperty( "user.dir" ) ) );
            int rsp = fc.showOpenDialog(context);
            if (rsp == JFileChooser.APPROVE_OPTION){
                File selectedFile = fc.getSelectedFile();
                java.util.List<String> files = new ArrayList<>();
                files.add(selectedFile.getAbsolutePath());
                context.add(new MainPanel(files));
                context.revalidate();
            }
        }
    }
}
