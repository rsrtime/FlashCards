package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by rsr on 23/01/16.
 */
public class Menu extends JMenuBar{
    private JMenuItem openItem;
    public Menu(){
        JMenu file = new JMenu("File");
        openItem = createOpenItem();
        file.add(openItem);
        file.add(createExitItem());
        add(file);
    }

    public void addOpenActionListener(ActionListener listener){
        openItem.addActionListener(listener);
    }

    private JMenuItem createOpenItem(){
        JMenuItem openItem = new JMenuItem("Open");
        return openItem;
    }

    private JMenuItem createExitItem() {
        JMenuItem eMenuItem = new JMenuItem("Exit", new ImageIcon("exit.png"));
        eMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        eMenuItem.setToolTipText("Exit application");
        return eMenuItem;
    }
}
