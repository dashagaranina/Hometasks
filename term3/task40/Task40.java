import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class Task40 extends RecursiveAction {
    private static final int SEQUENTIAL_THRESHOLD = 5;

    private final int[] m;
    private final int[] temp;
    private final int start;
    private final int end;

    public Task40(int[] m, int start, int end) {
        this.m = m;
        this.start = start;
        this.end = end;
        this.temp = new int[m.length];
    }

    public Task40(int[] m) {
        this(m, 0, m.length-1);
    }

    @Override
    protected void compute() {
        int length = end - start;
        if (length < SEQUENTIAL_THRESHOLD) {
            sort();
        } else {
            final int center = length / 2;
            System.out.println("start = " + start);
            System.out.println("center = " + center);
            System.out.println("end = " + end);
            final Task40 left = new Task40(m, start, start + center);
            final Task40 right = new Task40(m, start + center + 1, end);
            ForkJoinTask.invokeAll(left, right);
            merge(m, temp, start, center, end);
        }
    }

    private static void merge(int[] a, int[] tmpArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (a[leftPos] <= a[rightPos]) {
                tmpArray[tmpPos++] = a[leftPos++];
            } else {
                tmpArray[tmpPos++] = a[rightPos++];
            }
        }

        //копируем остаток левой части
        while (leftPos <= leftEnd) {
            tmpArray[tmpPos++] = a[leftPos++];
        }

        //копируем остаток правой части
        while (rightPos <= rightEnd) {
            tmpArray[tmpPos++] = a[rightPos++];
        }

        //копируем результат слияния из временного массива
        for (int i = 0; i < numElements; i++, rightEnd--) {
            a[rightEnd] = tmpArray[rightEnd];
        }
    }

    private void sort() {
        for (int i = start; i < end; i++) {
            for (int j = i + 1; j < end; j++) {
                if (m[i] > m[j]) {
                    int tmp = m[i];
                    m[i] = m[j];
                    m[j] = tmp;
                }
            }
        }
    }


    public static void main(String args[]) {
        final int[] m = new int[10];
        final Random random = new Random();
        for (int i = 0; i < m.length; i++) {
            m[i] = random.nextInt(100);
        }
        final ForkJoinPool pool = new ForkJoinPool(4);
        final Task40 sortt = new Task40(m);
        pool.invoke(sortt);
        for (int i = 0; i < m.length; i++) {
            System.out.println(m[i]);
        }
    }
}
