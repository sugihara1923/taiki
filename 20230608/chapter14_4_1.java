
class chapter14_4_1 {
	public static void main(String[] args) {
		Robot rbt = new Robot();
		rbt.name = "試作ロボット";
		rbt.iq = 75;
		rbt.show();
	}
}

class Robot {
	String name;
	int iq;
	void show() {
		System.out.println("NAME "+name);
		System.out.println("IQ "+iq);
	}
}

