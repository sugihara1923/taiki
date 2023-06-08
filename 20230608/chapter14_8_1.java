
    

class chapter14_8_1 {
	public static void main(String[] args) {
		Car car1 = new Car("ＢＭＷ(スポーツタイプ)", 2018, 2200);
		car1.price = 220;
		car1.show();
		Car car2 = new Car("ＢＭＷ(中古のセダン)", 2008, 220);
		car2.show();
	}
}

class Car {
	String name;
	int model;
	int price;
	Car(String name, int model, int price) {
		this.name = name;
		this.model = model;
		this.price = price;
	}
	void show() {
		System.out.println("車種 " + name);
		System.out.println("年式 " + model);
		System.out.println("価格 " + price + "万円");
	}
}
