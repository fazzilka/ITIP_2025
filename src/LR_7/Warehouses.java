package LR_7;

import java.util.concurrent.Semaphore;

public class Warehouses {
    private static final int MAX_WEIGHT = 150;
    private static final Semaphore semaphore = new Semaphore(3);
    private static int[] items = {10, 20, 30, 40, 50, 60, 70, 80, 90, 30};
    private static int currentIndex = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread loader1 = new Thread(new Loader("Грузчик 1"));
        Thread loader2 = new Thread(new Loader("Грузчик 2"));
        Thread loader3 = new Thread(new Loader("Грузчик 3"));

        loader1.start();
        loader2.start();
        loader3.start();
    }

    static class Loader implements Runnable {
        private String name;

        public Loader(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    semaphore.acquire();

                    int totalWeight = 0;
                    StringBuilder itemsToLoad = new StringBuilder();

                    while (true) {
                        int itemWeight;

                        synchronized (lock) {
                            if (currentIndex >= items.length) {
                                break;
                            }
                            itemWeight = items[currentIndex];
                            currentIndex++;
                        }

                        if (totalWeight + itemWeight <= MAX_WEIGHT) {
                            totalWeight += itemWeight;
                            itemsToLoad.append(itemWeight).append(" кг, ");
                        } else {

                            synchronized (lock) {
                                currentIndex--;
                            }
                            break;
                        }
                    }

                    if (totalWeight > 0) {
                        System.out.println(name + " загрузил -> " + itemsToLoad + "общим весом " + totalWeight + " кг.");
                        System.out.println(name + " отправляется на разгрузку........");
                        Thread.sleep(5000);
                        System.out.println(name + " вернулся на склад.");
                    }

                    semaphore.release();

                    if (currentIndex >= items.length) {
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}