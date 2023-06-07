import java.awt.*;
import java.awt.event.*;
class Chapter13_1 {
	public static void main(String[] args) {
		MyWindow13_1 mw = new MyWindow13_1();
	}
}

class MyWindow13_1 extends Frame {
	MyWindow13_1() {
		setTitle("テキストエディタ");
		setSize(800, 600);
		TextArea ta = new TextArea();
		add(ta);
		setVisible(true);
		addWindowListener( new WinListener() );
	}
}

class WinListener extends WindowAdapter {
	public void windowClosing(WindowEvent e) { System.exit(0); }
}
