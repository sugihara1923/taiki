import java.awt.*;
import java.awt.event.*;

class chapter10_5_3 {
    public static void main(String[] args) {
        MyWindowTA mw = new MyWindowTA();
    }
}

class MyWindowTA extends Frame {
    MyWindowTA() {
        setTitle("テキストエリアを配置する");
        setSize(600, 400);
        setLayout(new FlowLayout());
        TextArea ta = new TextArea(5,30);
        add(ta);
        setVisible(true);
        addWindowListener(new WindowListener());
    }

}

class WindowListener extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}