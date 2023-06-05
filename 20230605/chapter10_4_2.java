import java.awt.*;
import java.awt.event.*;

class chapter10_4_2{
    public static void main(String[] args) {
        MyWindow2 mw = new MyWindow2();
    }
}

class MyWindow2 extends Frame implements ActionListener {
    Button btn1,btn2;
    MyWindow2() {
        setTitle("ボタンを配置する");
        setSize(600, 400);
        setLayout(new FlowLayout());
        btn1 = new Button("<<<ボタン1>>>");
        btn1.addActionListener(this);
        add(btn1);
        
        btn2 = new Button("<<<ボタン2>>>");
        btn2.addActionListener(this);
        add(btn2);
        setVisible(true);
        addWindowListener(new WindowListener());
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            btn1.setLabel("ボタン1をクリックした");
        }
        if (e.getSource() == btn2) {
            btn2.setLabel("ボタン2をクリックした");
        }
    }
}

class WindowListener extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}