import java.awt.*;
import java.awt.event.*;

class chapter10_8 {
    public static void main(String[] args) {
        MyWindowgazou mw = new MyWindowgazou();
    }
}

class MyWindowgazou extends Frame {
    Image img;
    MyWindowgazou() {
        img = getToolkit().getImage("yuusyagame.png");
        setTitle("画像の読込と表示");
        setSize(1000, 1000);
        setVisible(true);
        addWindowListener(new WindowListener());
    }
    public void paint(Graphics g){
        g.drawImage(img, 0, 0, this);
    }

}

class WindowListener extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}