import java.awt.*;
import java.awt.event.*;

class chapter10_6 {
    public static void main(String[] args) {
        MyWindowGUI mw = new MyWindowGUI();
    }
}

class MyWindowGUI extends Frame {
    MyWindowGUI() {
        setTitle("自由なレイアウト");
        setSize(600, 400);
        setLayout(null);
        Button btn1 = new Button("ボタン1");
        btn1.setBounds(50, 50, 200, 100);
        add(btn1);
        Button btn2 = new Button("ボタン2");
        btn2.setBounds(450, 50, 100, 300);
        add(btn2);
        Label la = new Label("ラベル");
        la.setBackground(Color.black);
        la.setForeground(Color.white);
        la.setBounds(50, 300, 300, 50);
        add(la);
        setVisible(true);
        addWindowListener(new WindowListener());
    }

}

class WindowListener extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}