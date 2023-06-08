class Chapter14_3_1 {
	public static void main(String[] args) {
		Origami kami = new Origami();
		kami.katachi = "鶴";
		kami.iro = "赤";
		kami.maisu = 1;
		System.out.println("オブジェクトkamiの形は"+kami.katachi);
		System.out.println("色は"+kami.iro);
		System.out.println(kami.katachi + "を作るのに使う枚数は"+kami.maisu);
	}
}

class Origami {
	String katachi;
	String iro;
	int maisu;
}
