import java.awt.*;
import java.awt.event.*;

class chapter10_5_1 {
    public static void main(String[] args) {
        MyWindowL mw = new MyWindowL();
    }
}

class MyWindowL extends Frame {
    MyWindowL() {
        setTitle("ラベルを配置する");
        setSize(600, 400);
        setLayout(new FlowLayout());
        Label la = new Label("初めてのラベル");
        la.setFont(new Font("Serif", Font.PLAIN, 32));
        la.setAlignment(Label.CENTER);
        la.setBackground(Color.gray);
        la.setForeground(Color.cyan);
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