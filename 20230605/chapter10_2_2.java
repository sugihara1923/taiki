import java.awt.*;
import java.awt.event.*;

class chapter10_2_2 {
    public static void main(String[] args) {
        Frame fr = new Frame();
        fr.setTitle("終了できるウインドウ");
        fr.setSize(600, 400);
        fr.setVisible(true);
        fr.addWindowListener(new WindowListener());
    }
}

class WindowListener extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}
