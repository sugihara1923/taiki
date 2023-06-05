public class chapter7_4_2 {
    static String txt = "今日はフィールドの勉強をしています";
    public static void main(String[] args) throws Exception {
        System.out.println(txt);
        txt = "フィールドはクラス内の冒頭に宣言しましょう";
        System.out.println(txt);
        test();
        System.out.println(txt);
    }
    static void test(){
        txt = "フィールドはクラス内の全てのメソッドで利用できます";
    }
}
