import java.awt.*;
import java.awt.event.*;
class Main {
    public static void main(String[] args) {
        MyWindowz mw = new MyWindowz();
    }
}

class MyWindowz extends Frame {
    MyWindowz() {
        setTitle("キャンバスに図形を書く");
        setSize(600, 400);
        MyCanvas cvs = new MyCanvas();
        add(cvs);
        setVisible(true);
        addWindowListener(new WindowListener());
    }
}

class MyCanvas extends Canvas {
    public void paint(Graphics g) {
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, 600, 400);
        for(int i=0;i<360;i++){
            int x =290+(int)(120*Math.cos(Math.PI*i/180));
            int y =180+(int)(120*Math.sin(Math.PI*i/180));
            g.setColor(new Color(0, 255*(360-i)/360, 128+127*i/360));
            g.drawOval(x-40, y-40, 80, 80);
        }
    }
}

class WindowListener extends WindowAdapter{
    public void windowClosing(WindowEvent e){
        System.exit(0);
    }
}
