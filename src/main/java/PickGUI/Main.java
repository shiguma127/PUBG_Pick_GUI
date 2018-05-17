package PickGUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;


public class Main {
    public static void main(String[] args) {
        new Main();
        JFrame mainFrame = new JFrame("Picker");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(560, 280);
        mainFrame.setLocationRelativeTo(null);
        Container contentPane = mainFrame.getContentPane();
        JButton buttonE = new JButton("Erangel:島");
        JButton buttonM = new JButton("Miramar:砂漠");
        JButton buttonP = new JButton("ポチンキボタン");
        JButton buttonS = new JButton("スクショ");
        contentPane.add(buttonE, BorderLayout.EAST);
        contentPane.add(buttonM, BorderLayout.WEST);
        contentPane.add(buttonP, BorderLayout.CENTER);
        contentPane.add(buttonS, BorderLayout.SOUTH);
        mainFrame.setVisible(true);



//イベント
        buttonE.addActionListener(e -> {
            Erangel randame = Erangel.getRandom();
            JOptionPane.showMessageDialog(null, randame.getname() + " が選ばれました");
        });

        buttonM.addActionListener(e -> {
            Miramar randam = Miramar.getRundom();
            JOptionPane.showMessageDialog(null, randam.getname() + " が選ばれました");
        });

        buttonP.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "ポチンキ が選ばれました");

        });

        buttonS.addActionListener(e -> {
            thread sure = new thread();
            new Thread(sure).start();

        });


    }


    public static void screenshot(String formattype, String pathname) {


        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        BufferedImage image = robot.createScreenCapture(
                new Rectangle(0, 0, screenSize.width, screenSize.height));
        try {
            ImageIO.write(image, formattype, new File(pathname));
        } catch (IOException e) {
            e.printStackTrace();

        }


    }

    /*public static void getrgb(String filename) {
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int width = bi.getWidth();
        int hieght = bi.getHeight();

        int[] pixels = bi.getRGB(0, 0, width, hieght, null, 0, width);
        System.out.println(pixels);


    }*/

    public static final class thread implements Runnable{
        @Override
        public void run() {
            String filename = JOptionPane.showInputDialog(null, "ファイルネーム", "");
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
            }
            screenshot("PNG",filename+".png");
            JOptionPane.showMessageDialog(null,"Saved Screenshot:"+filename);



        }
    }


}
