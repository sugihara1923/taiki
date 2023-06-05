import java.io.*;

class chapter9_6_1 {
    static int zeiritsu;
    static int kakaku;
    static int zeikomi;

    public static void main(String[] args) throws IOException {
        calcTax();
    }

    public static void calcTax() throws IOException {
        zeiritsu = input("消費税の税率は？");
        kakaku = input("消費税抜きの価格は？");
        zeikomi = kakaku + kakaku * zeiritsu / 100;
        System.out.println("消費税込みの金額は" + zeikomi + "円になります");
    }

    public static int input(String txt) throws IOException {
        System.out.println(txt);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        try{
            str = br.readLine();
        }catch(IOException e){
            System.out.println(e);
        }
        return Integer.parseInt(str);
    }
}
