
import java.awt.*;
import java.awt.event.*;

class Chapter14_6_1 {
    public static void main(String[] args) {
        MyWindow14_6_1 mw = new MyWindow14_6_1();
    }
}

class Vehicle {
    static int count;
    String name;

    Vehicle(String name) {
        this.name = name;
        count++;
    }
}

class MyWindow14_6_1 extends Frame {
    Vehicle veh;

    MyWindow14_6_1() {
        veh = new Vehicle("コンパクトカー");
        setSize(600, 400);
        addWindowListener(new WinListener());
        setVisible(true);
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawString(veh.name, 50, 100);
    }
}

class WinListener extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}
