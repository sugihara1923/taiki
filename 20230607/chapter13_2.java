import java.awt.*;
import java.awt.event.*;
class Chapter13_2 {
	public static void main(String[] args) {
		MyWindow13_2 mw = new MyWindow13_2();
	}
}

class MyWindow13_2 extends Frame {
	MyWindow13_2() {
		setTitle("テキストエディタ");
		setSize(800, 600);
		TextArea ta = new TextArea();
		add(ta);
		MenuBar mbar = new MenuBar();
		Menu menu = new Menu("ファイル");
		mbar.add(menu);
		setMenuBar(mbar);
		setVisible(true);
		addWindowListener( new WinListener() );
	}
}

class WinListener extends WindowAdapter {
	public void windowClosing(WindowEvent e) { System.exit(0); }
}
