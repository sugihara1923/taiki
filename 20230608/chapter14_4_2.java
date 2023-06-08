
class chapter14_4_2 {
	public static void main(String[] args) {
		HumanType ht = new HumanType("レダ", 100);
		ht.show();
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

class HumanType extends Robot {
	HumanType(String name, int iq) {
		this.name = name;
		this.iq = iq;
	}
}
