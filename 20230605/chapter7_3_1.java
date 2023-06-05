public class chapter7_3_1 {
    public static void main(String[] args) throws Exception {
        System.out.println("生後1年後の猫は、人間でいえば"+catAge(1)+"歳");
        System.out.println("15年生きた猫は、人間でいえば"+catAge(15)+"歳");
        System.out.println("22年生きた猫は、人間でいえば"+catAge(22)+"歳");
    }

    static int catAge(int year) {
        return 18+(year-1)*4;
    }
}
