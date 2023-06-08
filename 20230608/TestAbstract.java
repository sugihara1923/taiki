class TestAbstract {
	public static void main(String[] args) {
		Robot[] robo = new Robot[4];
		robo[0] = new HumanRobo("男性型アンドロイド");
		robo[1] = new HumanRobo("女性型アンドロイド");
		robo[2] = new AnimalRobo("猫ロボット");
		robo[3] = new AnimalRobo("犬ロボット");
		for(int i=0; i<robo.length; i++) robo[i].talk(i);
	}
}

abstract class Robot {
	String name;
	abstract void talk(int n);
}

class HumanRobo extends Robot {
	private int iq;
	HumanRobo(String name) {
		this.name = name;
		this.iq = 200;
	}
	public void talk(int num) {
		System.out.println("私はHumanRoboクラスから作られ、");
		System.out.println("配列番号" + num + "で管理された");
		System.out.println("IQ" + iq + "の" + name + "です。");
	}
}

class AnimalRobo extends Robot {
	AnimalRobo(String name) {
		this.name = name;
	}
	public void talk(int num) {
		System.out.println("ボクはAnimalRoboクラスから作られた" + name + "。");
		System.out.println("配列番号" + num + "で管理されているよ。");
	}
}
