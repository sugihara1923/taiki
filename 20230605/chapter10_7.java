import java.awt.*;
import java.awt.event.*;

class chapter10_7 {
    public static void main(String[] args) {
        MyWindowzukkei mw = new MyWindowzukkei();
    }
}

class MyWindowzukkei extends Frame {
    MyWindowzukkei() {
        setTitle("図形を描く");
        setSize(600, 400);
        setVisible(true);
        addWindowListener(new WindowListener());
    }
    public void paint(Graphics g){
        g.setColor(Color.green);
        g.drawLine(20, 40, 240, 160);
        g.setColor(Color.blue);
        g.fillRect(20, 200, 280, 100);
        g.setColor(Color.MAGENTA);
        g.drawOval(320, 50, 240, 320);
    }

}

class WindowListener extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}