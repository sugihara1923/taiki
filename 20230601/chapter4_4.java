public class chapter4_4 {
    public static void main(String[] args) throws Exception {
        int n = -5;
        System.out.println("元のnの値は"+n);
        if (n > 0){
            System.out.println("nは正の整数であり、10倍しました");
            n = n*10;
        }else if(n<0){
            System.out.println("nは負の整数であり、-1を掛け正の整数に変えます");
            n = n*-1;
        }else{
            System.out.println("nは0であり、変化させません");
        }
        System.out.println("計算後のnは"+n);
    }  
}
