import java.io.*;

class chapter9_5_1 {
    static int zeiritsu;
    static int kakaku;
    static int zeikomi;

    public static void main(String[] args) throws IOException {
        calcTax();
    }

    public static void calcTax() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("消費税の税率は？");
        String str = br.readLine();
        zeiritsu = Integer.parseInt(str);
        System.out.println("消費税抜きの価格は？");
        str = br.readLine();
        kakaku = Integer.parseInt(str);
        zeikomi = kakaku + kakaku * zeiritsu / 100;
        System.out.println("消費税込みの金額は" + zeikomi + "円になります");
    }
}
