public class chapter11_4_1 {
    public static void main(String[] args) {
		Thread_A ta = new Thread_A();
		ta.start();
		Thread_B tb = new Thread_B();
		tb.start();
	}
}

class Thread_A extends Thread {
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("スレッド：A"+i);
			try {sleep(1000);} catch(InterruptedException e) {}
		}
	}
}

class Thread_B extends Thread {
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("スレッド：B"+i);
			try {sleep(2000);} catch(InterruptedException e) {}
		}
	}
}

