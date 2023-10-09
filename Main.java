public class Main {
    public static void main(String[] args) {
        Thread chickenThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Курица");
                try {
                    Thread.sleep(1000); // Пауза между выводами "Курица"
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread eggThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Яйцо");
                try {
                    Thread.sleep(1000); // Пауза между выводами "Яйцо"
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        chickenThread.start();
        eggThread.start();

        try {
            chickenThread.join();
            eggThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Определение победителя спора
        if (chickenThread.isAlive()) {
            System.out.println("Спор выиграла курица!");
        } else if (eggThread.isAlive()) {
            System.out.println("Спор выиграло яйцо!");
        } else {
            System.out.println("Спор закончился ничьей!");
        }
    }
}
