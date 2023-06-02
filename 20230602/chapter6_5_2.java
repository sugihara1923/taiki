public class chapter6_5_2 {
    public static void main(String[] args) throws Exception {
        int []a = {1,2,3};
        System.out.println("a[0]=" + a[0]);
        int[] b = a;
        System.out.println("b[0]=" + b[0]);
        a[0] = 10;
        System.out.println("a[0]=" + a[0]);
        System.out.println("b[0]=" + b[0]);

    }
}
