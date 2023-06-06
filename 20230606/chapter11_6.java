import java.awt.*;
import java.awt.event.*;

class chapter11_6 {
    public static void main(String[] args) {
        MyWindow1 mw = new MyWindow1();
        Thread th = new Thread(mw);
        th.start();
    }
}

class MyWindow1 extends Frame implements Runnable {
    int cx = 0;
    int cy = 120;

    MyWindow1() {
        setTitle("円を動かす");
        setSize(480, 240);
        setVisible(true);
        addWindowListener(new WinListener());
    }

    public void run() {
        while (true) {
            cx = cx + 2;
            if (cx > 480)
                cx = 0;
            repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 480, 240);
        g.setColor(Color.YELLOW);
        g.fillOval(cx - 30, cy - 30, 60, 60);
    }
}

class WinListener extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}
