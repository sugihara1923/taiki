
class chapter11_2 {
    public static void main(String[] args) {
        MyThread th = new MyThread();
        th.start();
    }
}

class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
