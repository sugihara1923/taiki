import java.awt.*;
import java.awt.event.*;

class chapter10_3_1 {
    public static void main(String[] args) {
        MyWindow mw = new MyWindow();
    }
}

class MyWindow extends Frame {
    MyWindow() {
        setTitle("ウィンドウを別のクラスにする");
        setSize(600, 400);
        setVisible(true);
        addWindowListener(new WindowListener());
    }
    public void windowClosing(WindowEvent e){
        System.exit(0);
    }
}
