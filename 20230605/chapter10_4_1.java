import java.awt.*;
import java.awt.event.*;

class chapter10_4_1 {
    public static void main(String[] args) {
        MyWindow mw = new MyWindow();
    }
}

class MyWindow extends Frame {
    MyWindow() {
        setTitle("ボタンを配置する");
        setSize(600, 400);
        setLayout(new FlowLayout());
        Button btn = new Button();
        add(btn);
        btn.setLabel("初めてのボタン");
        setVisible(true);
        addWindowListener(new WindowListener());
    }
}

class WindowListener extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}