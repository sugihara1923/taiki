import java.awt.*;
import java.awt.event.*;

class chapter10_2_3 {
    public static void main(String[] args) {
        Frame fr = new Frame();
        fr.setTitle("ウインドウの状態を知る");
        fr.setSize(600, 400);
        fr.setVisible(true);
        fr.addWindowListener(new WindowListener());
    }
}

class WindowListener extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        System.out.println("終了します");
        System.exit(0);
    }
    public void windowIconified(WindowEvent e){
        System.out.println("アイコン化されました");
    }
    public void windowActivated(WindowEvent e){
        System.out.println("アクティブ化されました");
    }
}
