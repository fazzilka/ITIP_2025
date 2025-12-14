package LR_7;

public class BiggestNumber {

    static class FindMaxInRow implements Runnable {
        private final int[] row;
        private final int rowIndex;
        private int max;

        public FindMaxInRow(int[] row, int rowIndex) {
            this.row = row;
            this.rowIndex = rowIndex;
            this.max = Integer.MIN_VALUE;
        }

        @Override
        public void run() {
            max = findMaxInRow(row);
            System.out.println("Максимум в строке " + rowIndex + ": " + max);
        }

        public int getMax() {
            return max;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 8, 2, 10},
                {5, 1, 7, 6},
                {12, 14, 4, 9},
                {11, 15, 13, 0}
        };

        int rows = matrix.length;
        int[] maxInRows = new int[rows];
        Thread[] threads = new Thread[rows];
        FindMaxInRow[] tasks = new FindMaxInRow[rows];

        for (int i = 0; i < rows; i++) {
            tasks[i] = new FindMaxInRow(matrix[i], i);
            threads[i] = new Thread(tasks[i]);
            threads[i].start();
        }

        for (int i = 0; i < rows; i++) {
            try {
                threads[i].join();
                maxInRows[i] = tasks[i].getMax();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int overallMax = findMaxInRow(maxInRows);
        System.out.println("Наибольший элемент в матрице: " + overallMax + " \nДлина матрицы: " + rows);
    }

    public static int findMaxInRow(int[] row) {
        int max = row[0];
        for (int num : row) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
