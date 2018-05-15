package PickGUI;

import java.awt.event.KeyEvent;

public class keyevent {
    public void keyTyped(KeyEvent e){
        System.out.println("inputlog");
        char key = e.getKeyChar();
        if (key ==KeyEvent.VK_J){
            System.out.println("a");
        }
    }
}
