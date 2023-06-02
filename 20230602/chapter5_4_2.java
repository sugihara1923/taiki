public class chapter5_4_2 {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 100; i++) {
            if(i%3==0)continue;
            System.out.print(i + ",");
        }
    }
}
