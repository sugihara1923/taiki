public class omikuji1 {
    public static void main(String[] args) throws Exception {
        int r = (int) (Math.random() * 4);
        switch(r){
            case 0:
            System.out.println("大吉");
            break;
            case 1:
            System.out.println("中吉");
            break;
            case 2:
            System.out.println("小吉");
            break;
            case 3:
            System.out.println("凶");
            break;
        }
    }
}
