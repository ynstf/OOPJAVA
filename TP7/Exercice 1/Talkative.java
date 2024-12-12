public class Talkative implements Runnable {
    private int attribute;

    public Talkative(int attribute) {
        this.attribute = attribute;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(attribute);
        }
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            Talkative talkative = new Talkative(i);
            threads[i] = new Thread(talkative);
            threads[i].start();
        }
    }
}
