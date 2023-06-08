//カプセル化の確認用プログラムです

class chapter14_8_2 {
	public static void main(String[] args) {
		CarCap car1 = new CarCap("ＢＭＷ(スポーツタイプ)", 2018, 2200);
//		car1.price = 220;//コンパイルエラーとなる
		car1.show();
		CarCap car2 = new CarCap("ＢＭＷ(中古のセダン)", 2008, 220);
		car2.show();
	}
}

class CarCap {
	private String name;
	private int model;
	private int price;
	CarCap(String name, int model, int price) {
		this.name = name;
		this.model = model;
		this.price = price;
	}
	public void show() {
		System.out.println("車種 " + name);
		System.out.println("年式 " + model);
		System.out.println("価格 " + price + "万円");
	}
	public void setPrice(int val) {
		if(val <= 0) {
			System.out.println("価格が0円以下になっています");
		}
		else {
			price = val;
		}
	}
	public int getPrice() {
		return price;
	}
}
