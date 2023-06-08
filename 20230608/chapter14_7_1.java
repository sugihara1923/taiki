import java.awt.*;
import java.awt.event.*;
class Chapter14_7_1 {
	public static void main(String[] args) {
		MyWindowM mw = new MyWindowM();
		mw.addVehicle("コンパクトカー", Color.CYAN, 0);
		mw.addVehicle("ワンボックス", Color.RED, 0);
		mw.addVehicle("軽自動車", Color.YELLOW, 0);
		mw.addVehicle("ＳＵＶ", Color.GRAY, 0);
		mw.addVehicle("セダン", Color.WHITE, 0);
		mw.repaint();
	}
}

class Vehicle1 {
	static int count;
	String name;
	Color col;
	double spd;
	double xpos, ypos;

	Vehicle1(String name, Color col, double spd) {
		this.name = name;
		this.col = col;
		this.spd = spd;
		xpos = 60;
		ypos = 80+70*count;
		count++;
	}

	void draw(Graphics g) {
		g.setColor(col);
		g.fillOval((int)xpos-8, (int)ypos-8, 16, 16);
		g.drawString(name + " 速度" + spd, (int)xpos-30, (int)ypos-20);
	}
}

class MyWindowM extends Frame {
	final int VEHICLE_NUM = 5;
	Vehicle1[] veh = new Vehicle1[VEHICLE_NUM];
	MyWindowM() {
		setSize(600, 400);
		addWindowListener( new WinListener() );
		setVisible(true);
	}

	void addVehicle(String name, Color col, double spd) {
		int num = Vehicle.count;
		if(num < VEHICLE_NUM) {
			veh[num] = new Vehicle1(name, col, spd);
			System.out.println("オブジェクトを作りました " + name);
		}
		else {
			System.out.println("これ以上追加できません");
		}
	}

	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 600, 400);
		for(int i=0; i<VEHICLE_NUM; i++) if(veh[i] != null) veh[i].draw(g);
	}
}

class WinListener extends WindowAdapter {
	public void windowClosing(WindowEvent e) { System.exit(0); }
}
