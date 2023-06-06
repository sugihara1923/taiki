public class chapter11_4_2 {
    public static void main(String[] args) {
		Thread_C ta = new Thread_C("スレッド：A", 1000);
		ta.start();
		Thread_C tb = new Thread_C("スレッド：B:", 2000);
		tb.start();
	}
}

class Thread_C extends Thread {
	String name;
	int stime;
	Thread_C(String na, int st) {
		name = na;
		stime = st;
	}
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println(name+i);
			try {sleep(stime);} catch(InterruptedException e) {}
		}
	}
}
