import java.awt.*;
import java.awt.event.*;
class MoveVehicle {
	public static void main(String[] args) {
		MyWindowR mw = new MyWindowR();
		mw.addVehicle("コンパクトカー", Color.CYAN, 50);
		mw.addVehicle("ワンボックス", Color.RED, 50);
		mw.addVehicle("軽自動車", Color.YELLOW, 40);
		mw.addVehicle("ＳＵＶ", Color.GRAY, 70);
		mw.addVehicle("セダン", Color.WHITE, 60);
		Thread th = new Thread(mw);
		th.start();
	}
}

class VehicleM {
	static int count;
	String name;
	Color col;
	double spd;
	double xpos, ypos;
	int dir;

	VehicleM(String name, Color col, double spd) {
		this.name = name;
		this.col = col;
		this.spd = spd;
		xpos = 60;
		ypos = 80+70*count;
		dir = 1;
		count++;
	}

	void move() {
		xpos = xpos + (dir*spd/10);
		if(xpos < 0) dir = 1;
		if(xpos > 600) dir = -1;
	}

	void draw(Graphics g) {
		g.setColor(col);
		g.fillOval((int)xpos-8, (int)ypos-8, 16, 16);
		g.drawString(name + " 速度" + spd, (int)xpos-30, (int)ypos-20);
	}
}

class MyWindowR extends Frame implements Runnable {
	final int VEHICLE_NUM = 5;
	VehicleM[] veh = new VehicleM[VEHICLE_NUM];
	MyWindowR() {
		setSize(600, 400);
		addWindowListener( new WinListener() );
		setVisible(true);
	}

	void addVehicle(String name, Color col, double spd) {
		int num = VehicleM.count;
		if(num < VEHICLE_NUM) {
			veh[num] = new VehicleM(name, col, spd);
			System.out.println("オブジェクトを作りました " + name);
		}
		else {
			System.out.println("これ以上追加できません");
		}
	}

	public void run() {
		while(true) {
			for(int i=0; i<VEHICLE_NUM; i++) if(veh[i] != null) veh[i].move();
			repaint();
			try{ Thread.sleep(200); } catch(Exception e) {}
		}
	}

	public void update(Graphics g) { paint(g); }

	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 600, 400);
		for(int i=0; i<VEHICLE_NUM; i++) if(veh[i] != null) veh[i].draw(g);
	}
}

class WinListener extends WindowAdapter {
	public void windowClosing(WindowEvent e) { System.exit(0); }
}
