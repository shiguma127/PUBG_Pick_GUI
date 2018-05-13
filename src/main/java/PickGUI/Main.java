package PickGUI;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main (String[] args){
        new Main();
        JFrame mainFrame = new JFrame("Picker");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(320, 160);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        Container contentPane = mainFrame.getContentPane();
        JButton buttonE = new JButton("PickGUI.Erangel:島");
        JButton buttonM = new JButton("PickGUI.Miramar:砂漠");
        contentPane.add(buttonE,BorderLayout.EAST);
        contentPane.add(buttonM,BorderLayout.WEST);

//イベント
        buttonE.addActionListener(e -> {
            Erangel randame = Erangel.getRandom();
            JOptionPane.showMessageDialog(null, randame.getname()+" が選ばれました");
        });

        buttonM.addActionListener(e -> {
            Miramar randam = Miramar.getRundom();
            JOptionPane.showMessageDialog(null, randam.getname()+" が選ばれました");
        });


    }
}
