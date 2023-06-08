

class chapter14_5_1 {
	public static void main(String[] args) {
		System.out.println("Vehicle.countの値" + Vehicle.count);
		Vehicle car = new Vehicle("コンパクトカー");
		System.out.println(car.name);
		System.out.println("Vehicle.countの値" + Vehicle.count);
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
