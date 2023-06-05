import java.awt.*;
import java.awt.event.*;

class chapter10_5_2 {
    public static void main(String[] args) {
        MyWindowTF mw = new MyWindowTF();
    }
}

class MyWindowTF extends Frame {
    MyWindowTF() {
        setTitle("テキストフィールドを配置する");
        setSize(600, 400);
        setLayout(new FlowLayout());
        TextField tf = new TextField(20);
        add(tf);
        setVisible(true);
        addWindowListener(new WindowListener());
    }

}

class WindowListener extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}