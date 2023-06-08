
class chapter14_5_3 {
    public static void main(String[] args) {
        VehicleCm.getCount();
        VehicleCm[] car = new VehicleCm[7];
        for (int i = 0; i < 7; i++) {
            car[i] = new VehicleCm("コンパクトカー" + i);
            System.out.println(car[i].name);
        }
        VehicleCm.getCount();
    }
}

class VehicleCm {
    static int count;
    String name;

    VehicleCm(String name) {
        this.name = name;
        count++;
    }

    static void getCount() {
        System.out.println("countの値は" + count);
    }
}
