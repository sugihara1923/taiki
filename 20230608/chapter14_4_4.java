
class chapter14_4_4 {
	public static void main(String[] args) {
		HumanTypeV2 ht = new HumanTypeV2("レダ", 200);
		ht.show();
		AnimalType at = new AnimalType("ミント", 100, "緑");
		at.show();
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

class HumanTypeV2 extends Robot {
	HumanTypeV2(String name, int iq) {
		this.name = name;
		this.iq = iq;
	}
	void show() {
		System.out.println("私は人間型ロボットの"+name);
		System.out.println("Robotクラスを拡張して作られました。");
		System.out.println("IQの値は"+iq+"です。");
	}
}

class AnimalType extends Robot {
	String color;
	AnimalType(String name, int iq, String color) {
		this.name = name;
		this.iq = iq;
		this.color = color;
	}
	void show() {
		System.out.println("ボクは動物型ロボットの"+name);
		System.out.println("IQは"+iq+"、色は"+color+"だよ。");
	}
}
