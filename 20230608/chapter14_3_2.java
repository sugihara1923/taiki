
class chapter14_3_2 {
    public static void main(String[] args) {
        OrigamiC kami1 = new OrigamiC("鶴", "赤", 1);
        OrigamiC kami2 = new OrigamiC("手裏剣", "青", 2);
        System.out.print("kami1の形は" + kami1.katachi);
        System.out.print("、色は" + kami1.iro);
        System.out.println("、作るのに使う枚数は" + kami1.maisu);
        System.out.print("kami2の形は" + kami2.katachi);
        System.out.print("、色は" + kami2.iro);
        System.out.println("、作るのに使う枚数は" + kami2.maisu);
    }
}

class OrigamiC {
    String katachi;
    String iro;
    int maisu;

    OrigamiC(String k, String i, int m) {
        katachi = k;
        iro = i;
        maisu = m;
    }
}
