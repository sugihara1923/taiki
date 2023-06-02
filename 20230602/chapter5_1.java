public class chapter5_1 {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
        for (int m = 0; m <= 100; m++) {
            System.out.print(m + ",");
        }
        for (int n = 0; n <= 100; n = n + 5) {
            System.out.print(n + ",");
        }
    }
}
