import java.awt.*;
import java.awt.event.*;
class Chapter13_5 {
	public static void main(String[] args) {
		MyWindow13_5 mw = new MyWindow13_5();
	}
}

class MyWindow13_5 extends Frame implements ActionListener {
	TextArea ta;
	MenuItem mopen, msave;
	MyWindow13_5() {
		setTitle("テキストエディタ");
		setSize(800, 600);
		ta = new TextArea();
		add(ta);
		MenuBar mbar = new MenuBar();
		Menu menu = new Menu("ファイル");
		mopen = new MenuItem("開く");
		msave = new MenuItem("保存");
		mopen.addActionListener(this);
		msave.addActionListener(this);
		menu.add(mopen);
		menu.add(msave);
		mbar.add(menu);
		setMenuBar(mbar);
		setVisible(true);
		addWindowListener( new WinListener() );
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mopen) loadFile();
	}

	void loadFile() {
		FileDialog fd = new FileDialog(this, "Load", FileDialog.LOAD);
		fd.setVisible(true);
		String di = fd.getDirectory();
		String fi = fd.getFile();
		System.out.println("選択したディレクトリ " + di);
		System.out.println("選択したファイル " + fi);
	}
}

class WinListener extends WindowAdapter {
	public void windowClosing(WindowEvent e) { System.exit(0); }
}
