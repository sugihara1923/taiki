import java.io.Console;

class chapter9_7_2 {
    public static void main(String[] args) {
        System.out.println("consoleで文字列の入力を行います");
        Console con = System.console();
        String str = con.readLine();
        System.out.println("入力した文字列は" + str);

    }

}
