class chapter14_5_2 {
    public static void main(String[] args) {
        Vehicle[] car = new Vehicle[5];
        for (int i = 0; i < 5; i++) {
            car[i] = new Vehicle("セダン" + i);
            System.out.println(car[i].name);
        }
        System.out.println("Vehicle.countの値" + Vehicle.count);
        System.out.println("car[0].countの値" + car[0].count);
        System.out.println("car[4].countの値" + car[4].count);
    }
}

class Vehicle {
    static int count;
    String name;

    Vehicle(String name) {
        this.name = name;
        count++;
    }
}
