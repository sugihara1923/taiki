public class kuku {
    public static void main(String[] args) throws Exception {
        for (int y = 1; y <= 9; y++) {
            System.out.print(y + "の段");
            for (int x = 1; x <= 9; x++) {
                int k = x * y;
                System.out.print(k + " ");
            }
            System.out.println("");
        }
    }
}
