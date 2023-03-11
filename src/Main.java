import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        int matrixSize = 1500;
        Matrix a = Matrix.RandomMatrix(matrixSize, matrixSize);
        Matrix b = Matrix.RandomMatrix(matrixSize, matrixSize);

        long start = 0;
        long end = 0;

        // consistent
        start = System.nanoTime();
        Consistent consistent = new Consistent();
        consistent.Multiply(a, b);
        end = System.nanoTime() - start;
        System.out.println("Consistent:" + end / 1000000);

        // strip
        start = System.nanoTime();
        StripThreads stripThreads = new StripThreads();
        stripThreads.Multiply(a, b);
        end = System.nanoTime() - start;
        System.out.println("Strip:" + end / 1000000);

        // fox
        start = System.nanoTime();
        FoxThreads foxThreads = new FoxThreads();
        Matrix c = foxThreads.Multiply(a, b, 10);
        end = System.nanoTime() - start;
        System.out.println("Fox:" + end / 1000000);
    }
}