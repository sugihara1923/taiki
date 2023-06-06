import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
class Clock {
	public static void main(String[] args) {
		MyWindowClock mw = new MyWindowClock();
	}
}

class MyWindowClock extends Frame {
	MyWindowClock() {
		setTitle("時間の取得");
		setSize(280, 100);
		Label la = new Label();
		String tim = DateFormat.getTimeInstance().format(new Date());
		la.setText(tim);
		add(la);
		setVisible(true);
		addWindowListener( new WinListener() );
	}
}

class WinListener extends WindowAdapter {
	public void windowClosing(WindowEvent e) { System.exit(0); }
}
