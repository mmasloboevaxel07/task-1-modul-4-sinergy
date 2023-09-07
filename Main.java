package fourth_modul.one;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 100; i++) { // для запуска несколько раз
            Counter counter = new Counter();

            Thread thread1 = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                }
            });

            Thread thread2 = new Thread(() -> {
                for (int l = 0; l < 1000; l++) {
                    counter.increment();
                }
            });

            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();

            System.out.println(counter.getValue()); // результат будет разным, т.к. потоки не синхронизированы
        }
    }
}
