public class chapter14_3_4 {
    public static void main(String[] args) {
		OrigamiM[] kami = new OrigamiM[3];
		kami[0] = new OrigamiM("鶴", "赤", 1);
		kami[1] = new OrigamiM("手裏剣", "青", 2);
		kami[2] = new OrigamiM("飛行機", "緑", 1);
		for(int i=0; i<=2; i++) kami[i].setsumei(i);
	}
}

class OrigamiM {
	String katachi;
	String iro;
	int maisu;
	OrigamiM(String katachi, String iro, int maisu) {
		this.katachi = katachi;
		this.iro = iro;
		this.maisu = maisu;
	}
	void setsumei(int n) {
		System.out.print("kami[" + n + "]の形は" + katachi);
		System.out.print("、色は" + iro);
		System.out.println("、作るのに使う枚数は" + maisu);
	}
}


