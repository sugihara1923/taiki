import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class chapter10_9 {
    public static void main(String[] args) {
        MyWindowS mw = new MyWindowS();
    }
}

class MyWindowS extends JFrame implements ActionListener {
    JLabel label;
    JButton btn;

    MyWindowS() {
        setTitle("Swingのサンプルプログラム");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        label = new JLabel("文字列を表示させるラベルです");
        btn = new JButton("Swingのボタン");
        btn.addActionListener(this);
        add(label);
        add(btn);
        setVisible(true);
        addWindowListener(new WindowListener());
    }

    public void actionPerformed(ActionEvent e) {
        label.setText("ボタンをクリックしました");
    }

}
