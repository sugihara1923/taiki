class chapter11_3{
    public static void main(String[] args) {
		MyThread th = new MyThread();
		th.start();
		System.out.println("Mainメソッド処理は通常通り進みます");
	}

}
class MyThread extends Thread {
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("スレッドの処理"+i);
			try{ sleep(1000); } catch(InterruptedException e) {}
		}
	}
}

