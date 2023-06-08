class TestOverload {
	public static void main(String[] args) {
		add(1, 2);
		add(0.5, 6.5);
		add(1, 0.2);
	}

	static void add(int a, int b) {
		int c = a+b;
		System.out.println("int型 "+c);
	}

	static void add(double a, double b) {
		double c = a+b;
		System.out.println("double型 "+c);
	}
}
