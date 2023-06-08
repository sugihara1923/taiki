
import java.awt.*;
import java.awt.event.*;

class Chapter14_6_2 {
    public static void main(String[] args) {
        MyWindow14_6_2 mw = new MyWindow14_6_2();
        mw.addVehicle("コンパクトカー");
		mw.addVehicle("ワンボックス");
		mw.addVehicle("軽自動車");
		mw.addVehicle("ＳＵＶ");
		mw.addVehicle("セダン");
		mw.addVehicle("トラック");
		mw.repaint();
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

class MyWindow14_6_2 extends Frame {
	Vehicle[] veh = new Vehicle[5];
	MyWindow14_6_2() {
		setSize(600, 400);
		addWindowListener( new WinListener() );
		setVisible(true);
	}

	void addVehicle(String name) {
		int num = Vehicle.count;
		if(num < 5) {
			veh[num] = new Vehicle(name);
			System.out.println("オブジェクトを作りました " + name);
		}
		else {
			System.out.println("これ以上追加できません");
		}
	}

	public void paint(Graphics g) {
		g.setColor(Color.RED);
		for(int i=0; i<5; i++) g.drawString(veh[i].name, 50, 100+50*i);
	}
}

class WinListener extends WindowAdapter {
	public void windowClosing(WindowEvent e) { System.exit(0); }
}
