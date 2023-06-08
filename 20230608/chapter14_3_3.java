public class chapter14_3_3 {
    public static void main(String[] args) {
		OrigamiA[] kami = new OrigamiA[3];
		kami[0] = new OrigamiA("鶴", "赤", 1);
		kami[1] = new OrigamiA("手裏剣", "青", 2);
		kami[2] = new OrigamiA("飛行機", "緑", 1);
		for(int i=0; i<=2; i++) {
			System.out.print("kami[" + i + "]の形は" + kami[i].katachi);
			System.out.print("、色は" + kami[i].iro);
			System.out.println("、作るのに使う枚数は" + kami[i].maisu);
		}
	}
}

class OrigamiA {
	String katachi;
	String iro;
	int maisu;
	OrigamiA(String k, String i, int m) {
		katachi = k;
		iro = i;
		maisu = m;
	}
}


