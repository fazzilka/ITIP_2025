package LR_7;

public class ArraySum{
    static class SumArray implements Runnable {
        private final int[] array;
        private final int start;
        private final int end;
        private int partialSum;

        public SumArray(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
            this.partialSum = 0;
        }

        @Override
        public void run() {
            for (int i = start; i < end; i++) {
                partialSum += array[i];
            }
        }

        public int getPartialSum() {
            return partialSum;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int mid = array.length / 2;

        SumArray firstHalf = new SumArray(array, 0, mid);
        SumArray secondHalf = new SumArray(array, mid, array.length);

        Thread thread1 = new Thread(firstHalf);
        Thread thread2 = new Thread(secondHalf);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int totalSum = firstHalf.getPartialSum() + secondHalf.getPartialSum();
        System.out.println("Сумма: " + totalSum);
    }
}