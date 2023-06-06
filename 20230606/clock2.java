import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
class Clock2 {
	public static void main(String[] args) {
		MyWindowClock2 mw = new MyWindowClock2();
		Thread th = new Thread(mw);
		th.start();
	}
}

class MyWindowClock2 extends Frame implements Runnable {
	Label la;
	MyWindowClock2() {
		setTitle("時計アプリ");
		setSize(280, 100);
		setLayout(null);
		la = new Label();
		la.setFont(new Font("Serif", Font.PLAIN, 32));
		la.setAlignment(Label.CENTER);
		la.setBounds(20, 36, 240, 50);
		add(la);
		setVisible(true);
		addWindowListener( new WinListener() );
	}

	public void run() {
		while(true) {
			String tim = DateFormat.getTimeInstance().format(new Date());
			la.setText(tim);
			try { Thread.sleep(1000); } catch(InterruptedException e) {}
		}
	}
}

class WinListener extends WindowAdapter {
	public void windowClosing(WindowEvent e) { System.exit(0); }
}
