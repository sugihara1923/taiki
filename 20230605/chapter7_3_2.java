public class chapter7_3_2 {
    public static void main(String[] args) throws Exception {
        double menseki = sanMen(7, 5);
        double menseki2 = sanMen(10, 3);
        System.out.println("底辺7㎝、高さ5㎝の三角形の面積ば"+menseki+"cm2です");
        System.out.println("底辺10㎝、高さ3㎝の三角形の面積ば"+menseki2+"cm2です");
        
    }
    static double sanMen(double teihen,double takasa){
        return teihen*takasa/2;
    }
}
